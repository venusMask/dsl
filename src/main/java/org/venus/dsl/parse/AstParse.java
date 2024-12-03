package org.venus.dsl.parse;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.venus.dsl.parse.node.*;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.output.*;
import org.venus.dsl.ast.DslBaseVisitor;
import org.venus.dsl.ast.DslParser;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.parse.node.value.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AstParse extends DslBaseVisitor<Node> {

    @Override
    public SingleRuleNode visitSingleRule(DslParser.SingleRuleContext ctx) {
        DslParser.RuleGroupContext ruleGroupCxt = ctx.ruleGroup();
        RuleGroupNode ruleGroupNode = (RuleGroupNode) visit(ruleGroupCxt);
        return SingleRuleNode.builder()
                .ruleGroup(ruleGroupNode)
                .build();
    }

    @Override
    public MultipleRuleNode visitMultipleRule(DslParser.MultipleRuleContext ctx) {
        RuleDeclareNode ruleDeclareNode = (RuleDeclareNode) visit(ctx.ruleDeclare());
        List<DslParser.RuleGroupContext> ruleGroupContexts = ctx.ruleGroup();
        ArrayList<RuleGroupNode> ruleGroupNodes = new ArrayList<>(ruleGroupContexts.size());
        for (DslParser.RuleGroupContext ruleGroupContext : ruleGroupContexts) {
            ruleGroupNodes.add((RuleGroupNode) visit(ruleGroupContext));
        }
        AssertionNode assertionNode = (AssertionNode) visit(ctx.assertion());
        return MultipleRuleNode.builder()
                .ruleDeclare(ruleDeclareNode)
                .ruleGroups(ruleGroupNodes)
                .assertion(assertionNode)
                .build();
    }

    @Override
    public RuleGroupNode visitRuleGroup(DslParser.RuleGroupContext ctx) {
        RuleDeclareNode ruleDeclareNode = visitRuleDeclare(ctx.ruleDeclare());
        AssertionNode assertion = visitAssertion(ctx.assertion());
        List<DslParser.RuleDefinitionContext> ruleDefinitionContexts = ctx.ruleDefinition();
        ArrayList<RuleDefinitionNode> nodes = new ArrayList<>(ruleDefinitionContexts.size());
        for (DslParser.RuleDefinitionContext context : ruleDefinitionContexts) {
            nodes.add(visitRuleDefinition(context));
        }
        return RuleGroupNode.builder()
                .ruleDeclare(ruleDeclareNode)
                .ruleDefinition(nodes)
                .assertion(assertion)
                .build();
    }

    @Override
    public RuleDeclareNode visitRuleDeclare(DslParser.RuleDeclareContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        String ruleName = ctx.ruleName.getText();
        return RuleDeclareNode.builder()
                .ruleCode(ruleCode)
                .ruleName(ruleName)
                .build();
    }

    @Override
    public RuleDefinitionNode visitRuleDefinition(DslParser.RuleDefinitionContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        List<DslParser.RuleLogicContext> contexts = ctx.ruleLogic();
        ArrayList<RuleLogicNode> nodes = new ArrayList<>(contexts.size());
        for (DslParser.RuleLogicContext context : contexts) {
            RuleLogicNode node = (RuleLogicNode) visit(context);
            nodes.add(node);
        }
        return RuleDefinitionNode.builder()
                .ruleCode(ruleCode)
                .operations(nodes)
                .build();
    }

    @Override
    public AssertionNode visitAssertion(DslParser.AssertionContext ctx) {
        List<DslParser.MatchContext> matchContexts = ctx.match();
        ArrayList<MatchNode> matchNodes = new ArrayList<>(matchContexts.size());
        for (DslParser.MatchContext context : matchContexts) {
            MatchNode childNode = visitMatch(context);
            matchNodes.add(childNode);
        }
        List<DslParser.OutputExprContext> polyContexts = ctx.outputExpr();
        ArrayList<OutputExprNode> polyNodes = new ArrayList<>(polyContexts.size());
        for (DslParser.OutputExprContext context : polyContexts) {
            polyNodes.add((OutputExprNode) visit(context));
        }
        return AssertionNode.builder()
                .matches(matchNodes)
                .otherOutputs(polyNodes)
                .build();
    }

    private ArrayList<DictMappingNode>
    loadDictNodes(List<DslParser.DictMappingContext> dictContexts) {
        if (dictContexts == null || dictContexts.isEmpty()) {
            return null;
        }
        ArrayList<DictMappingNode> dictNodes = new ArrayList<>(dictContexts.size());
        for (DslParser.DictMappingContext dictContext : dictContexts) {
            DictMappingNode dictNode = (DictMappingNode) visit(dictContext);
            dictNodes.add(dictNode);
        }
        return dictNodes;
    }

    private RuleLogicNode
    visitRuleLogicContext(DslParser.RuleLogicContext context,
                          OperationType operationType) {
        DslParser.ValueTakeContext lhs = context.getRuleContext(DslParser.ValueTakeContext.class, 0);
        DslParser.ValueTakeContext rhs = context.getRuleContext(DslParser.ValueTakeContext.class, 1);
        ValueTakeNode lhsNode = (ValueTakeNode) visit(lhs);
        ValueTakeNode rhsNode = (ValueTakeNode) visit(rhs);
        ArrayList<DictMappingNode> dictNodes = loadDictNodes(context.getRuleContexts(DslParser.DictMappingContext.class));
        return RuleLogicNode.builder()
                .lhs(lhsNode)
                .rhs(rhsNode)
                .dictMappings(dictNodes)
                .operationType(operationType)
                .build();
    }

    @Override
    public DictMappingNode visitDictMapping(DslParser.DictMappingContext ctx) {
        String dictName = ctx.STRING_SQUARE_BRACKETS().getText();
        return DictMappingNode.builder().dictName(dictName).build();
    }

    @Override
    public Node visitEqRuleExpr(DslParser.EqRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.EQUAL);
    }

    @Override
    public Node visitNeRuleExpr(DslParser.NeRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.NotEqual);
    }

    @Override
    public Node visitInRuleExpr(DslParser.InRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.IN);
    }

    @Override
    public Node visitAddRuleExpr(DslParser.AddRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.ADD);
    }

    @Override
    public Node visitSubRuleExpr(DslParser.SubRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.SUBTRACT);
    }

    @Override
    public Node visitMulRuleExpr(DslParser.MulRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.MULTIPLY);
    }

    @Override
    public Node visitDivRuleExpr(DslParser.DivRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.DIVIDE);
    }

    @Override
    public Node visitGtRuleExpr(DslParser.GtRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.GT);
    }

    @Override
    public Node visitGeRuleExpr(DslParser.GeRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.GE);
    }

    @Override
    public Node visitContainsRuleExpr(DslParser.ContainsRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.CONTAINS);
    }

    @Override
    public MatchNode visitMatch(DslParser.MatchContext ctx) {
        LogicExprNode logicExprNode = (LogicExprNode) visit(ctx.logicExpr());
        OutputExprNode polyExprNode = (OutputExprNode) visit(ctx.outputExpr());
        return MatchNode.builder()
                .logicExpr(logicExprNode)
                .outputExpr(polyExprNode)
                .build();
    }

    @Override
    public Node visitRuleCodeLogicExpr(DslParser.RuleCodeLogicExprContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        return ValueLogicExprNode.builder()
                .ruleCode(ruleCode)
                .build();
    }

    @Override
    public Node visitNestLogicExpr(DslParser.NestLogicExprContext ctx) {
        LogicExprNode child = (LogicExprNode) visit(ctx.logicExpr());
        return NestedLogicExprNode.builder()
                .child(child)
                .build();
    }

    @Override
    public LogicExprNode visitAndLogicExpr(DslParser.AndLogicExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return StandardLogicExprNode.builder()
                .leftLogicExpr(leftValue)
                .rightLogicExpr(rightValue)
                .operationType(OperationType.AND)
                .build();
    }

    @Override
    public Node visitNotLogicExpr(DslParser.NotLogicExprContext ctx) {
        return ExcludeLogicExprNode.builder()
                .logicExpr((LogicExprNode) visit(ctx.rhs))
                .build();
    }

    @Override
    public Node visitOrLogicExpr(DslParser.OrLogicExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return StandardLogicExprNode.builder()
                .leftLogicExpr(leftValue)
                .rightLogicExpr(rightValue)
                .operationType(OperationType.OR)
                .build();
    }

    @Override
    public OutputExprNode visitFunctionOutputExpr(DslParser.FunctionOutputExprContext ctx) {
        String functionName = ctx.functionName.getText();
        List<DslParser.OutputExprContext> contexts = ctx.outputExpr();
        ArrayList<OutputExprNode> nodes = new ArrayList<>(contexts.size());
        for (DslParser.OutputExprContext context : contexts) {
            nodes.add((OutputExprNode) visit(context));
        }
        return FunctionOutputNode.builder()
                .functionName(functionName)
                .params(nodes)
                .build();
    }

    @Override
    public Node visitNumberOutputExpr(DslParser.NumberOutputExprContext ctx) {
        String number = ctx.DIGIT().getText();
        return ValueOutputNode.builder()
                .outputValue(number)
                .build();
    }

    @Override
    public Node visitStringOutputExpr(DslParser.StringOutputExprContext ctx) {
        String outputString = ctx.STRING().getText();
        outputString = trimString(outputString);
        return ValueOutputNode.builder()
                .outputValue(outputString)
                .build();
    }

    @Override
    public Node visitFieldOutputExpr(DslParser.FieldOutputExprContext ctx) {
        String fieldTake = ctx.FIELD_TAKE().getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return FieldOutputNode.builder()
                .fieldName(fieldTake)
                .build();
    }

    @Override
    public Node visitNestOutputExpr(DslParser.NestOutputExprContext ctx) {
        return NestedOutputNode.builder()
                .child((OutputExprNode) visit(ctx.outputExpr()))
                .build();
    }

    @Override
    public OutputExprNode visitMulOutputExpr(DslParser.MulOutputExprContext ctx) {
        return StandardOutputNode.builder()
                .leftOutputExpr((OutputExprNode) visit(ctx.lhs))
                .rightOutputExpr((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.MULTIPLY)
                .build();
    }

    @Override
    public Node visitDivOutputExpr(DslParser.DivOutputExprContext ctx) {
        return StandardOutputNode.builder()
                .leftOutputExpr((OutputExprNode) visit(ctx.lhs))
                .rightOutputExpr((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.DIVIDE)
                .build();
    }

    @Override
    public Node visitAddOutputExpr(DslParser.AddOutputExprContext ctx) {
        return StandardOutputNode.builder()
                .leftOutputExpr((OutputExprNode) visit(ctx.lhs))
                .rightOutputExpr((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.ADD)
                .build();
    }

    @Override
    public Node visitSubOutputExpr(DslParser.SubOutputExprContext ctx) {
        return StandardOutputNode.builder()
                .leftOutputExpr((OutputExprNode) visit(ctx.lhs))
                .rightOutputExpr((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.SUBTRACT)
                .build();
    }

    @Override
    public ValueTakeNode visitRuleTake(DslParser.RuleTakeContext ctx) {
        String id = ctx.ID().getText();
        return RuleTakeNode.builder()
                .ruleID(id)
                .valueType(ValueType.ID)
                .build();
    }

    @Override
    public Node visitFieldTake(DslParser.FieldTakeContext ctx) {
        String fieldTake = ctx.getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return FieldTakeNode.builder()
                .valueType(ValueType.FIELD)
                .fieldName(fieldTake)
                .build();
    }

    @Override
    public Node visitNumberTake(DslParser.NumberTakeContext ctx) {
        String digit = ctx.DIGIT().getText();
        return DirectTakeNode.builder()
                .directValue(digit)
                .valueType(ValueType.DIRECT)
                .build();
    }

    @Override
    public Node visitStringTake(DslParser.StringTakeContext ctx) {
        String text = ctx.STRING().getText();
        text = trimString(text);
        return DirectTakeNode.builder()
                .directValue(text)
                .valueType(ValueType.DIRECT)
                .build();
    }

    @Override
    public Node visitListTake(DslParser.ListTakeContext ctx) {
        List<TerminalNode> terminalNodes = ctx.STRING();
        ArrayList<String> list = new ArrayList<>(terminalNodes.size());
        for (TerminalNode terminalNode : terminalNodes) {
            String text = terminalNode.getText();
            text = trimString(text);
            list.add(text);
        }
        return ListTakeNode.builder()
                .valueType(ValueType.LIST)
                .values(list)
                .build();
    }

    private String
    trimString(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return "";
        } else {
            return trim.substring(1, str.length() - 1);
        }
    }

}
