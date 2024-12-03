// Generated from java-escape by ANTLR 4.11.1

package org.venus.dsl.ast;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, FIELD_TAKE=16, 
		LP=17, RP=18, EQ=19, NE=20, CONTAINS=21, IN=22, NOT=23, AND=24, OR=25, 
		SEMICOLON=26, STRING_PARENS_CN=27, ID=28, LETTER=29, DIGIT=30, STRING=31, 
		STRING_SQUARE_BRACKETS=32, WS=33, COMMENT=34, LINE_COMMENT=35;
	public static final int
		RULE_dsl = 0, RULE_ruleGroup = 1, RULE_ruleDeclare = 2, RULE_ruleDefinition = 3, 
		RULE_ruleLogic = 4, RULE_dictMapping = 5, RULE_assertion = 6, RULE_match = 7, 
		RULE_valueTake = 8, RULE_logicExpr = 9, RULE_outputExpr = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"dsl", "ruleGroup", "ruleDeclare", "ruleDefinition", "ruleLogic", "dictMapping", 
			"assertion", "match", "valueTake", "logicExpr", "outputExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", "'->'", 
			"'\\u5176\\u4ED6\\u8F93\\u51FA'", "'\\u6EE1\\u8DB3'", "'\\u8F93\\u51FA'", 
			"'\\uFF08'", "'\\uFF09'", "','", null, "'('", "')'", null, null, "'contains'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "FIELD_TAKE", "LP", "RP", "EQ", "NE", "CONTAINS", 
			"IN", "NOT", "AND", "OR", "SEMICOLON", "STRING_PARENS_CN", "ID", "LETTER", 
			"DIGIT", "STRING", "STRING_SQUARE_BRACKETS", "WS", "COMMENT", "LINE_COMMENT"
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
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SingleRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				ruleGroup();
				}
				break;
			case 2:
				_localctx = new MultipleRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				ruleDeclare();
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(24);
					ruleGroup();
					}
					}
					setState(27); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(29);
				match(T__0);
				setState(30);
				assertion();
				setState(31);
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
			setState(35);
			ruleDeclare();
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				ruleDefinition();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(41);
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
			setState(43);
			((RuleDeclareContext)_localctx).ruleCode = match(ID);
			setState(44);
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
			setState(46);
			((RuleDefinitionContext)_localctx).ruleCode = match(ID);
			setState(47);
			ruleLogic();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(48);
				match(SEMICOLON);
				setState(49);
				ruleLogic();
				}
				}
				setState(54);
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
	public static class AddRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public AddRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAddRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public TerminalNode EQ() { return getToken(DslParser.EQ, 0); }
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public EqRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitEqRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public TerminalNode IN() { return getToken(DslParser.IN, 0); }
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public InRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitInRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContainsRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public TerminalNode CONTAINS() { return getToken(DslParser.CONTAINS, 0); }
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public ContainsRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitContainsRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public MulRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitMulRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GtRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public GtRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitGtRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GeRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public GeRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitGeRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NeRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public TerminalNode NE() { return getToken(DslParser.NE, 0); }
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public NeRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNeRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public DivRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitDivRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubRuleExprContext extends RuleLogicContext {
		public ValueTakeContext lhs;
		public Token op;
		public ValueTakeContext rhs;
		public List<ValueTakeContext> valueTake() {
			return getRuleContexts(ValueTakeContext.class);
		}
		public ValueTakeContext valueTake(int i) {
			return getRuleContext(ValueTakeContext.class,i);
		}
		public List<DictMappingContext> dictMapping() {
			return getRuleContexts(DictMappingContext.class);
		}
		public DictMappingContext dictMapping(int i) {
			return getRuleContext(DictMappingContext.class,i);
		}
		public SubRuleExprContext(RuleLogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitSubRuleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleLogicContext ruleLogic() throws RecognitionException {
		RuleLogicContext _localctx = new RuleLogicContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleLogic);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new EqRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((EqRuleExprContext)_localctx).lhs = valueTake();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(56);
					dictMapping();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				((EqRuleExprContext)_localctx).op = match(EQ);
				setState(63);
				((EqRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 2:
				_localctx = new NeRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((NeRuleExprContext)_localctx).lhs = valueTake();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(66);
					dictMapping();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				((NeRuleExprContext)_localctx).op = match(NE);
				setState(73);
				((NeRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 3:
				_localctx = new InRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				((InRuleExprContext)_localctx).lhs = valueTake();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(76);
					dictMapping();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				((InRuleExprContext)_localctx).op = match(IN);
				setState(83);
				((InRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 4:
				_localctx = new AddRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				((AddRuleExprContext)_localctx).lhs = valueTake();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(86);
					dictMapping();
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				((AddRuleExprContext)_localctx).op = match(T__2);
				setState(93);
				((AddRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 5:
				_localctx = new SubRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				((SubRuleExprContext)_localctx).lhs = valueTake();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(96);
					dictMapping();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				((SubRuleExprContext)_localctx).op = match(T__3);
				setState(103);
				((SubRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 6:
				_localctx = new MulRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				((MulRuleExprContext)_localctx).lhs = valueTake();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(106);
					dictMapping();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				((MulRuleExprContext)_localctx).op = match(T__4);
				setState(113);
				((MulRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 7:
				_localctx = new DivRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				((DivRuleExprContext)_localctx).lhs = valueTake();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(116);
					dictMapping();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				((DivRuleExprContext)_localctx).op = match(T__5);
				setState(123);
				((DivRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 8:
				_localctx = new GtRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				((GtRuleExprContext)_localctx).lhs = valueTake();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(126);
					dictMapping();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				((GtRuleExprContext)_localctx).op = match(T__6);
				setState(133);
				((GtRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 9:
				_localctx = new GeRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(135);
				((GeRuleExprContext)_localctx).lhs = valueTake();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(136);
					dictMapping();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				((GeRuleExprContext)_localctx).op = match(T__7);
				setState(143);
				((GeRuleExprContext)_localctx).rhs = valueTake();
				}
				break;
			case 10:
				_localctx = new ContainsRuleExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(145);
				((ContainsRuleExprContext)_localctx).lhs = valueTake();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(146);
					dictMapping();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				((ContainsRuleExprContext)_localctx).op = match(CONTAINS);
				setState(153);
				((ContainsRuleExprContext)_localctx).rhs = valueTake();
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
			setState(157);
			match(T__8);
			setState(158);
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
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(165);
				match(T__9);
				setState(166);
				outputExpr(0);
				}
				}
				setState(171);
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
			setState(172);
			match(T__10);
			setState(173);
			logicExpr(0);
			setState(174);
			match(T__11);
			setState(175);
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
	public static class NumberTakeContext extends ValueTakeContext {
		public TerminalNode DIGIT() { return getToken(DslParser.DIGIT, 0); }
		public NumberTakeContext(ValueTakeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNumberTake(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringTakeContext extends ValueTakeContext {
		public TerminalNode STRING() { return getToken(DslParser.STRING, 0); }
		public StringTakeContext(ValueTakeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitStringTake(this);
			else return visitor.visitChildren(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class ListTakeContext extends ValueTakeContext {
		public List<TerminalNode> STRING() { return getTokens(DslParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(DslParser.STRING, i);
		}
		public ListTakeContext(ValueTakeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitListTake(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueTakeContext valueTake() throws RecognitionException {
		ValueTakeContext _localctx = new ValueTakeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_valueTake);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
				_localctx = new RuleTakeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(LP);
				setState(178);
				match(ID);
				setState(179);
				match(RP);
				}
				break;
			case T__12:
				_localctx = new RuleTakeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__12);
				setState(181);
				match(ID);
				setState(182);
				match(T__13);
				}
				break;
			case FIELD_TAKE:
				_localctx = new FieldTakeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(FIELD_TAKE);
				}
				break;
			case DIGIT:
				_localctx = new NumberTakeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(DIGIT);
				}
				break;
			case STRING:
				_localctx = new StringTakeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(STRING);
				}
				break;
			case T__0:
				_localctx = new ListTakeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				match(T__0);
				setState(187);
				match(STRING);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(188);
					match(T__14);
					setState(189);
					match(STRING);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
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
	public static class RuleCodeLogicExprContext extends LogicExprContext {
		public Token ruleCode;
		public TerminalNode ID() { return getToken(DslParser.ID, 0); }
		public RuleCodeLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitRuleCodeLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotLogicExprContext extends LogicExprContext {
		public Token op;
		public LogicExprContext rhs;
		public TerminalNode NOT() { return getToken(DslParser.NOT, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public NotLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNotLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestLogicExprContext extends LogicExprContext {
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public NestLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNestLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndLogicExprContext extends LogicExprContext {
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
		public AndLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAndLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrLogicExprContext extends LogicExprContext {
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
		public OrLogicExprContext(LogicExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitOrLogicExpr(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_logicExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotLogicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(199);
				((NotLogicExprContext)_localctx).op = match(NOT);
				setState(200);
				((NotLogicExprContext)_localctx).rhs = logicExpr(5);
				}
				break;
			case LP:
				{
				_localctx = new NestLogicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(LP);
				setState(202);
				logicExpr(0);
				setState(203);
				match(RP);
				}
				break;
			case ID:
				{
				_localctx = new RuleCodeLogicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				((RuleCodeLogicExprContext)_localctx).ruleCode = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AndLogicExprContext(new LogicExprContext(_parentctx, _parentState));
						((AndLogicExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicExpr);
						setState(208);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(209);
						((AndLogicExprContext)_localctx).op = match(AND);
						setState(210);
						((AndLogicExprContext)_localctx).rhs = logicExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new OrLogicExprContext(new LogicExprContext(_parentctx, _parentState));
						((OrLogicExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicExpr);
						setState(211);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(212);
						((OrLogicExprContext)_localctx).op = match(OR);
						setState(213);
						((OrLogicExprContext)_localctx).rhs = logicExpr(4);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
	public static class NumberOutputExprContext extends OutputExprContext {
		public TerminalNode DIGIT() { return getToken(DslParser.DIGIT, 0); }
		public NumberOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNumberOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubOutputExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public SubOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitSubOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivOutputExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public DivOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitDivOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringOutputExprContext extends OutputExprContext {
		public TerminalNode STRING() { return getToken(DslParser.STRING, 0); }
		public StringOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitStringOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulOutputExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public MulOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitMulOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddOutputExprContext extends OutputExprContext {
		public OutputExprContext lhs;
		public Token op;
		public OutputExprContext rhs;
		public List<OutputExprContext> outputExpr() {
			return getRuleContexts(OutputExprContext.class);
		}
		public OutputExprContext outputExpr(int i) {
			return getRuleContext(OutputExprContext.class,i);
		}
		public AddOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitAddOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionOutputExprContext extends OutputExprContext {
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
		public FunctionOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitFunctionOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldOutputExprContext extends OutputExprContext {
		public TerminalNode FIELD_TAKE() { return getToken(DslParser.FIELD_TAKE, 0); }
		public FieldOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitFieldOutputExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestOutputExprContext extends OutputExprContext {
		public TerminalNode LP() { return getToken(DslParser.LP, 0); }
		public OutputExprContext outputExpr() {
			return getRuleContext(OutputExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(DslParser.RP, 0); }
		public NestOutputExprContext(OutputExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DslVisitor ) return ((DslVisitor<? extends T>)visitor).visitNestOutputExpr(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_outputExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new FunctionOutputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(220);
				((FunctionOutputExprContext)_localctx).functionName = match(ID);
				setState(221);
				match(LP);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 3489857536L) != 0) {
					{
					{
					setState(222);
					outputExpr(0);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(RP);
				}
				break;
			case DIGIT:
				{
				_localctx = new NumberOutputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(DIGIT);
				}
				break;
			case STRING:
				{
				_localctx = new StringOutputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(STRING);
				}
				break;
			case FIELD_TAKE:
				{
				_localctx = new FieldOutputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(FIELD_TAKE);
				}
				break;
			case LP:
				{
				_localctx = new NestOutputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(LP);
				setState(233);
				outputExpr(0);
				setState(234);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(250);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MulOutputExprContext(new OutputExprContext(_parentctx, _parentState));
						((MulOutputExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(238);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(239);
						((MulOutputExprContext)_localctx).op = match(T__4);
						setState(240);
						((MulOutputExprContext)_localctx).rhs = outputExpr(9);
						}
						break;
					case 2:
						{
						_localctx = new DivOutputExprContext(new OutputExprContext(_parentctx, _parentState));
						((DivOutputExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(241);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(242);
						((DivOutputExprContext)_localctx).op = match(T__5);
						setState(243);
						((DivOutputExprContext)_localctx).rhs = outputExpr(8);
						}
						break;
					case 3:
						{
						_localctx = new AddOutputExprContext(new OutputExprContext(_parentctx, _parentState));
						((AddOutputExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(244);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(245);
						((AddOutputExprContext)_localctx).op = match(T__2);
						setState(246);
						((AddOutputExprContext)_localctx).rhs = outputExpr(7);
						}
						break;
					case 4:
						{
						_localctx = new SubOutputExprContext(new OutputExprContext(_parentctx, _parentState));
						((SubOutputExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_outputExpr);
						setState(247);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(248);
						((SubOutputExprContext)_localctx).op = match(T__3);
						setState(249);
						((SubOutputExprContext)_localctx).rhs = outputExpr(6);
						}
						break;
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return logicExpr_sempred((LogicExprContext)_localctx, predIndex);
		case 10:
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
		"\u0004\u0001#\u0100\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001&\b\u0001\u000b\u0001\f\u0001\'\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u00033\b\u0003\n\u0003\f\u00036\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0005\u0004:\b\u0004\n\u0004\f\u0004=\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004D\b"+
		"\u0004\n\u0004\f\u0004G\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004N\b\u0004\n\u0004\f\u0004Q\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004X\b"+
		"\u0004\n\u0004\f\u0004[\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004b\b\u0004\n\u0004\f\u0004e\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004l\b"+
		"\u0004\n\u0004\f\u0004o\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004v\b\u0004\n\u0004\f\u0004y\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0080"+
		"\b\u0004\n\u0004\f\u0004\u0083\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u008a\b\u0004\n\u0004\f\u0004\u008d"+
		"\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u0094\b\u0004\n\u0004\f\u0004\u0097\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u009c\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0004\u0006\u00a2\b\u0006\u000b\u0006\f\u0006\u00a3\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00a8\b\u0006\n\u0006\f\u0006\u00ab\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u00bf\b\b\n\b\f\b\u00c2\t\b\u0001\b\u0003\b"+
		"\u00c5\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00cf\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00d7\b\t\n\t\f\t\u00da\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n"+
		"\u00e0\b\n\n\n\f\n\u00e3\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00ed\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00fb"+
		"\b\n\n\n\f\n\u00fe\t\n\u0001\n\u0000\u0002\u0012\u0014\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000\u0120\u0000!\u0001"+
		"\u0000\u0000\u0000\u0002#\u0001\u0000\u0000\u0000\u0004+\u0001\u0000\u0000"+
		"\u0000\u0006.\u0001\u0000\u0000\u0000\b\u009b\u0001\u0000\u0000\u0000"+
		"\n\u009d\u0001\u0000\u0000\u0000\f\u00a1\u0001\u0000\u0000\u0000\u000e"+
		"\u00ac\u0001\u0000\u0000\u0000\u0010\u00c4\u0001\u0000\u0000\u0000\u0012"+
		"\u00ce\u0001\u0000\u0000\u0000\u0014\u00ec\u0001\u0000\u0000\u0000\u0016"+
		"\"\u0003\u0002\u0001\u0000\u0017\u0019\u0003\u0004\u0002\u0000\u0018\u001a"+
		"\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005\u0001\u0000\u0000\u001e\u001f\u0003\f\u0006\u0000\u001f \u0005"+
		"\u0002\u0000\u0000 \"\u0001\u0000\u0000\u0000!\u0016\u0001\u0000\u0000"+
		"\u0000!\u0017\u0001\u0000\u0000\u0000\"\u0001\u0001\u0000\u0000\u0000"+
		"#%\u0003\u0004\u0002\u0000$&\u0003\u0006\u0003\u0000%$\u0001\u0000\u0000"+
		"\u0000&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0003\f\u0006\u0000*\u0003"+
		"\u0001\u0000\u0000\u0000+,\u0005\u001c\u0000\u0000,-\u0005\u001f\u0000"+
		"\u0000-\u0005\u0001\u0000\u0000\u0000./\u0005\u001c\u0000\u0000/4\u0003"+
		"\b\u0004\u000001\u0005\u001a\u0000\u000013\u0003\b\u0004\u000020\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u00005\u0007\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u00007;\u0003\u0010\b\u00008:\u0003\n\u0005\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">?\u0005\u0013\u0000\u0000?@\u0003\u0010\b\u0000@\u009c\u0001\u0000\u0000"+
		"\u0000AE\u0003\u0010\b\u0000BD\u0003\n\u0005\u0000CB\u0001\u0000\u0000"+
		"\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005"+
		"\u0014\u0000\u0000IJ\u0003\u0010\b\u0000J\u009c\u0001\u0000\u0000\u0000"+
		"KO\u0003\u0010\b\u0000LN\u0003\n\u0005\u0000ML\u0001\u0000\u0000\u0000"+
		"NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005\u0016"+
		"\u0000\u0000ST\u0003\u0010\b\u0000T\u009c\u0001\u0000\u0000\u0000UY\u0003"+
		"\u0010\b\u0000VX\u0003\n\u0005\u0000WV\u0001\u0000\u0000\u0000X[\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0003\u0000"+
		"\u0000]^\u0003\u0010\b\u0000^\u009c\u0001\u0000\u0000\u0000_c\u0003\u0010"+
		"\b\u0000`b\u0003\n\u0005\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\u0004\u0000\u0000"+
		"gh\u0003\u0010\b\u0000h\u009c\u0001\u0000\u0000\u0000im\u0003\u0010\b"+
		"\u0000jl\u0003\n\u0005\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005\u0005\u0000\u0000qr\u0003"+
		"\u0010\b\u0000r\u009c\u0001\u0000\u0000\u0000sw\u0003\u0010\b\u0000tv"+
		"\u0003\n\u0005\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z{\u0005\u0006\u0000\u0000{|\u0003\u0010"+
		"\b\u0000|\u009c\u0001\u0000\u0000\u0000}\u0081\u0003\u0010\b\u0000~\u0080"+
		"\u0003\n\u0005\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001"+
		"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u0007\u0000\u0000\u0085\u0086\u0003"+
		"\u0010\b\u0000\u0086\u009c\u0001\u0000\u0000\u0000\u0087\u008b\u0003\u0010"+
		"\b\u0000\u0088\u008a\u0003\n\u0005\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\b\u0000\u0000"+
		"\u008f\u0090\u0003\u0010\b\u0000\u0090\u009c\u0001\u0000\u0000\u0000\u0091"+
		"\u0095\u0003\u0010\b\u0000\u0092\u0094\u0003\n\u0005\u0000\u0093\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u0015\u0000\u0000\u0099\u009a\u0003\u0010\b\u0000\u009a\u009c\u0001"+
		"\u0000\u0000\u0000\u009b7\u0001\u0000\u0000\u0000\u009bA\u0001\u0000\u0000"+
		"\u0000\u009bK\u0001\u0000\u0000\u0000\u009bU\u0001\u0000\u0000\u0000\u009b"+
		"_\u0001\u0000\u0000\u0000\u009bi\u0001\u0000\u0000\u0000\u009bs\u0001"+
		"\u0000\u0000\u0000\u009b}\u0001\u0000\u0000\u0000\u009b\u0087\u0001\u0000"+
		"\u0000\u0000\u009b\u0091\u0001\u0000\u0000\u0000\u009c\t\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005\t\u0000\u0000\u009e\u009f\u0005 \u0000\u0000"+
		"\u009f\u000b\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003\u000e\u0007\u0000"+
		"\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a9\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\n\u0000\u0000\u00a6"+
		"\u00a8\u0003\u0014\n\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\r\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0005\u000b\u0000\u0000\u00ad\u00ae\u0003"+
		"\u0012\t\u0000\u00ae\u00af\u0005\f\u0000\u0000\u00af\u00b0\u0003\u0014"+
		"\n\u0000\u00b0\u000f\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0011\u0000"+
		"\u0000\u00b2\u00b3\u0005\u001c\u0000\u0000\u00b3\u00c5\u0005\u0012\u0000"+
		"\u0000\u00b4\u00b5\u0005\r\u0000\u0000\u00b5\u00b6\u0005\u001c\u0000\u0000"+
		"\u00b6\u00c5\u0005\u000e\u0000\u0000\u00b7\u00c5\u0005\u0010\u0000\u0000"+
		"\u00b8\u00c5\u0005\u001e\u0000\u0000\u00b9\u00c5\u0005\u001f\u0000\u0000"+
		"\u00ba\u00bb\u0005\u0001\u0000\u0000\u00bb\u00c0\u0005\u001f\u0000\u0000"+
		"\u00bc\u00bd\u0005\u000f\u0000\u0000\u00bd\u00bf\u0005\u001f\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c5\u0005\u0002\u0000\u0000\u00c4\u00b1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00b4\u0001\u0000\u0000\u0000\u00c4\u00b7\u0001\u0000\u0000\u0000"+
		"\u00c4\u00b8\u0001\u0000\u0000\u0000\u00c4\u00b9\u0001\u0000\u0000\u0000"+
		"\u00c4\u00ba\u0001\u0000\u0000\u0000\u00c5\u0011\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0006\t\uffff\uffff\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000"+
		"\u00c8\u00cf\u0003\u0012\t\u0005\u00c9\u00ca\u0005\u0011\u0000\u0000\u00ca"+
		"\u00cb\u0003\u0012\t\u0000\u00cb\u00cc\u0005\u0012\u0000\u0000\u00cc\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u001c\u0000\u0000\u00ce\u00c6"+
		"\u0001\u0000\u0000\u0000\u00ce\u00c9\u0001\u0000\u0000\u0000\u00ce\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d8\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\n\u0004\u0000\u0000\u00d1\u00d2\u0005\u0018\u0000\u0000\u00d2\u00d7\u0003"+
		"\u0012\t\u0005\u00d3\u00d4\n\u0003\u0000\u0000\u00d4\u00d5\u0005\u0019"+
		"\u0000\u0000\u00d5\u00d7\u0003\u0012\t\u0004\u00d6\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u0013\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0006\n\uffff\uffff\u0000\u00dc\u00dd\u0005\u001c\u0000"+
		"\u0000\u00dd\u00e1\u0005\u0011\u0000\u0000\u00de\u00e0\u0003\u0014\n\u0000"+
		"\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e4\u00ed\u0005\u0012\u0000\u0000\u00e5\u00ed\u0005\u001e\u0000\u0000"+
		"\u00e6\u00ed\u0005\u001f\u0000\u0000\u00e7\u00ed\u0005\u0010\u0000\u0000"+
		"\u00e8\u00e9\u0005\u0011\u0000\u0000\u00e9\u00ea\u0003\u0014\n\u0000\u00ea"+
		"\u00eb\u0005\u0012\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec"+
		"\u00db\u0001\u0000\u0000\u0000\u00ec\u00e5\u0001\u0000\u0000\u0000\u00ec"+
		"\u00e6\u0001\u0000\u0000\u0000\u00ec\u00e7\u0001\u0000\u0000\u0000\u00ec"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ed\u00fc\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\n\b\u0000\u0000\u00ef\u00f0\u0005\u0005\u0000\u0000\u00f0\u00fb"+
		"\u0003\u0014\n\t\u00f1\u00f2\n\u0007\u0000\u0000\u00f2\u00f3\u0005\u0006"+
		"\u0000\u0000\u00f3\u00fb\u0003\u0014\n\b\u00f4\u00f5\n\u0006\u0000\u0000"+
		"\u00f5\u00f6\u0005\u0003\u0000\u0000\u00f6\u00fb\u0003\u0014\n\u0007\u00f7"+
		"\u00f8\n\u0005\u0000\u0000\u00f8\u00f9\u0005\u0004\u0000\u0000\u00f9\u00fb"+
		"\u0003\u0014\n\u0006\u00fa\u00ee\u0001\u0000\u0000\u0000\u00fa\u00f1\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f4\u0001\u0000\u0000\u0000\u00fa\u00f7\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0015\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u001a\u001b!\'"+
		"4;EOYcmw\u0081\u008b\u0095\u009b\u00a3\u00a9\u00c0\u00c4\u00ce\u00d6\u00d8"+
		"\u00e1\u00ec\u00fa\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}