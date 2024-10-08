package org.venus.dsl.business;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.venus.dsl.business.pojo.*;
import org.venus.dsl.gen.DSLBaseVisitor;
import org.venus.dsl.gen.DSLParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author venus
 * @since 0.1
 */
public class DSLBusiness extends DSLBaseVisitor<Object> {

    private static final Logger logger = LoggerFactory.getLogger(DSLBusiness.class);

    private final DSL dsl = new DSL();

    @Override
    public Object visitSingleRule(DSLParser.SingleRuleContext ctx) {
        DSLParser.RuleGroupContext ruleGroupContext = ctx.ruleGroup();
        RuleGroup ruleGroup = visitRuleGroup(ruleGroupContext);
        dsl.getRuleGroups().add(ruleGroup);
        return null;
    }

    @Override
    public Object visitMultipleRule(DSLParser.MultipleRuleContext ctx) {
        RuleDeclare topRuleDeclare = visitRuleDeclare(ctx.ruleDeclare());
        dsl.setTopRuleDeclare(topRuleDeclare);
        for (DSLParser.RuleGroupContext ruleGroupContext : ctx.ruleGroup()) {
            RuleGroup ruleGroup = visitRuleGroup(ruleGroupContext);
            dsl.getRuleGroups().add(ruleGroup);
        }
        List<Match> matches = visitJudge(ctx.judge());
        dsl.getMatches().addAll(matches);
        return null;
    }

    @Override
    public RuleGroup visitRuleGroup(DSLParser.RuleGroupContext ctx) {
        RuleGroup ruleGroup = new RuleGroup();
        RuleDeclare ruleDeclare = visitRuleDeclare(ctx.ruleDeclare());
        ruleGroup.setRuleDeclare(ruleDeclare);
        for (DSLParser.RuleDefinitionContext ruleDefinitionContext : ctx.ruleDefinition()) {
            Rule rule = visitRuleDefinition(ruleDefinitionContext);
            ruleGroup.getRules().add(rule);
        }
        List<Match> matches = visitJudge(ctx.judge());
        ruleGroup.getMatches().addAll(matches);
        return ruleGroup;
    }

    @Override
    public Rule visitRuleDefinition(DSLParser.RuleDefinitionContext ctx) {
        Rule rule = new Rule();
        String ruleID = ctx.ruleID().getText();
        rule.setRuleID(ruleID);
        List<Expression> expressions = visitRuleItem(ctx.ruleItem());
        rule.getExpressions().addAll(expressions);
        return rule;
    }

    @Override
    public RuleDeclare visitRuleDeclare(DSLParser.RuleDeclareContext ctx) {
        String ruleID     = Optional.ofNullable(ctx.ruleID())    .map(RuleContext::getText).orElse(null);
        String ruleNameCn = Optional.ofNullable(ctx.ruleNameCn()).map(RuleContext::getText).orElse(null);
        String ruleNameEn = Optional.ofNullable(ctx.ruleNameEn()).map(RuleContext::getText).orElse(null);
        String comment    = Optional.ofNullable(ctx.comment())   .map(RuleContext::getText).orElse(null);
        return RuleDeclare.builder()
                .ruleID(ruleID)
                .ruleNameCn(ruleNameCn)
                .ruleNameEn(ruleNameEn)
                .comment(comment)
                .build();
    }

    @Override
    public List<Expression> visitRuleItem(DSLParser.RuleItemContext ctx) {
        ArrayList<Expression> expressions = new ArrayList<>();
        for (DSLParser.ExpressionContext expressionContext : ctx.expression()) {
            String field = expressionContext.field().getText();
            String operator = expressionContext.OPERATOR().getText();
            DSLParser.ValueContext valueContext = expressionContext.value();
            if(valueContext.getChildCount() == 1) {
                SimpleExpression expression = new SimpleExpression();
                expression.setField(field);
                expression.setValue(valueContext.getText());
                expression.setOperator(operator);
                expressions.add(expression);
            } else {
                ValueListExpression expression = new ValueListExpression();
                expression.setField(field);
                expression.setOperator(operator);
                for (TerminalNode terminalNode : valueContext.ALLCHAR()) {
                    expression.setValue(terminalNode.getText());
                }
                expressions.add(expression);
            }
        }
        return expressions;
    }

    @Override
    public List<Match> visitJudge(DSLParser.JudgeContext ctx) {
        ArrayList<Match> matches = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            Match match = (Match) visit(child);
            matches.add(match);
        }
        return matches;
    }

    @Override
    public Match visitMatch(DSLParser.MatchContext ctx) {
        return Match.builder()
                .matchType("Match")
                .expr(ctx.EXPR().getText().replace("\"", ""))
                .result(visitResult(ctx.result()))
                .build();
    }

    @Override
    public Match visitAllMatch(DSLParser.AllMatchContext ctx) {
        return Match.builder()
                .matchType("AllMatch")
                .result(visitResult(ctx.result()))
                .build();
    }

    @Override
    public Match visitNoneMatch(DSLParser.NoneMatchContext ctx) {
        return Match.builder()
                .matchType("NoneMatch")
                .result(visitResult(ctx.result()))
                .build();
    }

    @Override
    public Match visitAnyMatch(DSLParser.AnyMatchContext ctx) {
        return Match.builder()
                .matchType("AnyMatch")
                .result(visitResult(ctx.result()))
                .build();
    }

    @Override
    public Match visitOther(DSLParser.OtherContext ctx) {
        return Match.builder()
                .matchType("OtherMatch")
                .result(visitResult(ctx.result()))
                .build();
    }

    @Override
    public String visitResult(DSLParser.ResultContext ctx) {
        String text = ctx.STRING().getText();
        return text.replace("\"", "");
    }

    public DSL getDsl() {
        return dsl;
    }
}
