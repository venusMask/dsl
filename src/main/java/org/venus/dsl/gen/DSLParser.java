// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SEPARATOR=15, ALLCHAR=16, 
		ALPHANUM=17, INT=18, EXPR=19, STRING=20, COMMENT=21, LINE_COMMENT=22, 
		WS=23;
	public static final int
		RULE_dsl = 0, RULE_rule = 1, RULE_ruleDeclare = 2, RULE_ruleID = 3, RULE_ruleNameCn = 4, 
		RULE_ruleNameEn = 5, RULE_ruleGroup = 6, RULE_ruleDefinition = 7, RULE_ruleItem = 8, 
		RULE_expression = 9, RULE_value = 10, RULE_field = 11, RULE_function = 12, 
		RULE_judge = 13, RULE_match = 14, RULE_allMatch = 15, RULE_noneMatch = 16, 
		RULE_anyMatch = 17, RULE_other = 18, RULE_result = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"dsl", "rule", "ruleDeclare", "ruleID", "ruleNameCn", "ruleNameEn", "ruleGroup", 
			"ruleDefinition", "ruleItem", "expression", "value", "field", "function", 
			"judge", "match", "allMatch", "noneMatch", "anyMatch", "other", "result"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'\\u4E14'", "'='", "'\\u5C5E\\u4E8E'", "'\\u5305\\u542B'", 
			"'->'", "'['", "']'", "'\\u6EE1\\u8DB3'", "'\\u503C\\u57DF'", "'\\u5747\\u6EE1\\u8DB3\\u503C\\u57DF'", 
			"'\\u5747\\u4E0D\\u6EE1\\u8DB3\\u503C\\u57DF'", "'\\u4EFB\\u4E00\\u6EE1\\u8DB3\\u503C\\u57DF'", 
			"'\\u5176\\u4ED6\\u503C\\u57DF'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SEPARATOR", "ALLCHAR", "ALPHANUM", "INT", "EXPR", 
			"STRING", "COMMENT", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DslContext extends ParserRuleContext {
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public DslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dsl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitDsl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslContext dsl() throws RecognitionException {
		DslContext _localctx = new DslContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dsl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			rule_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
	 
		public RuleContext() { }
		public void copyFrom(RuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleRuleContext extends RuleContext {
		public RuleGroupContext ruleGroup() {
			return getRuleContext(RuleGroupContext.class,0);
		}
		public SingleRuleContext(RuleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitSingleRule(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MutilRuleContext extends RuleContext {
		public RuleDeclareContext ruleDeclare() {
			return getRuleContext(RuleDeclareContext.class,0);
		}
		public JudgeContext judge() {
			return getRuleContext(JudgeContext.class,0);
		}
		public List<RuleGroupContext> ruleGroup() {
			return getRuleContexts(RuleGroupContext.class);
		}
		public RuleGroupContext ruleGroup(int i) {
			return getRuleContext(RuleGroupContext.class,i);
		}
		public MutilRuleContext(RuleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitMutilRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SingleRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				ruleGroup();
				}
				break;
			case 2:
				_localctx = new MutilRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				ruleDeclare();
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					ruleGroup();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ALPHANUM );
				setState(49);
				judge();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleDeclareContext extends ParserRuleContext {
		public RuleIDContext ruleID() {
			return getRuleContext(RuleIDContext.class,0);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public RuleNameCnContext ruleNameCn() {
			return getRuleContext(RuleNameCnContext.class,0);
		}
		public RuleNameEnContext ruleNameEn() {
			return getRuleContext(RuleNameEnContext.class,0);
		}
		public RuleDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDeclare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDeclareContext ruleDeclare() throws RecognitionException {
		RuleDeclareContext _localctx = new RuleDeclareContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruleDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			ruleID();
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(54);
				match(SEPARATOR);
				setState(55);
				ruleNameCn();
				}
				break;
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPARATOR) {
				{
				setState(58);
				match(SEPARATOR);
				setState(59);
				ruleNameEn();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleIDContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(DSLParser.ALPHANUM, 0); }
		public RuleIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleID; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleIDContext ruleID() throws RecognitionException {
		RuleIDContext _localctx = new RuleIDContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ruleID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ALPHANUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleNameCnContext extends ParserRuleContext {
		public TerminalNode ALLCHAR() { return getToken(DSLParser.ALLCHAR, 0); }
		public RuleNameCnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleNameCn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleNameCn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleNameCnContext ruleNameCn() throws RecognitionException {
		RuleNameCnContext _localctx = new RuleNameCnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleNameCn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ALLCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleNameEnContext extends ParserRuleContext {
		public TerminalNode ALPHANUM() { return getToken(DSLParser.ALPHANUM, 0); }
		public RuleNameEnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleNameEn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleNameEn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleNameEnContext ruleNameEn() throws RecognitionException {
		RuleNameEnContext _localctx = new RuleNameEnContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ruleNameEn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ALPHANUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleGroupContext extends ParserRuleContext {
		public RuleDeclareContext ruleDeclare() {
			return getRuleContext(RuleDeclareContext.class,0);
		}
		public JudgeContext judge() {
			return getRuleContext(JudgeContext.class,0);
		}
		public List<RuleDefinitionContext> ruleDefinition() {
			return getRuleContexts(RuleDefinitionContext.class);
		}
		public RuleDefinitionContext ruleDefinition(int i) {
			return getRuleContext(RuleDefinitionContext.class,i);
		}
		public RuleGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleGroup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleGroupContext ruleGroup() throws RecognitionException {
		RuleGroupContext _localctx = new RuleGroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ruleGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			ruleDeclare();
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				ruleDefinition();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALPHANUM );
			setState(74);
			judge();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleDefinitionContext extends ParserRuleContext {
		public RuleIDContext ruleID() {
			return getRuleContext(RuleIDContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(DSLParser.SEPARATOR, 0); }
		public RuleItemContext ruleItem() {
			return getRuleContext(RuleItemContext.class,0);
		}
		public RuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDefinitionContext ruleDefinition() throws RecognitionException {
		RuleDefinitionContext _localctx = new RuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ruleDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			ruleID();
			setState(77);
			match(SEPARATOR);
			setState(78);
			ruleItem();
			setState(79);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public RuleItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitRuleItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleItemContext ruleItem() throws RecognitionException {
		RuleItemContext _localctx = new RuleItemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ruleItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			expression();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEPARATOR) {
				{
				{
				setState(82);
				match(SEPARATOR);
				setState(83);
				match(T__1);
				setState(84);
				match(SEPARATOR);
				setState(85);
				expression();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContainsContext extends ExpressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ContainsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitContains(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InContext extends ExpressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public InContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends ExpressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public EqContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		int _la;
		try {
			int _alt;
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new EqContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				field();
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(92);
						match(SEPARATOR);
						}
						} 
					}
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(98);
					function();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(104);
					match(SEPARATOR);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(T__2);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(111);
					match(SEPARATOR);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(117);
				value();
				}
				break;
			case 2:
				_localctx = new InContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				field();
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(120);
						match(SEPARATOR);
						}
						} 
					}
					setState(125);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(126);
					function();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(132);
					match(SEPARATOR);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(T__3);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(139);
					match(SEPARATOR);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				value();
				}
				break;
			case 3:
				_localctx = new ContainsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				field();
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(148);
						match(SEPARATOR);
						}
						} 
					}
					setState(153);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(154);
					function();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(160);
					match(SEPARATOR);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(T__4);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPARATOR) {
					{
					{
					setState(167);
					match(SEPARATOR);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ALLCHAR() { return getToken(DSLParser.ALLCHAR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ALLCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public TerminalNode ALLCHAR() { return getToken(DSLParser.ALLCHAR, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ALLCHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ALLCHAR() { return getToken(DSLParser.ALLCHAR, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__5);
			setState(182);
			match(T__6);
			setState(183);
			match(ALLCHAR);
			setState(184);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JudgeContext extends ParserRuleContext {
		public OtherContext other() {
			return getRuleContext(OtherContext.class,0);
		}
		public List<MatchContext> match() {
			return getRuleContexts(MatchContext.class);
		}
		public MatchContext match(int i) {
			return getRuleContext(MatchContext.class,i);
		}
		public AllMatchContext allMatch() {
			return getRuleContext(AllMatchContext.class,0);
		}
		public NoneMatchContext noneMatch() {
			return getRuleContext(NoneMatchContext.class,0);
		}
		public AnyMatchContext anyMatch() {
			return getRuleContext(AnyMatchContext.class,0);
		}
		public JudgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_judge; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitJudge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JudgeContext judge() throws RecognitionException {
		JudgeContext _localctx = new JudgeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_judge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(186);
				match();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(192);
				allMatch();
				}
			}

			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(195);
				noneMatch();
				}
			}

			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(198);
				anyMatch();
				}
			}

			setState(201);
			other();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchContext extends ParserRuleContext {
		public List<TerminalNode> SEPARATOR() { return getTokens(DSLParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(DSLParser.SEPARATOR, i);
		}
		public TerminalNode EXPR() { return getToken(DSLParser.EXPR, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__8);
			setState(204);
			match(SEPARATOR);
			setState(205);
			match(EXPR);
			setState(206);
			match(SEPARATOR);
			setState(207);
			match(T__9);
			setState(208);
			match(SEPARATOR);
			setState(209);
			result();
			setState(210);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllMatchContext extends ParserRuleContext {
		public TerminalNode SEPARATOR() { return getToken(DSLParser.SEPARATOR, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public AllMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allMatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitAllMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllMatchContext allMatch() throws RecognitionException {
		AllMatchContext _localctx = new AllMatchContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_allMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__10);
			setState(213);
			match(SEPARATOR);
			setState(214);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoneMatchContext extends ParserRuleContext {
		public TerminalNode SEPARATOR() { return getToken(DSLParser.SEPARATOR, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public NoneMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noneMatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitNoneMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoneMatchContext noneMatch() throws RecognitionException {
		NoneMatchContext _localctx = new NoneMatchContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_noneMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__11);
			setState(217);
			match(SEPARATOR);
			setState(218);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnyMatchContext extends ParserRuleContext {
		public TerminalNode SEPARATOR() { return getToken(DSLParser.SEPARATOR, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public AnyMatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyMatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitAnyMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyMatchContext anyMatch() throws RecognitionException {
		AnyMatchContext _localctx = new AnyMatchContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_anyMatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__12);
			setState(221);
			match(SEPARATOR);
			setState(222);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OtherContext extends ParserRuleContext {
		public TerminalNode SEPARATOR() { return getToken(DSLParser.SEPARATOR, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public OtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_other; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitOther(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherContext other() throws RecognitionException {
		OtherContext _localctx = new OtherContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_other);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__13);
			setState(225);
			match(SEPARATOR);
			setState(226);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResultContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(DSLParser.STRING, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLVisitor ) return ((DSLVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u00e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001.\b\u0001\u000b\u0001\f\u0001/\u0001\u0001"+
		"\u0001\u0001\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00029\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0004\u0006G\b\u0006\u000b\u0006\f\u0006H\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bW\b\b\n\b\f\bZ\t\b\u0001"+
		"\t\u0001\t\u0005\t^\b\t\n\t\f\ta\t\t\u0001\t\u0005\td\b\t\n\t\f\tg\t\t"+
		"\u0001\t\u0005\tj\b\t\n\t\f\tm\t\t\u0001\t\u0001\t\u0005\tq\b\t\n\t\f"+
		"\tt\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tz\b\t\n\t\f\t}\t\t\u0001"+
		"\t\u0005\t\u0080\b\t\n\t\f\t\u0083\t\t\u0001\t\u0005\t\u0086\b\t\n\t\f"+
		"\t\u0089\t\t\u0001\t\u0001\t\u0005\t\u008d\b\t\n\t\f\t\u0090\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u0096\b\t\n\t\f\t\u0099\t\t\u0001\t"+
		"\u0005\t\u009c\b\t\n\t\f\t\u009f\t\t\u0001\t\u0005\t\u00a2\b\t\n\t\f\t"+
		"\u00a5\t\t\u0001\t\u0001\t\u0005\t\u00a9\b\t\n\t\f\t\u00ac\t\t\u0001\t"+
		"\u0001\t\u0003\t\u00b0\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0005\r\u00bc\b\r\n\r\f\r\u00bf"+
		"\t\r\u0001\r\u0003\r\u00c2\b\r\u0001\r\u0003\r\u00c5\b\r\u0001\r\u0003"+
		"\r\u00c8\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0000\u00ea\u0000(\u0001"+
		"\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000"+
		"\u0000\u0006>\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nB\u0001"+
		"\u0000\u0000\u0000\fD\u0001\u0000\u0000\u0000\u000eL\u0001\u0000\u0000"+
		"\u0000\u0010Q\u0001\u0000\u0000\u0000\u0012\u00af\u0001\u0000\u0000\u0000"+
		"\u0014\u00b1\u0001\u0000\u0000\u0000\u0016\u00b3\u0001\u0000\u0000\u0000"+
		"\u0018\u00b5\u0001\u0000\u0000\u0000\u001a\u00bd\u0001\u0000\u0000\u0000"+
		"\u001c\u00cb\u0001\u0000\u0000\u0000\u001e\u00d4\u0001\u0000\u0000\u0000"+
		" \u00d8\u0001\u0000\u0000\u0000\"\u00dc\u0001\u0000\u0000\u0000$\u00e0"+
		"\u0001\u0000\u0000\u0000&\u00e4\u0001\u0000\u0000\u0000()\u0003\u0002"+
		"\u0001\u0000)\u0001\u0001\u0000\u0000\u0000*4\u0003\f\u0006\u0000+-\u0003"+
		"\u0004\u0002\u0000,.\u0003\f\u0006\u0000-,\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000012\u0003\u001a\r\u000024\u0001\u0000\u0000\u0000"+
		"3*\u0001\u0000\u0000\u00003+\u0001\u0000\u0000\u00004\u0003\u0001\u0000"+
		"\u0000\u000058\u0003\u0006\u0003\u000067\u0005\u000f\u0000\u000079\u0003"+
		"\b\u0004\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009<\u0001"+
		"\u0000\u0000\u0000:;\u0005\u000f\u0000\u0000;=\u0003\n\u0005\u0000<:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\u0005\u0001\u0000\u0000"+
		"\u0000>?\u0005\u0011\u0000\u0000?\u0007\u0001\u0000\u0000\u0000@A\u0005"+
		"\u0010\u0000\u0000A\t\u0001\u0000\u0000\u0000BC\u0005\u0011\u0000\u0000"+
		"C\u000b\u0001\u0000\u0000\u0000DF\u0003\u0004\u0002\u0000EG\u0003\u000e"+
		"\u0007\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JK\u0003\u001a\r\u0000K\r\u0001\u0000\u0000\u0000LM\u0003\u0006\u0003"+
		"\u0000MN\u0005\u000f\u0000\u0000NO\u0003\u0010\b\u0000OP\u0005\u0001\u0000"+
		"\u0000P\u000f\u0001\u0000\u0000\u0000QX\u0003\u0012\t\u0000RS\u0005\u000f"+
		"\u0000\u0000ST\u0005\u0002\u0000\u0000TU\u0005\u000f\u0000\u0000UW\u0003"+
		"\u0012\t\u0000VR\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u0011\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000[_\u0003\u0016\u000b\u0000\\^\u0005\u000f"+
		"\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`e\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000bd\u0003\u0018\f\u0000cb\u0001\u0000\u0000\u0000"+
		"dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fk\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hj\u0005\u000f"+
		"\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000"+
		"mk\u0001\u0000\u0000\u0000nr\u0005\u0003\u0000\u0000oq\u0005\u000f\u0000"+
		"\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uv\u0003\u0014\n\u0000v\u00b0\u0001\u0000\u0000\u0000"+
		"w{\u0003\u0016\u000b\u0000xz\u0005\u000f\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|\u0081\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\u0080\u0003\u0018\f\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0087\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0005\u000f\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008e"+
		"\u0005\u0004\u0000\u0000\u008b\u008d\u0005\u000f\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0003\u0014\n\u0000\u0092\u00b0\u0001\u0000\u0000\u0000\u0093\u0097\u0003"+
		"\u0016\u000b\u0000\u0094\u0096\u0005\u000f\u0000\u0000\u0095\u0094\u0001"+
		"\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009d\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009c\u0003"+
		"\u0018\f\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u00a3\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a2\u0005\u000f\u0000\u0000\u00a1\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00aa\u0005\u0005"+
		"\u0000\u0000\u00a7\u00a9\u0005\u000f\u0000\u0000\u00a8\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003\u0014"+
		"\n\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af[\u0001\u0000\u0000"+
		"\u0000\u00afw\u0001\u0000\u0000\u0000\u00af\u0093\u0001\u0000\u0000\u0000"+
		"\u00b0\u0013\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0010\u0000\u0000"+
		"\u00b2\u0015\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0010\u0000\u0000"+
		"\u00b4\u0017\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0006\u0000\u0000"+
		"\u00b6\u00b7\u0005\u0007\u0000\u0000\u00b7\u00b8\u0005\u0010\u0000\u0000"+
		"\u00b8\u00b9\u0005\b\u0000\u0000\u00b9\u0019\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0003\u001c\u000e\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c2\u0003\u001e\u000f\u0000\u00c1"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003 \u0010\u0000\u00c4\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c8\u0003\"\u0011\u0000\u00c7\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0003$\u0012\u0000\u00ca\u001b\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0005\t\u0000\u0000\u00cc\u00cd\u0005\u000f\u0000"+
		"\u0000\u00cd\u00ce\u0005\u0013\u0000\u0000\u00ce\u00cf\u0005\u000f\u0000"+
		"\u0000\u00cf\u00d0\u0005\n\u0000\u0000\u00d0\u00d1\u0005\u000f\u0000\u0000"+
		"\u00d1\u00d2\u0003&\u0013\u0000\u00d2\u00d3\u0005\u0001\u0000\u0000\u00d3"+
		"\u001d\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u000b\u0000\u0000\u00d5"+
		"\u00d6\u0005\u000f\u0000\u0000\u00d6\u00d7\u0003&\u0013\u0000\u00d7\u001f"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\f\u0000\u0000\u00d9\u00da\u0005"+
		"\u000f\u0000\u0000\u00da\u00db\u0003&\u0013\u0000\u00db!\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0005\r\u0000\u0000\u00dd\u00de\u0005\u000f\u0000\u0000"+
		"\u00de\u00df\u0003&\u0013\u0000\u00df#\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0005\u000e\u0000\u0000\u00e1\u00e2\u0005\u000f\u0000\u0000\u00e2\u00e3"+
		"\u0003&\u0013\u0000\u00e3%\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u0014"+
		"\u0000\u0000\u00e5\'\u0001\u0000\u0000\u0000\u0017/38<HX_ekr{\u0081\u0087"+
		"\u008e\u0097\u009d\u00a3\u00aa\u00af\u00bd\u00c1\u00c4\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}