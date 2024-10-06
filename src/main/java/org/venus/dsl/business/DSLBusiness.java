package org.venus.dsl.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.venus.dsl.business.pojo.*;
import org.venus.dsl.gen.DSLBaseVisitor;
import org.venus.dsl.gen.DSLParser;

import java.util.ArrayList;
import java.util.List;

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
    public RuleGroup visitRuleGroup(DSLParser.RuleGroupContext ctx) {
        RuleGroup ruleGroup = new RuleGroup();
        RuleDeclare ruleDeclare = visitRuleDeclare(ctx.ruleDeclare());
        ruleGroup.setRuleDeclare(ruleDeclare);
        for (DSLParser.RuleDefinitionContext ruleDefinitionContext : ctx.ruleDefinition()) {
            Rule rule = visitRuleDefinition(ruleDefinitionContext);
            ruleGroup.getRules().add(rule);
        }
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
        String ruleID = ctx.ruleID().getText();
        String ruleNameCn = ctx.ruleNameCn().getText();
        String ruleNameEn = ctx.ruleNameEn().getText();
        RuleDeclare ruleDeclare = RuleDeclare.builder()
                .ruleID(ruleID)
                .ruleNameCn(ruleNameCn)
                .ruleNameEn(ruleNameEn)
                .build();
        return ruleDeclare;
    }

    /**
     * TODO: 从当前的使用情景上看, expression区分 #eq #in #contains 反而会增加编码复杂度.
     */
    @Override
    public List<Expression> visitRuleItem(DSLParser.RuleItemContext ctx) {
        ArrayList<Expression> expressions = new ArrayList<>();
        for (DSLParser.ExpressionContext expressionContext : ctx.expression()) {
            if(expressionContext instanceof DSLParser.EqContext) {
                expressions.add(visitEq((DSLParser.EqContext) expressionContext));
            }
        }
        return expressions;
    }

    @Override
    public Expression visitEq(DSLParser.EqContext ctx) {
        Expression expression = new Expression();
        String field = ctx.field().getText();
        String value = ctx.value().getText();
        expression.setField(field);
        expression.setValue(value);
        expression.setOperator("=");
        return expression;
    }

    public DSL getDsl() {
        return dsl;
    }
}
