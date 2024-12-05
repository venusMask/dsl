// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.ast;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DslParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DslVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code singleRule}
	 * labeled alternative in {@link DslParser#dsl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleRule(DslParser.SingleRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleRule}
	 * labeled alternative in {@link DslParser#dsl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleRule(DslParser.MultipleRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#ruleGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleGroup(DslParser.RuleGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#ruleDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDeclare(DslParser.RuleDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#ruleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDefinition(DslParser.RuleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqRuleExpr(DslParser.EqRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NeRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeRuleExpr(DslParser.NeRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInRuleExpr(DslParser.InRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRuleExpr(DslParser.AddRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubRuleExpr(DslParser.SubRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulRuleExpr(DslParser.MulRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivRuleExpr(DslParser.DivRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GtRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtRuleExpr(DslParser.GtRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GeRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeRuleExpr(DslParser.GeRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LtRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtRuleExpr(DslParser.LtRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeRuleExpr(DslParser.LeRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContainsRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsRuleExpr(DslParser.ContainsRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotContainsRuleExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotContainsRuleExpr(DslParser.NotContainsRuleExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#dictMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictMapping(DslParser.DictMappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(DslParser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DslParser#match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(DslParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleTake}
	 * labeled alternative in {@link DslParser#valueTake}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleTake(DslParser.RuleTakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldTake}
	 * labeled alternative in {@link DslParser#valueTake}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldTake(DslParser.FieldTakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberTake}
	 * labeled alternative in {@link DslParser#valueTake}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberTake(DslParser.NumberTakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringTake}
	 * labeled alternative in {@link DslParser#valueTake}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTake(DslParser.StringTakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListTake}
	 * labeled alternative in {@link DslParser#valueTake}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTake(DslParser.ListTakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleCodeLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleCodeLogicExpr(DslParser.RuleCodeLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotLogicExpr(DslParser.NotLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestLogicExpr(DslParser.NestLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndLogicExpr(DslParser.AndLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrLogicExpr(DslParser.OrLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberOutputExpr(DslParser.NumberOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubOutputExpr(DslParser.SubOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivOutputExpr(DslParser.DivOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOutputExpr(DslParser.StringOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOutputExpr(DslParser.MulOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOutputExpr(DslParser.AddOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOutputExpr(DslParser.FunctionOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldOutputExpr(DslParser.FieldOutputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestOutputExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestOutputExpr(DslParser.NestOutputExprContext ctx);
}