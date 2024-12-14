package org.venus.dsl.parse;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.venus.dsl.ast.DslLexer;
import org.venus.dsl.parse.node.*;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.output.*;
import org.venus.dsl.ast.DslBaseVisitor;
import org.venus.dsl.ast.DslParser;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.parse.node.value.*;
import org.venus.dsl.parse.node.NodeLocation;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Slf4j
public class AstParse extends DslBaseVisitor<Node> {

    private String tableName;

    @Override
    public SingleRuleNode visitSingleRule(DslParser.SingleRuleContext ctx) {
        DslParser.RuleGroupContext ruleGroupCxt = ctx.ruleGroup();
        RuleGroupNode ruleGroupNode = (RuleGroupNode) visit(ruleGroupCxt);
        return new SingleRuleNode(getLocation(ctx), ruleGroupNode);
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
        return new MultipleRuleNode(getLocation(ctx), ruleDeclareNode, ruleGroupNodes, assertionNode);
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
        return new RuleGroupNode(
                getLocation(ctx),
                ruleDeclareNode,
                nodes,
                assertion
        );
    }

    @Override
    public RuleDeclareNode visitRuleDeclare(DslParser.RuleDeclareContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        String ruleName = ctx.ruleName.getText();
        return new RuleDeclareNode(
                getLocation(ctx),
                ruleCode,
                ruleName
        );
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
        return new RuleDefinitionNode(getLocation(ctx), ruleCode, nodes);
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
        ArrayList<OutputExprNode> outputNodes = new ArrayList<>(polyContexts.size());
        for (DslParser.OutputExprContext context : polyContexts) {
            outputNodes.add((OutputExprNode) visit(context));
        }
        return new AssertionNode(getLocation(ctx), matchNodes, outputNodes);
    }

    private ArrayList<DictMappingNode>
    loadDictNodes(List<DslParser.DictMappingContext> dictContexts) {
        if (dictContexts == null || dictContexts.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<DictMappingNode> dictNodes = new ArrayList<>(dictContexts.size());
        for (DslParser.DictMappingContext dictContext : dictContexts) {
            DictMappingNode dictNode = (DictMappingNode) visit(dictContext);
            dictNodes.add(dictNode);
        }
        return dictNodes;
    }

    private RuleLogicNode visitRuleLogicContext(DslParser.RuleLogicContext context,
                                                OperationType operationType) {
        DslParser.ValueTakeContext lhs = context.getRuleContext(DslParser.ValueTakeContext.class, 0);
        DslParser.ValueTakeContext rhs = context.getRuleContext(DslParser.ValueTakeContext.class, 1);
        ValueTakeNode lhsNode = (ValueTakeNode) visit(lhs);
        ValueTakeNode rhsNode = (ValueTakeNode) visit(rhs);
        ArrayList<DictMappingNode> dictNodes = loadDictNodes(context.getRuleContexts(DslParser.DictMappingContext.class));
        // 带有字典的前面必须是FieldTakeNode, 否则无法确定进行哪个词典映射
        if(dictNodes != null && !dictNodes.isEmpty()) {
            if(lhsNode instanceof FieldTakeNode) {
                FieldTakeNode fieldTakeNode = (FieldTakeNode) lhsNode;
                for (DictMappingNode dictNode : dictNodes) {
                    dictNode.setField(fieldTakeNode);
                }
            } else {
                throw new RuntimeException("解析rule_logic失败, 失败位置: " + getLocation(context));
            }
        }
        if(lhsNode instanceof FieldTakeNode) {
            FieldTakeNode fieldTakeNode = (FieldTakeNode) lhsNode;
            tableName = fieldTakeNode.getTableName();
        }
        return new RuleLogicNode(
                getLocation(context),
                lhsNode,
                rhsNode,
                dictNodes,
                operationType
        );
    }

    @Override
    public DictMappingNode visitDictMapping(DslParser.DictMappingContext ctx) {
        String dictName = ctx.STRING_SQUARE_BRACKETS().getText();
        dictName = trimString(dictName.trim());
        return new DictMappingNode(getLocation(ctx), dictName);
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
    public Node visitLtRuleExpr(DslParser.LtRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.LT);
    }

    @Override
    public Node visitLeRuleExpr(DslParser.LeRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.LE);
    }

