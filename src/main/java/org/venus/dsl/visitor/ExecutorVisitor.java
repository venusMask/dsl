package org.venus.dsl.visitor;

import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.node.*;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.output.*;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ExecutorVisitor
        extends AstVisitor<Object, TreeNode> {

    private final Analyze analyze;

    private String currentRuleGroup;

    public ExecutorVisitor(Analyze analyze) {
        this.analyze = analyze;
    }

    @Override
    public Object visitRuleDefinition(RuleDefinitionNode node, TreeNode context) {
        return matchRules(node.getRuleLogics(), 0, context);
    }

    @SuppressWarnings("unchecked")
    private boolean matchRules(List<RuleLogicNode> ruleLogics,
                               int index,
                               TreeNode context) {
        if (index >= ruleLogics.size()) {
            return true;
        }
        RuleLogicNode currentRule = ruleLogics.get(index);
        List<TreeNode> matchedNodes = (List<TreeNode>) process(currentRule, context);
        if (matchedNodes == null || matchedNodes.isEmpty()) {
            return false;
        }
        for (TreeNode childNode : matchedNodes) {
            if (matchRules(ruleLogics, index + 1, childNode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitRuleLogic(RuleLogicNode node, TreeNode context) {
        OperationType operationType = node.getOperationType();
        List<TreeNode> lhsObj = (List<TreeNode>) process(node.getLhs(), context);
        List<TreeNode> rhsObj = (List<TreeNode>) process(node.getRhs(), context);
        if (operationType == OperationType.EQUAL) {
            return OperationTypeVisitor.equal(lhsObj, rhsObj);
        } else if (operationType == OperationType.NotEqual) {
           return OperationTypeVisitor.notEqual(lhsObj, rhsObj);
        } else if (operationType == OperationType.IN) {
            return OperationTypeVisitor.contains(lhsObj, rhsObj);
        } else if (operationType == OperationType.CONTAINS) {
            return OperationTypeVisitor.contains(lhsObj, rhsObj);
        } else if (operationType == OperationType.NotContains) {
            return OperationTypeVisitor.notContains(lhsObj, rhsObj);
        } else if (operationType == OperationType.GT) {
            return OperationTypeVisitor.gt(lhsObj, rhsObj);
        } else if (operationType == OperationType.GE) {
            return OperationTypeVisitor.ge(lhsObj, rhsObj);
        } else if (operationType == OperationType.LE) {
            return OperationTypeVisitor.le(lhsObj, rhsObj);
        } else if (operationType == OperationType.LT) {
            return OperationTypeVisitor.lt(lhsObj, rhsObj);
        }
        throw new IllegalStateException("Unsupported operation type: " + operationType);
    }

    @Override
    public Object visitSingleRule(SingleRuleNode node, TreeNode context) {
        analyze.initSingleRule(node);
        RuleGroupNode ruleGroup = node.getRuleGroup();
        return process(ruleGroup, context);
    }

    @Override
    public Object visitMultipleRule(MultipleRuleNode node, TreeNode context) {
        analyze.initMultipleRules(node);
        return process(node.getAssertion(), context);
    }

    @Override
    public Object visitMatch(MatchNode node, TreeNode context) {
        LogicExprNode logicExprNode = node.getLogicExpr();
        Boolean flag = (Boolean) process(logicExprNode, context);
        if(flag) {
            return process(node.getOutputExpr(), context);
        } else {
            return null;
        }
    }

    // TODO
    @Override
    public Object visitDictMapping(DictMappingNode node, TreeNode context) {
        return super.visitDictMapping(node, context);
    }

    @Override
    public Object visitExcludeLogicExpr(ExcludeLogicExprNode node, TreeNode context) {
        Object flag = process(node.getLogicExpr(), context);
        return !(boolean) flag;
    }

    @Override
    public Object visitNestedLogicExpr(NestedLogicExprNode node, TreeNode context) {
        return process(node.getChild(), context);
    }

    @Override
    public Object visitStandardLogicExpr(StandardLogicExprNode node, TreeNode context) {
        LogicExprNode leftLogicExpr = node.getLeftLogicExpr();
        Boolean flag = (Boolean) process(leftLogicExpr, context);
        OperationType operationType = node.getOperationType();
        if (operationType == OperationType.AND) {
            if (!flag) { return false; }
        } else if (operationType == OperationType.OR) {
            if (flag) { return true; }
        }
        return process(node.getRightLogicExpr(), context);
    }

    /**
     * 此处需要判断当前正在执行的是哪一个ruleGroup
     */
    @Override
    public Object visitValueLogicExpr(ValueLogicExprNode node, TreeNode context) {
        String ruleCode = node.getRuleCode();
        Boolean isSingleRule = analyze.getIsSingleRule();
        if(isSingleRule) {
            RuleDefinitionNode ruleDefinition = analyze.getRuleDefinitionNode(currentRuleGroup, ruleCode);
            return process(ruleDefinition, context);
        } else {
            RuleGroupNode ruleGroup = analyze.getRuleGroup(ruleCode);
            analyze.setIsSingleRule(true);
            Object ruleGroupValue = process(ruleGroup, context);
            analyze.setIsSingleRule(false);
            return Objects.equals(ruleGroupValue, "是");
        }
    }

    @Override
    public Object visitValueTake(ValueTakeNode node, TreeNode context) {
        return super.visitValueTake(node, context);
    }

    @Override
    public Object visitDirectTake(DirectTakeNode node, TreeNode context) {
        String directValue = node.getDirectValue();
        return Collections.singletonList(TreeNode.build(directValue, directValue));
    }

    @Override
    public Object visitFieldTake(FieldTakeNode node, TreeNode context) {
        String fieldName = node.getFieldName();
        return TreeNode.searchValues(context, fieldName);
    }

    @Override
    public Object visitListTake(ListTakeNode node, TreeNode context) {
        List<String> values = node.getValues();
        ArrayList<TreeNode> treeNodes = new ArrayList<>(values.size());
        values.forEach(x -> treeNodes.add(TreeNode.build(x, x)));
        return treeNodes;
    }

    @Override
    public Object visitRuleTake(RuleTakeNode node, TreeNode context) {
        return super.visitRuleTake(node, context);
    }

    @Override
    public Object visitStandardOutput(StandardOutputNode node, TreeNode context) {
        Object leftValue = process(node.getLeftOutputExpr(), context);
        Object rightValue = process(node.getRightOutputExpr(), context);
        OperationType operationType = node.getOperationType();
        if (operationType == OperationType.ADD) {
            return (Long) leftValue + (Long) rightValue;
        } else if (operationType == OperationType.SUBTRACT) {
            return (Long) leftValue - (Long) rightValue;
        } else if (operationType == OperationType.MULTIPLY) {
            return (Long) leftValue * (Long) rightValue;
        } else if (operationType == OperationType.DIVIDE) {
            return (Long) leftValue / (Long) rightValue;
        }
        throw new IllegalStateException("Unsupported operation type: " + operationType);
    }

    @Override
    public Object visitValueOutput(ValueOutputNode node, TreeNode context) {
        return node.getOutputValue();
    }

    @Override
    public Object visitFieldOutput(FieldOutputNode node, TreeNode context) {
        String fieldName = node.getFieldName();
        List<TreeNode> values = TreeNode.searchValues(context, fieldName);
        return values.get(0).getFieldValue();
    }

    @Override
    public Object visitFunctionOutput(FunctionOutputNode node, TreeNode context) {
        String functionName = node.getFunctionName();
        List<OutputExprNode> polyExprNode = node.getParams();
        ArrayList<Object> param = new ArrayList<>(polyExprNode.size());
        polyExprNode.forEach(p -> {
            Object result = process(p, context);
            param.add(result);
        });
        // TODO 获取函数的执行结果
        return "function result";
    }

    @Override
    public Object visitNestedOutput(NestedOutputNode node, TreeNode context) {
        OutputExprNode child = node.getChild();
        return process(child, context);
    }

    @Override
    public Object visitRuleGroup(RuleGroupNode node, TreeNode context) {
        currentRuleGroup = node.getRuleDeclare().getRuleCode();
        log.info("currentRuleGroup: " + currentRuleGroup);
        return process(node.getAssertion(), context);
    }

    @Override
    public Object visitAssertion(AssertionNode node, TreeNode context) {
        List<MatchNode> matchNodes = node.getMatches();
        List<OutputExprNode> otherOutput = node.getOtherOutputs();
        for (MatchNode matchNode : matchNodes) {
            Object result = process(matchNode, context);
            if(result != null) {
                return result;
            }
        }
        return process(otherOutput.get(0), context);
    }

}
