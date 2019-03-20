// Generated from src/parser/Cmm.g4 by ANTLR 4.7
package parser;

import ast.*;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, ID=41, CHAR_CONSTANT=42, INT_CONSTANT=43, REAL_CONSTANT=44, 
		LINE_COMMENT=45, MULTI_LINE_COMMENT=46, WHITE_SPACES=47;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_funcDef = 2, RULE_mainDef = 3, 
		RULE_params = 4, RULE_varDefs = 5, RULE_fieldDefs = 6, RULE_ids = 7, RULE_type = 8, 
		RULE_statments = 9, RULE_statment = 10, RULE_assigment = 11, RULE_ifStat = 12, 
		RULE_block = 13, RULE_args = 14, RULE_expr = 15;
	public static final String[] ruleNames = {
		"program", "definitions", "funcDef", "mainDef", "params", "varDefs", "fieldDefs", 
		"ids", "type", "statments", "statment", "assigment", "ifStat", "block", 
		"args", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "'void'", "'main'", "','", "';'", "'int'", 
		"'double'", "'char'", "'['", "']'", "'struct'", "'*'", "'while'", "'return'", 
		"'write'", "'read'", "'for'", "'break'", "'continue'", "'='", "'if'", 
		"'else'", "'.'", "'&'", "'/'", "'%'", "'+'", "'-'", "'!'", "'=='", "'!='", 
		"'<='", "'>='", "'<'", "'>'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "ID", "CHAR_CONSTANT", "INT_CONSTANT", "REAL_CONSTANT", 
		"LINE_COMMENT", "MULTI_LINE_COMMENT", "WHITE_SPACES"
	};
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((ProgramContext)_localctx).definitions = definitions();
			 ((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).definitions.ast); 
			setState(34);
			match(EOF);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public VarDefsContext varDefs;
		public FuncDefContext funcDef;
		public MainDefContext mainDef;
		public MainDefContext mainDef() {
			return getRuleContext(MainDefContext.class,0);
		}
		public List<VarDefsContext> varDefs() {
			return getRuleContexts(VarDefsContext.class);
		}
		public VarDefsContext varDefs(int i) {
			return getRuleContext(VarDefsContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(42);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(36);
						((DefinitionsContext)_localctx).varDefs = varDefs();
						 _localctx.ast.addAll(((DefinitionsContext)_localctx).varDefs.ast); 
						}
						break;
					case 2:
						{
						setState(39);
						((DefinitionsContext)_localctx).funcDef = funcDef();
						 _localctx.ast.add(((DefinitionsContext)_localctx).funcDef.ast); 
						}
						break;
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(47);
			((DefinitionsContext)_localctx).mainDef = mainDef();
			 _localctx.ast.add(((DefinitionsContext)_localctx).mainDef.ast); 
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

	public static class FuncDefContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public TypeContext type;
		public Token ID;
		public ParamsContext params;
		public StatmentsContext statments;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public StatmentsContext statments() {
			return getRuleContext(StatmentsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((FuncDefContext)_localctx).type = type(0);
			setState(51);
			((FuncDefContext)_localctx).ID = match(ID);
			setState(52);
			match(T__0);
			setState(53);
			((FuncDefContext)_localctx).params = params();
			setState(54);
			match(T__1);
			setState(55);
			match(T__2);
			setState(56);
			((FuncDefContext)_localctx).statments = statments();
			setState(57);
			match(T__3);
			 ((FuncDefContext)_localctx).ast =  new FunctionDefinition((((FuncDefContext)_localctx).ID!=null?((FuncDefContext)_localctx).ID.getText():null),new FunctionType(((FuncDefContext)_localctx).type.ast, ((FuncDefContext)_localctx).params.ast),((FuncDefContext)_localctx).statments.ast); _localctx.ast.setLine((((FuncDefContext)_localctx).ID!=null?((FuncDefContext)_localctx).ID.getLine():0)); _localctx.ast.setColumn(((FuncDefContext)_localctx).ID.getCharPositionInLine() + 1);
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

	public static class MainDefContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Token t;
		public StatmentsContext statments;
		public StatmentsContext statments() {
			return getRuleContext(StatmentsContext.class,0);
		}
		public MainDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDef; }
	}

	public final MainDefContext mainDef() throws RecognitionException {
		MainDefContext _localctx = new MainDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__4);
			setState(61);
			((MainDefContext)_localctx).t = match(T__5);
			setState(62);
			match(T__0);
			setState(63);
			match(T__1);
			setState(64);
			match(T__2);
			setState(65);
			((MainDefContext)_localctx).statments = statments();
			setState(66);
			match(T__3);
			 ((MainDefContext)_localctx).ast =  new FunctionDefinition("main",new FunctionType(new VoidType()),((MainDefContext)_localctx).statments.ast); _localctx.ast.setLine((((MainDefContext)_localctx).t!=null?((MainDefContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((MainDefContext)_localctx).t.getCharPositionInLine() + 1);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<VariableDeclaration> ast = new ArrayList<VariableDeclaration>();
		public TypeContext t1;
		public TypeContext type;
		public Token id1;
		public TypeContext t2;
		public Token id2;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13))) != 0)) {
				{
				setState(69);
				((ParamsContext)_localctx).t1 = ((ParamsContext)_localctx).type = type(0);
				setState(70);
				((ParamsContext)_localctx).id1 = match(ID);
				 _localctx.ast.add(new VariableDeclaration(((ParamsContext)_localctx).type.ast, (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getText():null))); 
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(72);
					match(T__6);
					setState(73);
					((ParamsContext)_localctx).t2 = ((ParamsContext)_localctx).type = type(0);
					setState(74);
					((ParamsContext)_localctx).id2 = match(ID);
					 _localctx.ast.add(new VariableDeclaration(((ParamsContext)_localctx).type.ast, (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null))); 
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class VarDefsContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public TypeContext type;
		public IdsContext ids;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public VarDefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefs; }
	}

	public final VarDefsContext varDefs() throws RecognitionException {
		VarDefsContext _localctx = new VarDefsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDefs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((VarDefsContext)_localctx).type = type(0);
			setState(85);
			((VarDefsContext)_localctx).ids = ids();
			setState(86);
			match(T__7);
			 
			       		for (String id : ((VarDefsContext)_localctx).ids.ast) {
			       			VariableDefinition vd = new VariableDefinition(((VarDefsContext)_localctx).type.ast, id);
			       			vd.setLine(((VarDefsContext)_localctx).type.ast.getLine());
			       			vd.setColumn(((VarDefsContext)_localctx).type.ast.getColumn());
			       			_localctx.ast.add(vd); 
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

	public static class FieldDefsContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public TypeContext type;
		public IdsContext ids;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public FieldDefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefs; }
	}

	public final FieldDefsContext fieldDefs() throws RecognitionException {
		FieldDefsContext _localctx = new FieldDefsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDefs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13))) != 0)) {
				{
				{
				setState(89);
				((FieldDefsContext)_localctx).type = type(0);
				setState(90);
				((FieldDefsContext)_localctx).ids = ids();
				setState(91);
				match(T__7);
				 
				       		for (String id : ((FieldDefsContext)_localctx).ids.ast) {
				       			VariableDefinition vd = new VariableDefinition(((FieldDefsContext)_localctx).type.ast, id);
				       			vd.setLine(((FieldDefsContext)_localctx).type.ast.getLine());
				       			vd.setColumn(((FieldDefsContext)_localctx).type.ast.getColumn());
				       			_localctx.ast.add(vd); 
				       		}
				       
				}
				}
				setState(98);
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

	public static class IdsContext extends ParserRuleContext {
		public List<String> ast = new ArrayList<String>();
		public Token id1;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((IdsContext)_localctx).id1 = match(ID);
			 _localctx.ast.add((((IdsContext)_localctx).id1!=null?((IdsContext)_localctx).id1.getText():null)); 
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(101);
				match(T__6);
				setState(102);
				((IdsContext)_localctx).id2 = match(ID);
				 _localctx.ast.add((((IdsContext)_localctx).id2!=null?((IdsContext)_localctx).id2.getText():null)); 
				}
				}
				setState(108);
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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t2;
		public Token t;
		public FieldDefsContext fieldDefs;
		public Token INT_CONSTANT;
		public FieldDefsContext fieldDefs() {
			return getRuleContext(FieldDefsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(110);
				((TypeContext)_localctx).t = match(T__4);
				 ((TypeContext)_localctx).ast =  new VoidType(); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case T__8:
				{
				setState(112);
				((TypeContext)_localctx).t = match(T__8);
				 ((TypeContext)_localctx).ast =  new IntegerType(); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case T__9:
				{
				setState(114);
				((TypeContext)_localctx).t = match(T__9);
				 ((TypeContext)_localctx).ast =  new DoubleType(); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case T__10:
				{
				setState(116);
				((TypeContext)_localctx).t = match(T__10);
				 ((TypeContext)_localctx).ast =  new CharType(); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case T__13:
				{
				setState(118);
				((TypeContext)_localctx).t = match(T__13);
				setState(119);
				match(T__2);
				setState(120);
				((TypeContext)_localctx).fieldDefs = fieldDefs();
				setState(121);
				match(T__3);
				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).fieldDefs.ast); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new TypeContext(_parentctx, _parentState);
						_localctx.t2 = _prevctx;
						_localctx.t2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(126);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(127);
						((TypeContext)_localctx).t = match(T__11);
						setState(128);
						((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
						setState(129);
						match(T__12);
						 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t2.ast, Integer.parseInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null))); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
						}
						break;
					case 2:
						{
						_localctx = new TypeContext(_parentctx, _parentState);
						_localctx.t2 = _prevctx;
						_localctx.t2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(131);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(132);
						((TypeContext)_localctx).t = match(T__14);
						 ((TypeContext)_localctx).ast =  new PointerType(((TypeContext)_localctx).t2.ast); _localctx.ast.setLine((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((TypeContext)_localctx).t.getCharPositionInLine() + 1); 
						}
						break;
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class StatmentsContext extends ParserRuleContext {
		public List<Statment> ast = new ArrayList<Statment>();
		public StatmentContext statment;
		public TypeContext type;
		public IdsContext ids;
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdsContext> ids() {
			return getRuleContexts(IdsContext.class);
		}
		public IdsContext ids(int i) {
			return getRuleContext(IdsContext.class,i);
		}
		public StatmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statments; }
	}

	public final StatmentsContext statments() throws RecognitionException {
		StatmentsContext _localctx = new StatmentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__26) | (1L << T__30) | (1L << T__31) | (1L << ID) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
				{
				setState(147);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__23:
				case T__26:
				case T__30:
				case T__31:
				case ID:
				case CHAR_CONSTANT:
				case INT_CONSTANT:
				case REAL_CONSTANT:
					{
					setState(139);
					((StatmentsContext)_localctx).statment = statment();
					 _localctx.ast.add(((StatmentsContext)_localctx).statment.ast); 
					}
					break;
				case T__4:
				case T__8:
				case T__9:
				case T__10:
				case T__13:
					{
					setState(142);
					((StatmentsContext)_localctx).type = type(0);
					setState(143);
					((StatmentsContext)_localctx).ids = ids();
					setState(144);
					match(T__7);
					 
					      		for (String id : ((StatmentsContext)_localctx).ids.ast) {
					      		    VariableDeclaration vd = new VariableDeclaration(((StatmentsContext)_localctx).type.ast, id);
					      		    vd.setLine(((StatmentsContext)_localctx).type.ast.getLine());
					      		    vd.setColumn(((StatmentsContext)_localctx).type.ast.getColumn());
					       			_localctx.ast.add(vd); 
					       		}
					       
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(151);
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

	public static class StatmentContext extends ParserRuleContext {
		public Statment ast;
		public AssigmentContext assigment;
		public IfStatContext ifStat;
		public Token t;
		public ExprContext expr;
		public BlockContext block;
		public ArgsContext args;
		public Token ID;
		public AssigmentContext vars;
		public ExprContext cond;
		public AssigmentContext incr;
		public List<AssigmentContext> assigment() {
			return getRuleContexts(AssigmentContext.class);
		}
		public AssigmentContext assigment(int i) {
			return getRuleContext(AssigmentContext.class,i);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statment);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((StatmentContext)_localctx).assigment = assigment();
				setState(153);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  ((StatmentContext)_localctx).assigment.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				((StatmentContext)_localctx).ifStat = ifStat();
				 ((StatmentContext)_localctx).ast =  ((StatmentContext)_localctx).ifStat.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				((StatmentContext)_localctx).t = match(T__15);
				setState(160);
				match(T__0);
				setState(161);
				((StatmentContext)_localctx).expr = expr(0);
				setState(162);
				match(T__1);
				setState(163);
				((StatmentContext)_localctx).block = block();
				 ((StatmentContext)_localctx).ast =  new While(((StatmentContext)_localctx).expr.ast, ((StatmentContext)_localctx).block.ast); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				((StatmentContext)_localctx).t = match(T__16);
				setState(167);
				((StatmentContext)_localctx).expr = expr(0);
				setState(168);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Return(((StatmentContext)_localctx).expr.ast); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				((StatmentContext)_localctx).t = match(T__16);
				setState(172);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Return(); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				((StatmentContext)_localctx).t = match(T__17);
				setState(175);
				((StatmentContext)_localctx).args = args();
				setState(176);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Write(((StatmentContext)_localctx).args.ast); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(179);
				((StatmentContext)_localctx).t = match(T__18);
				setState(180);
				((StatmentContext)_localctx).expr = expr(0);
				setState(181);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Read(((StatmentContext)_localctx).expr.ast); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(184);
				((StatmentContext)_localctx).ID = match(ID);
				setState(185);
				((StatmentContext)_localctx).t = match(T__0);
				setState(186);
				((StatmentContext)_localctx).args = args();
				setState(187);
				match(T__1);
				setState(188);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Invocation((((StatmentContext)_localctx).ID!=null?((StatmentContext)_localctx).ID.getText():null), ((StatmentContext)_localctx).args.ast); _localctx.ast.setLine((((StatmentContext)_localctx).t!=null?((StatmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(191);
				((StatmentContext)_localctx).t = match(T__19);
				setState(192);
				match(T__0);
				setState(193);
				((StatmentContext)_localctx).vars = assigment();
				setState(194);
				match(T__7);
				setState(195);
				((StatmentContext)_localctx).cond = expr(0);
				setState(196);
				match(T__7);
				setState(197);
				((StatmentContext)_localctx).incr = assigment();
				setState(198);
				match(T__1);
				setState(199);
				((StatmentContext)_localctx).block = block();
				 ((StatmentContext)_localctx).ast =  new For(((StatmentContext)_localctx).vars.ast,((StatmentContext)_localctx).cond.ast,((StatmentContext)_localctx).incr.ast,((StatmentContext)_localctx).block.ast); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(202);
				((StatmentContext)_localctx).t = match(T__20);
				setState(203);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Break(); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(205);
				((StatmentContext)_localctx).t = match(T__21);
				setState(206);
				match(T__7);
				 ((StatmentContext)_localctx).ast =  new Continue(); _localctx.ast.setColumn(((StatmentContext)_localctx).t.getCharPositionInLine() + 1); 
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

	public static class AssigmentContext extends ParserRuleContext {
		public Statment ast;
		public ExprContext e1;
		public Token t;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigment; }
	}

	public final AssigmentContext assigment() throws RecognitionException {
		AssigmentContext _localctx = new AssigmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((AssigmentContext)_localctx).e1 = expr(0);
			setState(211);
			((AssigmentContext)_localctx).t = match(T__22);
			setState(212);
			((AssigmentContext)_localctx).e2 = expr(0);
			 ((AssigmentContext)_localctx).ast =  new Assignment(((AssigmentContext)_localctx).e1.ast, ((AssigmentContext)_localctx).e2.ast); _localctx.ast.setLine((((AssigmentContext)_localctx).t!=null?((AssigmentContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((AssigmentContext)_localctx).t.getCharPositionInLine() + 1); 
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

	public static class IfStatContext extends ParserRuleContext {
		public If ast;
		public Token t;
		public ExprContext expr;
		public BlockContext block;
		public BlockContext b1;
		public BlockContext b2;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStat);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((IfStatContext)_localctx).t = match(T__23);
				setState(216);
				match(T__0);
				setState(217);
				((IfStatContext)_localctx).expr = expr(0);
				setState(218);
				match(T__1);
				setState(219);
				((IfStatContext)_localctx).block = block();
				 ((IfStatContext)_localctx).ast =  new If(((IfStatContext)_localctx).expr.ast, ((IfStatContext)_localctx).block.ast); _localctx.ast.setLine((((IfStatContext)_localctx).t!=null?((IfStatContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((IfStatContext)_localctx).t.getCharPositionInLine() + 1); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				((IfStatContext)_localctx).t = match(T__23);
				setState(223);
				match(T__0);
				setState(224);
				((IfStatContext)_localctx).expr = expr(0);
				setState(225);
				match(T__1);
				setState(226);
				((IfStatContext)_localctx).b1 = block();
				setState(227);
				match(T__24);
				setState(228);
				((IfStatContext)_localctx).b2 = block();
				 ((IfStatContext)_localctx).ast =  new If(((IfStatContext)_localctx).expr.ast, ((IfStatContext)_localctx).b1.ast, ((IfStatContext)_localctx).b2.ast); _localctx.ast.setLine((((IfStatContext)_localctx).t!=null?((IfStatContext)_localctx).t.getLine():0)); _localctx.ast.setColumn(((IfStatContext)_localctx).t.getCharPositionInLine() + 1); 
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

	public static class BlockContext extends ParserRuleContext {
		public List<Statment> ast = new ArrayList<Statment>();
		public StatmentContext statment;
		public StatmentsContext statments;
		public StatmentContext statment() {
			return getRuleContext(StatmentContext.class,0);
		}
		public StatmentsContext statments() {
			return getRuleContext(StatmentsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__26:
			case T__30:
			case T__31:
			case ID:
			case CHAR_CONSTANT:
			case INT_CONSTANT:
			case REAL_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				((BlockContext)_localctx).statment = statment();
				 _localctx.ast.add(((BlockContext)_localctx).statment.ast); 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__2);
				setState(237);
				((BlockContext)_localctx).statments = statments();
				setState(238);
				match(T__3);
				 _localctx.ast.addAll(((BlockContext)_localctx).statments.ast);  
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

	public static class ArgsContext extends ParserRuleContext {
		public List<Expresion> ast = new ArrayList<Expresion>();
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__26) | (1L << T__30) | (1L << T__31) | (1L << ID) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
				{
				setState(243);
				((ArgsContext)_localctx).expr = expr(0);
				 _localctx.ast.add(((ArgsContext)_localctx).expr.ast); 
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(245);
					match(T__6);
					setState(246);
					((ArgsContext)_localctx).expr = expr(0);
					 _localctx.ast.add(((ArgsContext)_localctx).expr.ast); 
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ExprContext extends ParserRuleContext {
		public Expresion ast;
		public ExprContext e1;
		public ExprContext e;
		public ExprContext expr;
		public Token ID;
		public Token op;
		public TypeContext type;
		public ArgsContext args;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(257);
				match(T__0);
				setState(258);
				((ExprContext)_localctx).expr = expr(0);
				setState(259);
				match(T__1);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 2:
				{
				setState(262);
				((ExprContext)_localctx).ID = match(ID);
				 ((ExprContext)_localctx).ast =  new Ident((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null)); _localctx.ast.setLine((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).ID.getCharPositionInLine() + 1); 
				}
				break;
			case 3:
				{
				setState(264);
				((ExprContext)_localctx).op = match(T__0);
				setState(265);
				((ExprContext)_localctx).type = type(0);
				setState(266);
				match(T__1);
				setState(267);
				((ExprContext)_localctx).expr = expr(12);
				 ((ExprContext)_localctx).ast =  new Cast(((ExprContext)_localctx).type.ast, ((ExprContext)_localctx).expr.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
				}
				break;
			case 4:
				{
				setState(270);
				((ExprContext)_localctx).op = match(T__26);
				setState(271);
				((ExprContext)_localctx).expr = expr(11);
				 ((ExprContext)_localctx).ast =  new Address(((ExprContext)_localctx).expr.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
				}
				break;
			case 5:
				{
				setState(274);
				((ExprContext)_localctx).op = match(T__14);
				setState(275);
				((ExprContext)_localctx).expr = expr(10);
				 ((ExprContext)_localctx).ast =  new UnaryOperator((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).expr.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
				}
				break;
			case 6:
				{
				setState(278);
				((ExprContext)_localctx).ID = match(ID);
				setState(279);
				((ExprContext)_localctx).op = match(T__0);
				setState(280);
				((ExprContext)_localctx).args = args();
				setState(281);
				match(T__1);
				 ((ExprContext)_localctx).ast =  new Call((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null), ((ExprContext)_localctx).args.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
				}
				break;
			case 7:
				{
				setState(284);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(285);
				((ExprContext)_localctx).expr = expr(6);
				 ((ExprContext)_localctx).ast =  new UnaryOperator((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).expr.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
				}
				break;
			case 8:
				{
				setState(288);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new IntLiteral((((ExprContext)_localctx).INT_CONSTANT!=null?((ExprContext)_localctx).INT_CONSTANT.getText():null)); _localctx.ast.setLine((((ExprContext)_localctx).INT_CONSTANT!=null?((ExprContext)_localctx).INT_CONSTANT.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 9:
				{
				setState(290);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new DoubleLiteral((((ExprContext)_localctx).REAL_CONSTANT!=null?((ExprContext)_localctx).REAL_CONSTANT.getText():null)); _localctx.ast.setLine((((ExprContext)_localctx).REAL_CONSTANT!=null?((ExprContext)_localctx).REAL_CONSTANT.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 10:
				{
				setState(292);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new CharLiteral((((ExprContext)_localctx).CHAR_CONSTANT!=null?((ExprContext)_localctx).CHAR_CONSTANT.getText():null));   _localctx.ast.setLine((((ExprContext)_localctx).CHAR_CONSTANT!=null?((ExprContext)_localctx).CHAR_CONSTANT.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(326);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(296);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(297);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(9);
						 ((ExprContext)_localctx).ast =  new BinaryOperator(((ExprContext)_localctx).e1.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e2.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(302);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(303);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(8);
						 ((ExprContext)_localctx).ast =  new BinaryOperator(((ExprContext)_localctx).e1.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e2.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(307);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new BinaryOperator(((ExprContext)_localctx).e1.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e2.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(312);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(313);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).ast =  new BinaryOperator(((ExprContext)_localctx).e1.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e2.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(317);
						((ExprContext)_localctx).op = match(T__11);
						setState(318);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(0);
						setState(319);
						match(T__12);
						 ((ExprContext)_localctx).ast =  new ArrayAccess(((ExprContext)_localctx).e1.ast, ((ExprContext)_localctx).e2.ast); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(323);
						((ExprContext)_localctx).op = match(T__25);
						setState(324);
						((ExprContext)_localctx).ID = match(ID);
						 ((ExprContext)_localctx).ast =  new StructAccess(((ExprContext)_localctx).e.ast, (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null)); _localctx.ast.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0)); _localctx.ast.setColumn(((ExprContext)_localctx).op.getCharPositionInLine() + 1); 
						}
						break;
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		case 8:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u014e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6\5\6U\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\ba\n\b\f\b\16\bd\13\b\3\t"+
		"\3\t\3\t\3\t\3\t\7\tk\n\t\f\t\16\tn\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\177\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d3"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ea\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00f4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u00fc\n\20\f\20\16\20\u00ff\13\20\5\20\u0101\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0129\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0149\n\21"+
		"\f\21\16\21\u014c\13\21\3\21\2\4\22 \22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\7\3\2!\"\4\2\21\21\36\37\3\2 !\3\2#(\3\2)*\2\u0168\2\"\3"+
		"\2\2\2\4.\3\2\2\2\6\64\3\2\2\2\b>\3\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16b\3"+
		"\2\2\2\20e\3\2\2\2\22~\3\2\2\2\24\u0097\3\2\2\2\26\u00d2\3\2\2\2\30\u00d4"+
		"\3\2\2\2\32\u00e9\3\2\2\2\34\u00f3\3\2\2\2\36\u0100\3\2\2\2 \u0128\3\2"+
		"\2\2\"#\5\4\3\2#$\b\2\1\2$%\7\2\2\3%\3\3\2\2\2&\'\5\f\7\2\'(\b\3\1\2("+
		"-\3\2\2\2)*\5\6\4\2*+\b\3\1\2+-\3\2\2\2,&\3\2\2\2,)\3\2\2\2-\60\3\2\2"+
		"\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\5\b\5\2\62\63\b\3"+
		"\1\2\63\5\3\2\2\2\64\65\5\22\n\2\65\66\7+\2\2\66\67\7\3\2\2\678\5\n\6"+
		"\289\7\4\2\29:\7\5\2\2:;\5\24\13\2;<\7\6\2\2<=\b\4\1\2=\7\3\2\2\2>?\7"+
		"\7\2\2?@\7\b\2\2@A\7\3\2\2AB\7\4\2\2BC\7\5\2\2CD\5\24\13\2DE\7\6\2\2E"+
		"F\b\5\1\2F\t\3\2\2\2GH\5\22\n\2HI\7+\2\2IQ\b\6\1\2JK\7\t\2\2KL\5\22\n"+
		"\2LM\7+\2\2MN\b\6\1\2NP\3\2\2\2OJ\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2TG\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VW\5\22\n\2WX\5"+
		"\20\t\2XY\7\n\2\2YZ\b\7\1\2Z\r\3\2\2\2[\\\5\22\n\2\\]\5\20\t\2]^\7\n\2"+
		"\2^_\b\b\1\2_a\3\2\2\2`[\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\17\3\2"+
		"\2\2db\3\2\2\2ef\7+\2\2fl\b\t\1\2gh\7\t\2\2hi\7+\2\2ik\b\t\1\2jg\3\2\2"+
		"\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\21\3\2\2\2nl\3\2\2\2op\b\n\1\2pq\7\7"+
		"\2\2q\177\b\n\1\2rs\7\13\2\2s\177\b\n\1\2tu\7\f\2\2u\177\b\n\1\2vw\7\r"+
		"\2\2w\177\b\n\1\2xy\7\20\2\2yz\7\5\2\2z{\5\16\b\2{|\7\6\2\2|}\b\n\1\2"+
		"}\177\3\2\2\2~o\3\2\2\2~r\3\2\2\2~t\3\2\2\2~v\3\2\2\2~x\3\2\2\2\177\u008a"+
		"\3\2\2\2\u0080\u0081\f\5\2\2\u0081\u0082\7\16\2\2\u0082\u0083\7-\2\2\u0083"+
		"\u0084\7\17\2\2\u0084\u0089\b\n\1\2\u0085\u0086\f\3\2\2\u0086\u0087\7"+
		"\21\2\2\u0087\u0089\b\n\1\2\u0088\u0080\3\2\2\2\u0088\u0085\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\23\3\2\2"+
		"\2\u008c\u008a\3\2\2\2\u008d\u008e\5\26\f\2\u008e\u008f\b\13\1\2\u008f"+
		"\u0096\3\2\2\2\u0090\u0091\5\22\n\2\u0091\u0092\5\20\t\2\u0092\u0093\7"+
		"\n\2\2\u0093\u0094\b\13\1\2\u0094\u0096\3\2\2\2\u0095\u008d\3\2\2\2\u0095"+
		"\u0090\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\25\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\5\30\r\2\u009b\u009c"+
		"\7\n\2\2\u009c\u009d\b\f\1\2\u009d\u00d3\3\2\2\2\u009e\u009f\5\32\16\2"+
		"\u009f\u00a0\b\f\1\2\u00a0\u00d3\3\2\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3"+
		"\7\3\2\2\u00a3\u00a4\5 \21\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6\5\34\17\2"+
		"\u00a6\u00a7\b\f\1\2\u00a7\u00d3\3\2\2\2\u00a8\u00a9\7\23\2\2\u00a9\u00aa"+
		"\5 \21\2\u00aa\u00ab\7\n\2\2\u00ab\u00ac\b\f\1\2\u00ac\u00d3\3\2\2\2\u00ad"+
		"\u00ae\7\23\2\2\u00ae\u00af\7\n\2\2\u00af\u00d3\b\f\1\2\u00b0\u00b1\7"+
		"\24\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7\n\2\2\u00b3\u00b4\b\f\1\2"+
		"\u00b4\u00d3\3\2\2\2\u00b5\u00b6\7\25\2\2\u00b6\u00b7\5 \21\2\u00b7\u00b8"+
		"\7\n\2\2\u00b8\u00b9\b\f\1\2\u00b9\u00d3\3\2\2\2\u00ba\u00bb\7+\2\2\u00bb"+
		"\u00bc\7\3\2\2\u00bc\u00bd\5\36\20\2\u00bd\u00be\7\4\2\2\u00be\u00bf\7"+
		"\n\2\2\u00bf\u00c0\b\f\1\2\u00c0\u00d3\3\2\2\2\u00c1\u00c2\7\26\2\2\u00c2"+
		"\u00c3\7\3\2\2\u00c3\u00c4\5\30\r\2\u00c4\u00c5\7\n\2\2\u00c5\u00c6\5"+
		" \21\2\u00c6\u00c7\7\n\2\2\u00c7\u00c8\5\30\r\2\u00c8\u00c9\7\4\2\2\u00c9"+
		"\u00ca\5\34\17\2\u00ca\u00cb\b\f\1\2\u00cb\u00d3\3\2\2\2\u00cc\u00cd\7"+
		"\27\2\2\u00cd\u00ce\7\n\2\2\u00ce\u00d3\b\f\1\2\u00cf\u00d0\7\30\2\2\u00d0"+
		"\u00d1\7\n\2\2\u00d1\u00d3\b\f\1\2\u00d2\u009a\3\2\2\2\u00d2\u009e\3\2"+
		"\2\2\u00d2\u00a1\3\2\2\2\u00d2\u00a8\3\2\2\2\u00d2\u00ad\3\2\2\2\u00d2"+
		"\u00b0\3\2\2\2\u00d2\u00b5\3\2\2\2\u00d2\u00ba\3\2\2\2\u00d2\u00c1\3\2"+
		"\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3\27\3\2\2\2\u00d4\u00d5"+
		"\5 \21\2\u00d5\u00d6\7\31\2\2\u00d6\u00d7\5 \21\2\u00d7\u00d8\b\r\1\2"+
		"\u00d8\31\3\2\2\2\u00d9\u00da\7\32\2\2\u00da\u00db\7\3\2\2\u00db\u00dc"+
		"\5 \21\2\u00dc\u00dd\7\4\2\2\u00dd\u00de\5\34\17\2\u00de\u00df\b\16\1"+
		"\2\u00df\u00ea\3\2\2\2\u00e0\u00e1\7\32\2\2\u00e1\u00e2\7\3\2\2\u00e2"+
		"\u00e3\5 \21\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\5\34\17\2\u00e5\u00e6\7"+
		"\33\2\2\u00e6\u00e7\5\34\17\2\u00e7\u00e8\b\16\1\2\u00e8\u00ea\3\2\2\2"+
		"\u00e9\u00d9\3\2\2\2\u00e9\u00e0\3\2\2\2\u00ea\33\3\2\2\2\u00eb\u00ec"+
		"\5\26\f\2\u00ec\u00ed\b\17\1\2\u00ed\u00f4\3\2\2\2\u00ee\u00ef\7\5\2\2"+
		"\u00ef\u00f0\5\24\13\2\u00f0\u00f1\7\6\2\2\u00f1\u00f2\b\17\1\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4\35\3\2\2"+
		"\2\u00f5\u00f6\5 \21\2\u00f6\u00fd\b\20\1\2\u00f7\u00f8\7\t\2\2\u00f8"+
		"\u00f9\5 \21\2\u00f9\u00fa\b\20\1\2\u00fa\u00fc\3\2\2\2\u00fb\u00f7\3"+
		"\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u00f5\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\37\3\2\2\2\u0102\u0103\b\21\1\2\u0103\u0104\7\3\2\2\u0104\u0105"+
		"\5 \21\2\u0105\u0106\7\4\2\2\u0106\u0107\b\21\1\2\u0107\u0129\3\2\2\2"+
		"\u0108\u0109\7+\2\2\u0109\u0129\b\21\1\2\u010a\u010b\7\3\2\2\u010b\u010c"+
		"\5\22\n\2\u010c\u010d\7\4\2\2\u010d\u010e\5 \21\16\u010e\u010f\b\21\1"+
		"\2\u010f\u0129\3\2\2\2\u0110\u0111\7\35\2\2\u0111\u0112\5 \21\r\u0112"+
		"\u0113\b\21\1\2\u0113\u0129\3\2\2\2\u0114\u0115\7\21\2\2\u0115\u0116\5"+
		" \21\f\u0116\u0117\b\21\1\2\u0117\u0129\3\2\2\2\u0118\u0119\7+\2\2\u0119"+
		"\u011a\7\3\2\2\u011a\u011b\5\36\20\2\u011b\u011c\7\4\2\2\u011c\u011d\b"+
		"\21\1\2\u011d\u0129\3\2\2\2\u011e\u011f\t\2\2\2\u011f\u0120\5 \21\b\u0120"+
		"\u0121\b\21\1\2\u0121\u0129\3\2\2\2\u0122\u0123\7-\2\2\u0123\u0129\b\21"+
		"\1\2\u0124\u0125\7.\2\2\u0125\u0129\b\21\1\2\u0126\u0127\7,\2\2\u0127"+
		"\u0129\b\21\1\2\u0128\u0102\3\2\2\2\u0128\u0108\3\2\2\2\u0128\u010a\3"+
		"\2\2\2\u0128\u0110\3\2\2\2\u0128\u0114\3\2\2\2\u0128\u0118\3\2\2\2\u0128"+
		"\u011e\3\2\2\2\u0128\u0122\3\2\2\2\u0128\u0124\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0129\u014a\3\2\2\2\u012a\u012b\f\n\2\2\u012b\u012c\t\3\2\2\u012c"+
		"\u012d\5 \21\13\u012d\u012e\b\21\1\2\u012e\u0149\3\2\2\2\u012f\u0130\f"+
		"\t\2\2\u0130\u0131\t\4\2\2\u0131\u0132\5 \21\n\u0132\u0133\b\21\1\2\u0133"+
		"\u0149\3\2\2\2\u0134\u0135\f\7\2\2\u0135\u0136\t\5\2\2\u0136\u0137\5 "+
		"\21\b\u0137\u0138\b\21\1\2\u0138\u0149\3\2\2\2\u0139\u013a\f\6\2\2\u013a"+
		"\u013b\t\6\2\2\u013b\u013c\5 \21\7\u013c\u013d\b\21\1\2\u013d\u0149\3"+
		"\2\2\2\u013e\u013f\f\20\2\2\u013f\u0140\7\16\2\2\u0140\u0141\5 \21\2\u0141"+
		"\u0142\7\17\2\2\u0142\u0143\b\21\1\2\u0143\u0149\3\2\2\2\u0144\u0145\f"+
		"\17\2\2\u0145\u0146\7\34\2\2\u0146\u0147\7+\2\2\u0147\u0149\b\21\1\2\u0148"+
		"\u012a\3\2\2\2\u0148\u012f\3\2\2\2\u0148\u0134\3\2\2\2\u0148\u0139\3\2"+
		"\2\2\u0148\u013e\3\2\2\2\u0148\u0144\3\2\2\2\u0149\u014c\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b!\3\2\2\2\u014c\u014a\3\2\2\2"+
		"\25,.QTbl~\u0088\u008a\u0095\u0097\u00d2\u00e9\u00f3\u00fd\u0100\u0128"+
		"\u0148\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}