package org.venus.dsl.sql.parse;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.venus.dsl.sql.ast.DslBaseVisitor;
import org.venus.dsl.sql.ast.DslParser;
import org.venus.dsl.sql.parse.node.*;
import org.venus.dsl.sql.parse.node.logic.*;
import org.venus.dsl.sql.parse.node.output.*;
import org.venus.dsl.sql.parse.node.type.OperationType;
import org.venus.dsl.sql.parse.node.type.ValueType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class AstParse extends DslBaseVisitor<Node> {

    @Override
    public SingleRuleNode visitSingleRule(DslParser.SingleRuleContext ctx) {
        List<DslParser.RuleGroupContext> ruleGroups = ctx.ruleGroup();
        ArrayList<RuleGroupNode> nodes = new ArrayList<>(ruleGroups.size());
        for (DslParser.RuleGroupContext ruleGroup : ruleGroups) {
            RuleGroupNode ruleGroupNode = visitRuleGroup(ruleGroup);
            nodes.add(ruleGroupNode);
        }
        return SingleRuleNode.builder()
                .ruleGroupNodes(nodes)
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
    public DictMappingNode visitDictMapping(DslParser.DictMappingContext ctx) {
        String dictName = ctx.STRING_SQUARE_BRACKETS().getText();
        return DictMappingNode.builder().dictName(dictName).build();
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
                .matchNodes(matchNodes)
                .otherOutput(polyNodes)
                .build();
    }

    @Override
    public MatchNode visitMatch(DslParser.MatchContext ctx) {
        LogicExprNode logicExprNode = (LogicExprNode) visit(ctx.logicExpr());
        OutputExprNode polyExprNode = (OutputExprNode) visit(ctx.outputExpr());
        return MatchNode.builder()
                .logicExprNode(logicExprNode)
                .polyExprNode(polyExprNode)
                .build();
    }

    @Override
    public LogicExprNode visitRuleItemExpr(DslParser.RuleItemExprContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        return ValueLogicExprNode.builder()
                .ruleCode(ruleCode)
                .build();
    }

    @Override
    public LogicExprNode visitParenLogicExpr(DslParser.ParenLogicExprContext ctx) {
        LogicExprNode child = (LogicExprNode) visit(ctx.logicExpr());
        return NestedLogicExprNode.builder()
                .child(child)
                .build();
    }

    @Override
    public LogicExprNode visitAndExpr(DslParser.AndExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return StandardLogicExprNode.builder()
                .leftNode(leftValue)
                .rightNode(rightValue)
                .operationType(OperationType.AND)
                .build();
    }

    @Override
    public Node visitNotExpr(DslParser.NotExprContext ctx) {
        return ExcludeLogicExprNode.builder()
                .logicExprNode((LogicExprNode)visit(ctx.rhs))
                .build();
    }

    @Override
    public Node visitOrExpr(DslParser.OrExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return StandardLogicExprNode.builder()
                .leftNode(leftValue)
                .rightNode(rightValue)
                .operationType(OperationType.OR)
                .build();
    }

    @Override
    public RuleLogicNode visitEqExpr(DslParser.EqExprContext ctx) {
        DslParser.ValueTakeContext leftValueCxt = ctx.lhs;
        ValueTakeNode leftNode = (ValueTakeNode) visit(leftValueCxt);
        ArrayList<DictMappingNode> dictNodes = loadDictNodes(ctx.dictMapping());
        DslParser.ValueContext valueContext = ctx.rhs;
        String rightNode = trimString(valueContext.getText());
        return RuleLogicNode.builder()
                .valueTakeNode(leftNode)
                .dictMappingNodes(dictNodes)
                .rightValues(Collections.singletonList(rightNode))
                .operationType(OperationType.EQUAL)
                .build();
    }

    @Override
    public RuleLogicNode visitNeExpr(DslParser.NeExprContext ctx) {
        DslParser.ValueTakeContext leftValueCxt = ctx.lhs;
        ValueTakeNode leftNode = (ValueTakeNode) visit(leftValueCxt);
        ArrayList<DictMappingNode> dictNodes = loadDictNodes(ctx.dictMapping());
        DslParser.ValueContext valueContext = ctx.rhs;
        String rightNode = trimString(valueContext.getText());
        return RuleLogicNode.builder()
                .valueTakeNode(leftNode)
                .dictMappingNodes(dictNodes)
                .rightValues(Collections.singletonList(rightNode))
                .operationType(OperationType.NotEqual)
                .build();
    }

    private ArrayList<DictMappingNode> loadDictNodes(List<DslParser.DictMappingContext> dictContexts) {
        if(dictContexts == null || dictContexts.isEmpty()) {
            return null;
        }
        ArrayList<DictMappingNode> dictNodes = new ArrayList<>(dictContexts.size());
        for (DslParser.DictMappingContext dictContext : dictContexts) {
            DictMappingNode dictNode = (DictMappingNode) visit(dictContext);
            dictNodes.add(dictNode);
        }
        return dictNodes;
    }

    @Override
    public RuleLogicNode visitInExpr(DslParser.InExprContext ctx) {
        DslParser.ValueTakeContext leftValueCxt = ctx.lhs;
        ValueTakeNode leftNode = (ValueTakeNode) visit(leftValueCxt);
        ArrayList<DictMappingNode> dictNodes = loadDictNodes(ctx.dictMapping());
        DslParser.ValueContext valueContext = ctx.rhs;
        ArrayList<String> rightValues = new ArrayList<>();
        if(valueContext.DIGIT() != null) {
            rightValues.add(trimString(valueContext.DIGIT().getText()));
        }
        List<TerminalNode> string = valueContext.STRING();
        if(string != null && !string.isEmpty()) {
            for (TerminalNode terminalNode : string) {
                rightValues.add(trimString(terminalNode.getText()));
            }
        }
        return RuleLogicNode.builder()
                .valueTakeNode(leftNode)
                .dictMappingNodes(dictNodes)
                .rightValues(rightValues)
                .operationType(OperationType.IN)
                .build();
    }

    @Override
    public OutputExprNode visitFunctionCallSymbol(DslParser.FunctionCallSymbolContext ctx) {
        String functionName = ctx.functionName.getText();
        List<DslParser.OutputExprContext> contexts = ctx.outputExpr();
        ArrayList<OutputExprNode> nodes = new ArrayList<>(contexts.size());
        for (DslParser.OutputExprContext context : contexts) {
            nodes.add((OutputExprNode) visit(context));
        }
        return FunctionOutputNode.builder()
                .functionName(functionName)
                .polyExprNode(nodes)
                .build();
    }

    @Override
    public Node visitNumberVarExpr(DslParser.NumberVarExprContext ctx) {
        String number = ctx.DIGIT().getText();
        return ValueOutputNode.builder()
                .outputValue(number)
                .build();
    }

    @Override
    public Node visitStringVarExpr(DslParser.StringVarExprContext ctx) {
        String outputString = ctx.STRING().getText();
        outputString = trimString(outputString);
        return ValueOutputNode.builder()
                .outputValue(outputString)
                .build();
    }

    @Override
    public Node visitFieldVarExpr(DslParser.FieldVarExprContext ctx) {
        String fieldTake = ctx.FIELD_TAKE().getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return ValueOutputNode.builder()
                .outputValue(fieldTake)
                .build();
    }

    @Override
    public Node visitParenPolyExpr(DslParser.ParenPolyExprContext ctx) {
        return NestedOutputNode.builder()
                .child((OutputExprNode) visit(ctx.outputExpr()))
                .build();
    }

    @Override
    public OutputExprNode visitMulExpr(DslParser.MulExprContext ctx) {
        return StandardOutputNode.builder()
                .leftValue((OutputExprNode) visit(ctx.lhs))
                .rightValue((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.MULTIPLY)
                .build();
    }

    @Override
    public Node visitDivExpr(DslParser.DivExprContext ctx) {
        return StandardOutputNode.builder()
                .leftValue((OutputExprNode) visit(ctx.lhs))
                .rightValue((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.DIVIDE)
                .build();
    }

    @Override
    public Node visitAddExpr(DslParser.AddExprContext ctx) {
        return StandardOutputNode.builder()
                .leftValue((OutputExprNode) visit(ctx.lhs))
                .rightValue((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.ADD)
                .build();
    }

    @Override
    public Node visitSubExpr(DslParser.SubExprContext ctx) {
        return StandardOutputNode.builder()
                .leftValue((OutputExprNode) visit(ctx.lhs))
                .rightValue((OutputExprNode) visit(ctx.rhs))
                .operationType(OperationType.SUBTRACT)
                .build();
    }

    @Override
    public ValueTakeNode visitRuleTake(DslParser.RuleTakeContext ctx) {
        String id = ctx.ID().getText();
        return ValueTakeNode.builder()
                .type(ValueType.ID)
                .value(id)
                .build();
    }

    @Override
    public Node visitFieldTake(DslParser.FieldTakeContext ctx) {
        String fieldTake = ctx.getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return ValueTakeNode.builder()
                .type(ValueType.FIELD)
                .value(fieldTake)
                .build();
    }

    private String trimString(String str) {
        String trim = str.trim();
        if(trim.isEmpty()) {
            return "";
        } else {
            return trim.substring(1, str.length() - 1);
        }
    }

}
