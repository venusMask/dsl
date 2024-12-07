package org.venus.dsl.visitor;

import org.venus.dsl.parse.node.*;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.output.*;
import org.venus.dsl.parse.node.value.*;

public abstract class AstVisitor<R, C> {

    public R process(Node node) {
        return process(node, null);
    }

    public R process(Node node, C context) {
        return node.accept(this, context);
    }

    public R visitNode(Node node, C context) {
        return null;
    }

    public R visitRuleGroup(RuleGroupNode node, C context) {
        return visitNode(node, context);
    }

    public R visitRuleDeclare(RuleDeclareNode node, C context) {
        return visitNode(node, context);
    }

    public R visitRuleDefinition(RuleDefinitionNode node, C context) {
        return visitNode(node, context);
    }

    public R visitRuleLogic(RuleLogicNode node, C context) {
        return visitNode(node, context);
    }

    public R visitSingleRule(SingleRuleNode node, C context) {
        return visitNode(node, context);
    }

    public R visitMultipleRule(MultipleRuleNode node, C context) {
        return visitNode(node, context);
    }

    public R visitAssertion(AssertionNode node, C context) {
        return visitNode(node, context);
    }

    public R visitMatch(MatchNode node, C context) {
        return visitNode(node, context);
    }

    public R visitDictMapping(DictMappingNode node, C context) {
        return visitNode(node, context);
    }

    public R visitLogicExpr(LogicExprNode node, C context) {
        return visitNode(node, context);
    }

    public R visitExcludeLogicExpr(ExcludeLogicExprNode node, C context) {
        return visitLogicExpr(node, context);
    }

    public R visitNestedLogicExpr(NestedLogicExprNode node, C context) {
        return visitLogicExpr(node, context);
    }

    public R visitStandardLogicExpr(StandardLogicExprNode node, C context) {
        return visitLogicExpr(node, context);
    }

    public R visitValueLogicExpr(ValueLogicExprNode node, C context) {
        return visitLogicExpr(node, context);
    }

    public R visitValueTake(ValueTakeNode node, C context) {
        return visitNode(node, context);
    }

    public R visitDirectTake(DirectTakeNode node, C context) {
        return visitValueTake(node, context);
    }

    public R visitFieldTake(FieldTakeNode node, C context) {
        return visitValueTake(node, context);
    }

    public R visitListTake(ListTakeNode node, C context) {
        return visitValueTake(node, context);
    }

    public R visitRuleTake(RuleTakeNode node, C context) {
        return visitValueTake(node, context);
    }

    public R visitOutputExpr(OutputExprNode node, C context) {
        return visitNode(node, context);
    }

    public R visitValueOutput(ValueOutputNode node, C context) {
        return visitOutputExpr(node, context);
    }

    public R visitStandardOutput(StandardOutputNode node, C context) {
        return visitOutputExpr(node, context);
    }

    public R visitFieldOutput(FieldOutputNode node, C context) {
        return visitOutputExpr(node, context);
    }

    public R visitFunctionOutput(FunctionOutputNode node, C context) {
        return visitOutputExpr(node, context);
    }

    public R visitNestedOutput(NestedOutputNode node, C context) {
        return visitOutputExpr(node, context);
    }

}
