// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.sql.ast;

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
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(DslParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeExpr(DslParser.NeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link DslParser#ruleLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(DslParser.InExprContext ctx);
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
	 * Visit a parse tree produced by {@link DslParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DslParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(DslParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenLogicExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenLogicExpr(DslParser.ParenLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(DslParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(DslParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleItemExpr}
	 * labeled alternative in {@link DslParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleItemExpr(DslParser.RuleItemExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(DslParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(DslParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallSymbol}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallSymbol(DslParser.FunctionCallSymbolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberVarExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVarExpr(DslParser.NumberVarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldVarExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldVarExpr(DslParser.FieldVarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(DslParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenPolyExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenPolyExpr(DslParser.ParenPolyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(DslParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVarExpr}
	 * labeled alternative in {@link DslParser#outputExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVarExpr(DslParser.StringVarExprContext ctx);
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
}