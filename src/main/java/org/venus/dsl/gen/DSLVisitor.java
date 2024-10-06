// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DSLParser#dsl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDsl(DSLParser.DslContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleRule}
	 * labeled alternative in {@link DSLParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleRule(DSLParser.SingleRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mutilRule}
	 * labeled alternative in {@link DSLParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutilRule(DSLParser.MutilRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDeclare(DSLParser.RuleDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleID(DSLParser.RuleIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleNameCn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleNameCn(DSLParser.RuleNameCnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleNameEn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleNameEn(DSLParser.RuleNameEnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleGroup(DSLParser.RuleGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDefinition(DSLParser.RuleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#ruleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleItem(DSLParser.RuleItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link DSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(DSLParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link DSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(DSLParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contains}
	 * labeled alternative in {@link DSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(DSLParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DSLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(DSLParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(DSLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#judge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJudge(DSLParser.JudgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(DSLParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#allMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllMatch(DSLParser.AllMatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#noneMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneMatch(DSLParser.NoneMatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#anyMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyMatch(DSLParser.AnyMatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#other}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOther(DSLParser.OtherContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(DSLParser.ResultContext ctx);
}