    @Override
    public Node visitContainsRuleExpr(DslParser.ContainsRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.CONTAINS);
    }

    @Override
    public Node visitNotContainsRuleExpr(DslParser.NotContainsRuleExprContext ctx) {
        return visitRuleLogicContext(ctx, OperationType.NotContains);
    }

    @Override
    public MatchNode visitMatch(DslParser.MatchContext ctx) {
        LogicExprNode logicExprNode = (LogicExprNode) visit(ctx.logicExpr());
        OutputExprNode polyExprNode = (OutputExprNode) visit(ctx.outputExpr());
        return new MatchNode(getLocation(ctx), logicExprNode, polyExprNode);
    }

    @Override
    public Node visitRuleCodeLogicExpr(DslParser.RuleCodeLogicExprContext ctx) {
        String ruleCode = ctx.ruleCode.getText();
        return new ValueLogicExprNode(getLocation(ctx), ruleCode);
    }

    @Override
    public Node visitNestLogicExpr(DslParser.NestLogicExprContext ctx) {
        LogicExprNode child = (LogicExprNode) visit(ctx.logicExpr());
        return new NestedLogicExprNode(getLocation(ctx), child);
    }

    @Override
    public LogicExprNode visitAndLogicExpr(DslParser.AndLogicExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return new StandardLogicExprNode(
                getLocation(ctx),
                leftValue,
                rightValue,
                OperationType.AND);
    }

    @Override
    public Node visitNotLogicExpr(DslParser.NotLogicExprContext ctx) {
        return new ExcludeLogicExprNode(
                getLocation(ctx),
                (LogicExprNode) visit(ctx.rhs)
        );
    }

    @Override
    public Node visitOrLogicExpr(DslParser.OrLogicExprContext ctx) {
        LogicExprNode leftValue = (LogicExprNode) visit(ctx.lhs);
        LogicExprNode rightValue = (LogicExprNode) visit(ctx.rhs);
        return new StandardLogicExprNode(
                getLocation(ctx),
                leftValue,
                rightValue,
                OperationType.OR);
    }

    @Override
    public OutputExprNode visitFunctionOutputExpr(DslParser.FunctionOutputExprContext ctx) {
        String functionName = ctx.functionName.getText();
        List<DslParser.OutputExprContext> contexts = ctx.outputExpr();
        ArrayList<OutputExprNode> nodes = new ArrayList<>(contexts.size());
        for (DslParser.OutputExprContext context : contexts) {
            nodes.add((OutputExprNode) visit(context));
        }
        return new FunctionOutputNode(getLocation(ctx), functionName, nodes);
    }

    @Override
    public Node visitNumberOutputExpr(DslParser.NumberOutputExprContext ctx) {
        String number = ctx.DIGIT().getText();
        return new ValueOutputNode(getLocation(ctx), number);
    }

    @Override
    public Node visitStringOutputExpr(DslParser.StringOutputExprContext ctx) {
        String outputString = ctx.STRING().getText();
        outputString = trimString(outputString);
        return new ValueOutputNode(getLocation(ctx), outputString);
    }

    @Override
    public Node visitFieldOutputExpr(DslParser.FieldOutputExprContext ctx) {
        String fieldTake = ctx.FIELD_TAKE().getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return new FieldOutputNode(getLocation(ctx), fieldTake);
    }

    @Override
    public Node visitNestOutputExpr(DslParser.NestOutputExprContext ctx) {
        return new NestedOutputNode(getLocation(ctx), (OutputExprNode) visit(ctx.outputExpr()));
    }

    @Override
    public OutputExprNode visitMulOutputExpr(DslParser.MulOutputExprContext ctx) {
        return new StandardOutputNode(
                getLocation(ctx),
                (OutputExprNode) visit(ctx.lhs),
                (OutputExprNode) visit(ctx.rhs),
                OperationType.MULTIPLY
        );
    }

    @Override
    public Node visitDivOutputExpr(DslParser.DivOutputExprContext ctx) {
        return new StandardOutputNode(
                getLocation(ctx),
                (OutputExprNode) visit(ctx.lhs),
                (OutputExprNode) visit(ctx.rhs),
                OperationType.DIVIDE
        );
    }

    @Override
    public Node visitAddOutputExpr(DslParser.AddOutputExprContext ctx) {
        return new StandardOutputNode(
                getLocation(ctx),
                (OutputExprNode) visit(ctx.lhs),
                (OutputExprNode) visit(ctx.rhs),
                OperationType.ADD
        );
    }

    @Override
    public Node visitSubOutputExpr(DslParser.SubOutputExprContext ctx) {
        return new StandardOutputNode(
                getLocation(ctx),
                (OutputExprNode) visit(ctx.lhs),
                (OutputExprNode) visit(ctx.rhs),
                OperationType.SUBTRACT
        );
    }

    @Override
    public ValueTakeNode visitRuleTake(DslParser.RuleTakeContext ctx) {
        String id = ctx.ID().getText();
        return new RuleTakeNode(getLocation(ctx), id, ValueType.ID);
    }

    @Override
    public Node visitFieldTake(DslParser.FieldTakeContext ctx) {
        String fieldTake = ctx.getText();
        fieldTake = fieldTake.substring(2, fieldTake.length() - 1);
        return new FieldTakeNode(getLocation(ctx), fieldTake, ValueType.FIELD);
    }

    @Override
    public Node visitNumberTake(DslParser.NumberTakeContext ctx) {
        String digit = ctx.DIGIT().getText();
        return new DirectTakeNode(getLocation(ctx), digit, ValueType.DIRECT);
    }

    @Override
    public Node visitStringTake(DslParser.StringTakeContext ctx) {
        String text = ctx.STRING().getText();
        text = trimString(text);
        return new DirectTakeNode(getLocation(ctx), text, ValueType.DIRECT);
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
        return new ListTakeNode(getLocation(ctx), list, ValueType.LIST);
    }

    // 去除字符串额外带的双引号
    private String trimString(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return "";
        } else {
            return trim.substring(1, str.length() - 1);
        }
    }

    public static NodeLocation getLocation(TerminalNode terminalNode) {
        return getLocation(terminalNode.getSymbol());
    }

    public static NodeLocation getLocation(ParserRuleContext parserRuleContext) {
        return getLocation(parserRuleContext.getStart());
    }

    public static NodeLocation getLocation(Token token) {
        return new NodeLocation(token.getLine(), token.getCharPositionInLine());
    }

    public TableInfo parse(String input) {
        CharStream charStream = CharStreams.fromString(input);
        DslLexer lexer = new DslLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        ParseTree root = parser.dsl();
        AstParse dslVisitor = new AstParse();
        Node node = dslVisitor.visit(root);
        return new TableInfo(node, dslVisitor.tableName);
    }

}
