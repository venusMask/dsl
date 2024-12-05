package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.RuleDefinitionNode;
import org.venus.dsl.parse.node.RuleGroupNode;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.analyze.Analyze;

import java.util.Objects;

/**
 * 分析单条规则的执行结果, 在外层控制是否要进行短路处理.
 */
@AllArgsConstructor
public class LogicExprVisitor implements BaseVisitor {

    private final LogicExprNode node;

    private final Analyze analyze;

    private final String ruleGroupID;

    @Override
    public Boolean visit(TreeNode TreeNode) {
        if (node instanceof ValueLogicExprNode) {
            ValueLogicExprNode realNode = (ValueLogicExprNode) node;
            String ruleCode = realNode.getRuleCode();
            Boolean isSingleRule = analyze.getIsSingleRule();
            if (isSingleRule) {
                RuleDefinitionNode ruleDefinitionNode = analyze.getRuleDefinitionNode(ruleGroupID, ruleCode);
                return new RuleDefinitionVisitor(ruleDefinitionNode, analyze).visit(TreeNode);
            } else {
                RuleGroupNode ruleGroup = analyze.getRuleGroup(ruleCode);
                analyze.setIsSingleRule(true);
                Object ruleGroupValue = new RuleGroupVisitor(ruleGroup, analyze).visit(TreeNode);
                analyze.setIsSingleRule(false);
                return Objects.equals(ruleGroupValue, "是");
            }
        } else if (node instanceof ExcludeLogicExprNode) {
            ExcludeLogicExprNode tmpNode = (ExcludeLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getLogicExpr(), analyze, ruleGroupID);
            Object flag = visitor.visit(TreeNode);
            return !(boolean) flag;
        } else if (node instanceof NestedLogicExprNode) {
            NestedLogicExprNode tmpNode = (NestedLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getChild(), analyze, ruleGroupID);
            Object flag = visitor.visit(TreeNode);
            return (boolean) flag;
        } else if (node instanceof StandardLogicExprNode) {
            StandardLogicExprNode tmpNode = (StandardLogicExprNode) node;
            Boolean leftFlag = new LogicExprVisitor(tmpNode.getLeftLogicExpr(), analyze, ruleGroupID).visit(TreeNode);
            OperationType operationType = tmpNode.getOperationType();
            if (operationType == OperationType.AND) {
                if (!leftFlag) {
                    return false;
                }
                return new LogicExprVisitor(tmpNode.getRightLogicExpr(), analyze, ruleGroupID).visit(TreeNode);
            } else if (operationType == OperationType.OR) {
                if (leftFlag) {
                    return true;
                }
                return new LogicExprVisitor(tmpNode.getRightLogicExpr(), analyze, ruleGroupID).visit(TreeNode);
            }
        }
        return null;
    }

}
