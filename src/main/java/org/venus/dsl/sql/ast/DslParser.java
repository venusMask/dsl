// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.sql.ast;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DslParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, FIELD_TAKE=14, LP=15, RP=16, EQ=17, 
		NE=18, IN=19, NOT=20, AND=21, OR=22, SEMICOLON=23, STRING_PARENS_CN=24, 
		ID=25, LETTER=26, DIGIT=27, STRING=28, STRING_SQUARE_BRACKETS=29, WS=30, 
		COMMENT=31, LINE_COMMENT=32;
	public static final int
		RULE_dsl = 0, RULE_ruleGroup = 1, RULE_ruleDeclare = 2, RULE_ruleDefinition = 3, 
		RULE_ruleLogic = 4, RULE_dictMapping = 5, RULE_assertion = 6, RULE_match = 7, 
		RULE_value = 8, RULE_inValue = 9, RULE_logicExpr = 10, RULE_outputExpr = 11, 
		RULE_valueTake = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"dsl", "ruleGroup", "ruleDeclare", "ruleDefinition", "ruleLogic", "dictMapping", 
			"assertion", "match", "value", "inValue", "logicExpr", "outputExpr", 
			"valueTake"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'->'", "'\\u5176\\u4ED6\\u8F93\\u51FA'", "'\\u6EE1\\u8DB3'", 
			"'\\u8F93\\u51FA'", "','", "'*'", "'/'", "'+'", "'-'", "'\\uFF08'", "'\\uFF09'", 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "FIELD_TAKE", "LP", "RP", "EQ", "NE", "IN", "NOT", "AND", 
			"OR", "SEMICOLON", "STRING_PARENS_CN", "ID", "LETTER", "DIGIT", "STRING", 
			"STRING_SQUARE_BRACKETS", "WS", "COMMENT", "LINE_COMMENT"
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

	public DslParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DslContext extends ParserRuleContext {
		public DslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dsl; }
	 
		public DslContext() { }
		public void copyFrom(DslContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleRuleContext extends DslContext {
		public RuleGroupContext ruleGroup() {
			return getRuleContext(RuleGroupContext.class,0);
		}
		public SingleRuleContext(DslContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitSingleRule(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultipleRuleContext extends DslContext {
		public RuleDeclareContext ruleDeclare() {
			return getRuleContext(RuleDeclareContext.class,0);
		}
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public List<RuleGroupContext> ruleGroup() {
			return getRuleContexts(RuleGroupContext.class);
		}
		public RuleGroupContext ruleGroup(int i) {
			return getRuleContext(RuleGroupContext.class,i);
		}
		public MultipleRuleContext(DslContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitMultipleRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslContext dsl() throws RecognitionException {
		DslContext _localctx = new DslContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dsl);
		int _la;
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SingleRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				ruleGroup();
				}
				break;
			case 2:
				_localctx = new MultipleRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				ruleDeclare();
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(28);
					ruleGroup();
					}
					}
					setState(31); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(33);
				match(T__0);
				setState(34);
				assertion();
				setState(35);
				match(T__1);
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
	public static class RuleGroupContext extends ParserRuleContext {
		public RuleDeclareContext ruleDeclare() {
			return getRuleContext(RuleDeclareContext.class,0);
		}
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
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
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleGroupContext ruleGroup() throws RecognitionException {
		RuleGroupContext _localctx = new RuleGroupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ruleGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			ruleDeclare();
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				ruleDefinition();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(45);
			assertion();
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
		public Token ruleCode;
		public Token ruleName;
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public TerminalNode STRING() { return getToken(DslParser.STRING, 0); }
		public RuleDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDeclare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDeclareContext ruleDeclare() throws RecognitionException {
		RuleDeclareContext _localctx = new RuleDeclareContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruleDeclare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((RuleDeclareContext)_localctx).ruleCode = match(ID);
			setState(48);
			((RuleDeclareContext)_localctx).ruleName = match(STRING);
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
		public Token ruleCode;
		public List<RuleLogicContext> ruleLogic() {
			return getRuleContexts(RuleLogicContext.class);
		}
		public RuleLogicContext ruleLogic(int i) {
			return getRuleContext(RuleLogicContext.class,i);
		}
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(DslParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(DslParser.SEMICOLON, i);
		}
		public RuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDefinitionContext ruleDefinition() throws RecognitionException {
		RuleDefinitionContext _localctx = new RuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ruleDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((RuleDefinitionContext)_localctx).ruleCode = match(ID);
			setState(51);
			ruleLogic();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(52);
				match(SEMICOLON);
				setState(53);
				ruleLogic();
				}
				}
				setState(58);
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
	public static class RuleLogicContext extends ParserRuleContext {
		public RuleLogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleLogic; }
	 
		public RuleLogicContext() { }
		public void copyFrom(RuleLogicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueContext rhs;
		public ValueTakeContext valueTake() {
			return getRuleContext(ValueTakeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(DslParser.EQ, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public EqExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueContext rhs;
		public ValueTakeContext valueTake() {
			return getRuleContext(ValueTakeContext.class,0);
		}
		public TerminalNode IN() { return getToken(DslParser.IN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public InExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitInExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NeExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueContext rhs;
		public ValueTakeContext valueTake() {
			return getRuleContext(ValueTakeContext.class,0);
		}
		public TerminalNode NE() { return getToken(DslParser.NE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public NeExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleLogicContext ruleLogic() throws RecognitionException {
		RuleLogicContext _localctx = new RuleLogicContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleLogic);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new EqExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((EqExprContext)_localctx).lhs = valueTake();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(60);
					dictMapping();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				((EqExprContext)_localctx).op = match(EQ);
				setState(67);
				((EqExprContext)_localctx).rhs = value();
				}
				break;
			case 2:
				_localctx = new NeExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				((NeExprContext)_localctx).lhs = valueTake();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(70);
					dictMapping();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				((NeExprContext)_localctx).op = match(NE);
				setState(77);
				((NeExprContext)_localctx).rhs = value();
				}
				break;
			case 3:
				_localctx = new InExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				((InExprContext)_localctx).lhs = valueTake();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(80);
					dictMapping();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				((InExprContext)_localctx).op = match(IN);
				setState(87);
				((InExprContext)_localctx).rhs = value();
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
	public static class DictMappingContext extends ParserRuleContext {
		public TerminalNode STRING_SQUARE_BRACKETS() { return getToken(DslParser.STRING_SQUARE_BRACKETS, 0); }
		public DictMappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictMapping; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitDictMapping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictMappingContext dictMapping() throws RecognitionException {
		DictMappingContext _localctx = new DictMappingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dictMapping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__2);
			setState(92);
			match(STRING_SQUARE_BRACKETS);
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
	public static class AssertionContext extends ParserRuleContext {
		public List<MatchContext> match() {
			return getRuleContexts(MatchContext.class);
		}
		public MatchContext match(int i) {
			return getRuleContext(MatchContext.class,i);
		}
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assertion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				match();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(99);
				match(T__3);
				setState(100);
				outputExpr(0);
				}
				}
				setState(105);
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
	public static class MatchContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public OutputExprContext outputExpr() {
			return getRuleContext(OutputExprContext.class,0);
		}
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__4);
			setState(107);
			logicExpr(0);
			setState(108);
			match(T__5);
			setState(109);
			outputExpr(0);
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
		public TerminalNode DIGIT() { return getToken(DslParser.DIGIT, 0); }
		public List<TerminalNode> STRING() { return getTokens(DslParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(DslParser.STRING, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(DIGIT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(STRING);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(T__0);
				setState(114);
				match(STRING);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(115);
					match(T__6);
					setState(116);
					match(STRING);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class InValueContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public InValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitInValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InValueContext inValue() throws RecognitionException {
		InValueContext _localctx = new InValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__0);
			setState(126);
			value();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(127);
				match(T__6);
				setState(128);
				value();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(T__1);
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
	public static class LogicExprContext extends ParserRuleContext {
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
	 
		public LogicExprContext() { }
		public void copyFrom(LogicExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends LogicExprContext {
		public LogicExprContext lhs;
		public Token op;
		public LogicExprContext rhs;
		public List<LogicExprContext> logicExpr() {
			return getRuleContexts(LogicExprContext.class);
		}
		public LogicExprContext logicExpr(int i) {
			return getRuleContext(LogicExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(DslParser.AND, 0); }
		public AndExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenLogicExprContext extends LogicExprContext {
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public ParenLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitParenLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends LogicExprContext {
		public Token op;
		public LogicExprContext rhs;
		public TerminalNode NOT() { return getToken(DslParser.NOT, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public NotExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends LogicExprContext {
		public LogicExprContext lhs;
		public Token op;
		public LogicExprContext rhs;
		public List<LogicExprContext> logicExpr() {
			return getRuleContexts(LogicExprContext.class);
		}
		public LogicExprContext logicExpr(int i) {
			return getRuleContext(LogicExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(DslParser.OR, 0); }
		public OrExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleItemExprContext extends LogicExprContext {
		public Token ruleCode;
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public RuleItemExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleItemExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		return logicExpr(0);
	}

	private LogicExprContext logicExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicExprContext _localctx = new LogicExprContext(_ctx, _parentState);
		LogicExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_logicExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(137);
				((NotExprContext)_localctx).op = match(NOT);
				setState(138);
				((NotExprContext)_localctx).rhs = logicExpr(5);
				}
				break;
			case LP:
				{
				_localctx = new ParenLogicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(LP);
				setState(140);
				logicExpr(0);
				setState(141);
				match(RP);
				}
				break;
			case ID:
				{
				_localctx = new RuleItemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				((RuleItemExprContext)_localctx).ruleCode = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AndExprContext(new LogicExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicExpr);
						setState(146);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(147);
						((AndExprContext)_localctx).op = match(AND);
						setState(148);
						((AndExprContext)_localctx).rhs = logicExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new LogicExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicExpr);
						setState(149);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(150);
						((OrExprContext)_localctx).op = match(OR);
						setState(151);
						((OrExprContext)_localctx).rhs = logicExpr(4);
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OutputExprContext extends ParserRuleContext {
		public OutputExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputExpr; }
	 
		public OutputExprContext() { }
		public void copyFrom(OutputExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public MulExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public DivExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallSymbolContext extends OutputExprContext {
		public Token functionName;
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public FunctionCallSymbolContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitFunctionCallSymbol(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberVarExprContext extends OutputExprContext {
		public TerminalNode DIGIT() { return getToken(DslParser.DIGIT, 0); }
		public NumberVarExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNumberVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldVarExprContext extends OutputExprContext {
		public TerminalNode FIELD_TAKE() { return getToken(DslParser.FIELD_TAKE, 0); }
		public FieldVarExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitFieldVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public SubExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenPolyExprContext extends OutputExprContext {
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public OutputExprContext outputExpr() {
			return getRuleContext(OutputExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public ParenPolyExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitParenPolyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public AddExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringVarExprContext extends OutputExprContext {
		public TerminalNode STRING() { return getToken(DslParser.STRING, 0); }
		public StringVarExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitStringVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputExprContext outputExpr() throws RecognitionException {
		return outputExpr(0);
	}

	private OutputExprContext outputExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OutputExprContext _localctx = new OutputExprContext(_ctx, _parentState);
		OutputExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_outputExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new FunctionCallSymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(158);
				((FunctionCallSymbolContext)_localctx).functionName = match(ID);
				setState(159);
				match(LP);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 436256768L) != 0) {
					{
					{
					setState(160);
					outputExpr(0);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(RP);
				}
				break;
			case DIGIT:
				{
				_localctx = new NumberVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(DIGIT);
				}
				break;
			case STRING:
				{
				_localctx = new StringVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(STRING);
				}
				break;
			case FIELD_TAKE:
				{
				_localctx = new FieldVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(FIELD_TAKE);
				}
				break;
			case LP:
				{
				_localctx = new ParenPolyExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(LP);
				setState(171);
				outputExpr(0);
				setState(172);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new MulExprContext(new OutputExprContext(_parentctx, _parentState));
						((MulExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(176);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(177);
						((MulExprContext)_localctx).op = match(T__7);
						setState(178);
						((MulExprContext)_localctx).rhs = outputExpr(9);
						}
						break;
					case 2:
						{
						_localctx = new DivExprContext(new OutputExprContext(_parentctx, _parentState));
						((DivExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(179);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(180);
						((DivExprContext)_localctx).op = match(T__8);
						setState(181);
						((DivExprContext)_localctx).rhs = outputExpr(8);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new OutputExprContext(_parentctx, _parentState));
						((AddExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(182);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(183);
						((AddExprContext)_localctx).op = match(T__9);
						setState(184);
						((AddExprContext)_localctx).rhs = outputExpr(7);
						}
						break;
					case 4:
						{
						_localctx = new SubExprContext(new OutputExprContext(_parentctx, _parentState));
						((SubExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(185);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(186);
						((SubExprContext)_localctx).op = match(T__10);
						setState(187);
						((SubExprContext)_localctx).rhs = outputExpr(6);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueTakeContext extends ParserRuleContext {
		public ValueTakeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueTake; }
	 
		public ValueTakeContext() { }
		public void copyFrom(ValueTakeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuleTakeContext extends ValueTakeContext {
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public RuleTakeContext(ValueTakeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleTake(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldTakeContext extends ValueTakeContext {
		public TerminalNode FIELD_TAKE() { return getToken(DslParser.FIELD_TAKE, 0); }
		public FieldTakeContext(ValueTakeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitFieldTake(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueTakeContext valueTake() throws RecognitionException {
		ValueTakeContext _localctx = new ValueTakeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueTake);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
				_localctx = new RuleTakeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(LP);
				setState(194);
				match(ID);
				setState(195);
				match(RP);
				}
				break;
			case T__11:
				_localctx = new RuleTakeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(T__11);
				setState(197);
				match(ID);
				setState(198);
				match(T__12);
				}
				break;
			case FIELD_TAKE:
				_localctx = new FieldTakeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(FIELD_TAKE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return logicExpr_sempred((LogicExprContext)_localctx, predIndex);
		case 11:
			return outputExpr_sempred((OutputExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicExpr_sempred(LogicExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean outputExpr_sempred(OutputExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00cb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001e\b\u0000"+
		"\u000b\u0000\f\u0000\u001f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000&\b\u0000\u0001\u0001\u0001\u0001\u0004\u0001*\b\u0001\u000b"+
		"\u0001\f\u0001+\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00037\b"+
		"\u0003\n\u0003\f\u0003:\t\u0003\u0001\u0004\u0001\u0004\u0005\u0004>\b"+
		"\u0004\n\u0004\f\u0004A\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004\f\u0004K\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004R\b"+
		"\u0004\n\u0004\f\u0004U\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004Z\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004"+
		"\u0006`\b\u0006\u000b\u0006\f\u0006a\u0001\u0006\u0001\u0006\u0005\u0006"+
		"f\b\u0006\n\u0006\f\u0006i\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\bv\b\b\n\b\f\by\t\b\u0001\b\u0003\b|\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0082\b\t\n\t\f\t\u0085\t\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0091"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0099\b\n"+
		"\n\n\f\n\u009c\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00a2\b\u000b\n\u000b\f\u000b\u00a5\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00af\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00bd\b\u000b\n\u000b\f\u000b\u00c0"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00c9\b\f\u0001\f\u0000\u0002\u0014\u0016\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000\u00db\u0000%\u0001"+
		"\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004/\u0001\u0000"+
		"\u0000\u0000\u00062\u0001\u0000\u0000\u0000\bY\u0001\u0000\u0000\u0000"+
		"\n[\u0001\u0000\u0000\u0000\f_\u0001\u0000\u0000\u0000\u000ej\u0001\u0000"+
		"\u0000\u0000\u0010{\u0001\u0000\u0000\u0000\u0012}\u0001\u0000\u0000\u0000"+
		"\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u00ae\u0001\u0000\u0000\u0000"+
		"\u0018\u00c8\u0001\u0000\u0000\u0000\u001a&\u0003\u0002\u0001\u0000\u001b"+
		"\u001d\u0003\u0004\u0002\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\"\u0005\u0001\u0000\u0000\"#\u0003\f\u0006\u0000#"+
		"$\u0005\u0002\u0000\u0000$&\u0001\u0000\u0000\u0000%\u001a\u0001\u0000"+
		"\u0000\u0000%\u001b\u0001\u0000\u0000\u0000&\u0001\u0001\u0000\u0000\u0000"+
		"\')\u0003\u0004\u0002\u0000(*\u0003\u0006\u0003\u0000)(\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0003\f\u0006\u0000.\u0003\u0001"+
		"\u0000\u0000\u0000/0\u0005\u0019\u0000\u000001\u0005\u001c\u0000\u0000"+
		"1\u0005\u0001\u0000\u0000\u000023\u0005\u0019\u0000\u000038\u0003\b\u0004"+
		"\u000045\u0005\u0017\u0000\u000057\u0003\b\u0004\u000064\u0001\u0000\u0000"+
		"\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000"+
		"\u0000\u00009\u0007\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		";?\u0003\u0018\f\u0000<>\u0003\n\u0005\u0000=<\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0011"+
		"\u0000\u0000CD\u0003\u0010\b\u0000DZ\u0001\u0000\u0000\u0000EI\u0003\u0018"+
		"\f\u0000FH\u0003\n\u0005\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0005\u0012\u0000\u0000"+
		"MN\u0003\u0010\b\u0000NZ\u0001\u0000\u0000\u0000OS\u0003\u0018\f\u0000"+
		"PR\u0003\n\u0005\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000VW\u0005\u0013\u0000\u0000WX\u0003\u0010"+
		"\b\u0000XZ\u0001\u0000\u0000\u0000Y;\u0001\u0000\u0000\u0000YE\u0001\u0000"+
		"\u0000\u0000YO\u0001\u0000\u0000\u0000Z\t\u0001\u0000\u0000\u0000[\\\u0005"+
		"\u0003\u0000\u0000\\]\u0005\u001d\u0000\u0000]\u000b\u0001\u0000\u0000"+
		"\u0000^`\u0003\u000e\u0007\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bg\u0001"+
		"\u0000\u0000\u0000cd\u0005\u0004\u0000\u0000df\u0003\u0016\u000b\u0000"+
		"ec\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000h\r\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000jk\u0005\u0005\u0000\u0000kl\u0003\u0014\n\u0000lm\u0005\u0006"+
		"\u0000\u0000mn\u0003\u0016\u000b\u0000n\u000f\u0001\u0000\u0000\u0000"+
		"o|\u0005\u001b\u0000\u0000p|\u0005\u001c\u0000\u0000qr\u0005\u0001\u0000"+
		"\u0000rw\u0005\u001c\u0000\u0000st\u0005\u0007\u0000\u0000tv\u0005\u001c"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000z|\u0005\u0002\u0000\u0000{o\u0001\u0000\u0000"+
		"\u0000{p\u0001\u0000\u0000\u0000{q\u0001\u0000\u0000\u0000|\u0011\u0001"+
		"\u0000\u0000\u0000}~\u0005\u0001\u0000\u0000~\u0083\u0003\u0010\b\u0000"+
		"\u007f\u0080\u0005\u0007\u0000\u0000\u0080\u0082\u0003\u0010\b\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005\u0002\u0000\u0000\u0087\u0013\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0006\n\uffff\uffff\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a"+
		"\u0091\u0003\u0014\n\u0005\u008b\u008c\u0005\u000f\u0000\u0000\u008c\u008d"+
		"\u0003\u0014\n\u0000\u008d\u008e\u0005\u0010\u0000\u0000\u008e\u0091\u0001"+
		"\u0000\u0000\u0000\u008f\u0091\u0005\u0019\u0000\u0000\u0090\u0088\u0001"+
		"\u0000\u0000\u0000\u0090\u008b\u0001\u0000\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u009a\u0001\u0000\u0000\u0000\u0092\u0093\n\u0004"+
		"\u0000\u0000\u0093\u0094\u0005\u0015\u0000\u0000\u0094\u0099\u0003\u0014"+
		"\n\u0005\u0095\u0096\n\u0003\u0000\u0000\u0096\u0097\u0005\u0016\u0000"+
		"\u0000\u0097\u0099\u0003\u0014\n\u0004\u0098\u0092\u0001\u0000\u0000\u0000"+
		"\u0098\u0095\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000"+
		"\u009b\u0015\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0006\u000b\uffff\uffff\u0000\u009e\u009f\u0005\u0019\u0000"+
		"\u0000\u009f\u00a3\u0005\u000f\u0000\u0000\u00a0\u00a2\u0003\u0016\u000b"+
		"\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a6\u00af\u0005\u0010\u0000\u0000\u00a7\u00af\u0005\u001b\u0000"+
		"\u0000\u00a8\u00af\u0005\u001c\u0000\u0000\u00a9\u00af\u0005\u000e\u0000"+
		"\u0000\u00aa\u00ab\u0005\u000f\u0000\u0000\u00ab\u00ac\u0003\u0016\u000b"+
		"\u0000\u00ac\u00ad\u0005\u0010\u0000\u0000\u00ad\u00af\u0001\u0000\u0000"+
		"\u0000\u00ae\u009d\u0001\u0000\u0000\u0000\u00ae\u00a7\u0001\u0000\u0000"+
		"\u0000\u00ae\u00a8\u0001\u0000\u0000\u0000\u00ae\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00af\u00be\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\n\b\u0000\u0000\u00b1\u00b2\u0005\b\u0000\u0000\u00b2"+
		"\u00bd\u0003\u0016\u000b\t\u00b3\u00b4\n\u0007\u0000\u0000\u00b4\u00b5"+
		"\u0005\t\u0000\u0000\u00b5\u00bd\u0003\u0016\u000b\b\u00b6\u00b7\n\u0006"+
		"\u0000\u0000\u00b7\u00b8\u0005\n\u0000\u0000\u00b8\u00bd\u0003\u0016\u000b"+
		"\u0007\u00b9\u00ba\n\u0005\u0000\u0000\u00ba\u00bb\u0005\u000b\u0000\u0000"+
		"\u00bb\u00bd\u0003\u0016\u000b\u0006\u00bc\u00b0\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b3\u0001\u0000\u0000\u0000\u00bc\u00b6\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b9\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u0017\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0005\u000f\u0000\u0000\u00c2\u00c3\u0005\u0019\u0000\u0000"+
		"\u00c3\u00c9\u0005\u0010\u0000\u0000\u00c4\u00c5\u0005\f\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0019\u0000\u0000\u00c6\u00c9\u0005\r\u0000\u0000\u00c7\u00c9"+
		"\u0005\u000e\u0000\u0000\u00c8\u00c1\u0001\u0000\u0000\u0000\u00c8\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u0019"+
		"\u0001\u0000\u0000\u0000\u0015\u001f%+8?ISYagw{\u0083\u0090\u0098\u009a"+
		"\u00a3\u00ae\u00bc\u00be\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}