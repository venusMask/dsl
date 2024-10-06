package org.venus.dsl.business;

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

    private final DSL dsl = new DSL();

    @Override
    public Object visitSingleRule(DSLParser.SingleRuleContext ctx) {
        DSLParser.RuleDefinitionContext ruleDefinitionContext = (DSLParser.RuleDefinitionContext) ctx.getChild(0);
        RuleGroup logicCell = (RuleGroup) visitRuleDefinition(ruleDefinitionContext);
        dsl.getLogicCells().add(logicCell);
        return null;
    }

    @Override
    public RuleGroup visitRuleDefinition(DSLParser.RuleDefinitionContext ctx) {
        RuleGroup logicCell = new RuleGroup();
        RuleDeclare ruleDeclare = (RuleDeclare) visitRuleDeclare(ctx.ruleDeclare());
        logicCell.setRuleDeclare(ruleDeclare);
        List<DSLParser.RuleItemDefinitionContext> definitionContexts = ctx.ruleItemDefinition();
        for (DSLParser.RuleItemDefinitionContext definitionContext : definitionContexts) {
            Rule ruleItem = (Rule) visitRuleItemDefinition(definitionContext);
            logicCell.getRuleItems().add(ruleItem);
        }
        DSLParser.JudgeContext judge = ctx.judge();
        Object object = visitJudge(judge);
        return logicCell;
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

    @Override
    public Rule visitRuleItemDefinition(DSLParser.RuleItemDefinitionContext ctx) {
        Rule ruleItem = new Rule();
        String ruleItemID = ctx.ruleItemID().getText();
        ruleItem.setRuleID(ruleItemID);
        List<Expression> expressions = visitRuleItem(ctx.ruleItem());
        ruleItem.getExpressions().addAll(expressions);
        return ruleItem;
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
