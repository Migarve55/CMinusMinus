// Generated from src/parser/Cmm.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
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
		ID=39, CHAR_CONSTANT=40, INT_CONSTANT=41, REAL_CONSTANT=42, LINE_COMMENT=43, 
		MULTI_LINE_COMMENT=44, WHITE_SPACES=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "ID", "CHAR_CONSTANT", "INT_CONSTANT", 
		"REAL_CONSTANT", "LINE_COMMENT", "MULTI_LINE_COMMENT", "WHITE_SPACES", 
		"DIGIT", "FLOAT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "'void'", "'main'", "','", "';'", "'int'", 
		"'double'", "'char'", "'['", "']'", "'struct'", "'*'", "'while'", "'return'", 
		"'write'", "'read'", "'for'", "'='", "'if'", "'else'", "'.'", "'&'", "'/'", 
		"'%'", "'+'", "'-'", "'!'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
		"'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ID", "CHAR_CONSTANT", "INT_CONSTANT", "REAL_CONSTANT", 
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0148\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3\'\3(\6(\u00e0\n(\r(\16(\u00e1\3(\7(\u00e5\n(\f"+
		"(\16(\u00e8\13(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u00f2\n)\3)\3)\3*\3*\6*\u00f8"+
		"\n*\r*\16*\u00f9\3*\7*\u00fd\n*\f*\16*\u0100\13*\5*\u0102\n*\3+\3+\3+"+
		"\3+\5+\u0108\n+\3+\3+\3+\3+\3+\5+\u010f\n+\3+\3+\5+\u0113\n+\3,\3,\3,"+
		"\3,\7,\u0119\n,\f,\16,\u011c\13,\3,\5,\u011f\n,\3,\5,\u0122\n,\3,\3,\3"+
		"-\3-\3-\3-\7-\u012a\n-\f-\16-\u012d\13-\3-\3-\3-\3-\3-\3.\6.\u0135\n."+
		"\r.\16.\u0136\3.\3.\3/\3/\3\60\5\60\u013e\n\60\3\60\3\60\3\60\3\60\3\60"+
		"\5\60\u0145\n\60\5\60\u0147\n\60\4\u011a\u012b\2\61\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\2_\2\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\4\2GGg"+
		"g\3\3\f\f\5\2\13\f\17\17\"\"\3\2\62;\2\u0158\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3\2\2\2\tg\3\2\2\2\13i\3\2"+
		"\2\2\rn\3\2\2\2\17s\3\2\2\2\21u\3\2\2\2\23w\3\2\2\2\25{\3\2\2\2\27\u0082"+
		"\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2\2\37\u0092\3"+
		"\2\2\2!\u0094\3\2\2\2#\u009a\3\2\2\2%\u00a1\3\2\2\2\'\u00a7\3\2\2\2)\u00ac"+
		"\3\2\2\2+\u00b0\3\2\2\2-\u00b2\3\2\2\2/\u00b5\3\2\2\2\61\u00ba\3\2\2\2"+
		"\63\u00bc\3\2\2\2\65\u00be\3\2\2\2\67\u00c0\3\2\2\29\u00c2\3\2\2\2;\u00c4"+
		"\3\2\2\2=\u00c6\3\2\2\2?\u00c8\3\2\2\2A\u00cb\3\2\2\2C\u00ce\3\2\2\2E"+
		"\u00d1\3\2\2\2G\u00d4\3\2\2\2I\u00d6\3\2\2\2K\u00d8\3\2\2\2M\u00db\3\2"+
		"\2\2O\u00df\3\2\2\2Q\u00e9\3\2\2\2S\u0101\3\2\2\2U\u0112\3\2\2\2W\u0114"+
		"\3\2\2\2Y\u0125\3\2\2\2[\u0134\3\2\2\2]\u013a\3\2\2\2_\u0146\3\2\2\2a"+
		"b\7*\2\2b\4\3\2\2\2cd\7+\2\2d\6\3\2\2\2ef\7}\2\2f\b\3\2\2\2gh\7\177\2"+
		"\2h\n\3\2\2\2ij\7x\2\2jk\7q\2\2kl\7k\2\2lm\7f\2\2m\f\3\2\2\2no\7o\2\2"+
		"op\7c\2\2pq\7k\2\2qr\7p\2\2r\16\3\2\2\2st\7.\2\2t\20\3\2\2\2uv\7=\2\2"+
		"v\22\3\2\2\2wx\7k\2\2xy\7p\2\2yz\7v\2\2z\24\3\2\2\2{|\7f\2\2|}\7q\2\2"+
		"}~\7w\2\2~\177\7d\2\2\177\u0080\7n\2\2\u0080\u0081\7g\2\2\u0081\26\3\2"+
		"\2\2\u0082\u0083\7e\2\2\u0083\u0084\7j\2\2\u0084\u0085\7c\2\2\u0085\u0086"+
		"\7t\2\2\u0086\30\3\2\2\2\u0087\u0088\7]\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7_\2\2\u008a\34\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d\u008e"+
		"\7t\2\2\u008e\u008f\7w\2\2\u008f\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091"+
		"\36\3\2\2\2\u0092\u0093\7,\2\2\u0093 \3\2\2\2\u0094\u0095\7y\2\2\u0095"+
		"\u0096\7j\2\2\u0096\u0097\7k\2\2\u0097\u0098\7n\2\2\u0098\u0099\7g\2\2"+
		"\u0099\"\3\2\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c\u009d\7v"+
		"\2\2\u009d\u009e\7w\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7p\2\2\u00a0$\3"+
		"\2\2\2\u00a1\u00a2\7y\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7k\2\2\u00a4"+
		"\u00a5\7v\2\2\u00a5\u00a6\7g\2\2\u00a6&\3\2\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7f\2\2\u00ab(\3\2\2\2\u00ac"+
		"\u00ad\7h\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7t\2\2\u00af*\3\2\2\2\u00b0"+
		"\u00b1\7?\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7h\2\2\u00b4"+
		".\3\2\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7u\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\60\3\2\2\2\u00ba\u00bb\7\60\2\2\u00bb\62\3\2\2\2\u00bc"+
		"\u00bd\7(\2\2\u00bd\64\3\2\2\2\u00be\u00bf\7\61\2\2\u00bf\66\3\2\2\2\u00c0"+
		"\u00c1\7\'\2\2\u00c18\3\2\2\2\u00c2\u00c3\7-\2\2\u00c3:\3\2\2\2\u00c4"+
		"\u00c5\7/\2\2\u00c5<\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7>\3\2\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9\u00ca\7?\2\2\u00ca@\3\2\2\2\u00cb\u00cc\7#\2\2\u00cc\u00cd"+
		"\7?\2\2\u00cdB\3\2\2\2\u00ce\u00cf\7>\2\2\u00cf\u00d0\7?\2\2\u00d0D\3"+
		"\2\2\2\u00d1\u00d2\7@\2\2\u00d2\u00d3\7?\2\2\u00d3F\3\2\2\2\u00d4\u00d5"+
		"\7>\2\2\u00d5H\3\2\2\2\u00d6\u00d7\7@\2\2\u00d7J\3\2\2\2\u00d8\u00d9\7"+
		"(\2\2\u00d9\u00da\7(\2\2\u00daL\3\2\2\2\u00db\u00dc\7~\2\2\u00dc\u00dd"+
		"\7~\2\2\u00ddN\3\2\2\2\u00de\u00e0\t\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\3\2\2\2\u00e3"+
		"\u00e5\t\3\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7P\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00f1"+
		"\7)\2\2\u00ea\u00f2\13\2\2\2\u00eb\u00ec\7^\2\2\u00ec\u00f2\7v\2\2\u00ed"+
		"\u00ee\7^\2\2\u00ee\u00f2\7p\2\2\u00ef\u00f0\7^\2\2\u00f0\u00f2\5S*\2"+
		"\u00f1\u00ea\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7)\2\2\u00f4R\3\2\2\2\u00f5\u0102"+
		"\7\62\2\2\u00f6\u00f8\t\4\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2"+
		"\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fe\3\2\2\2\u00fb\u00fd"+
		"\5]/\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u00f5\3\2"+
		"\2\2\u0101\u00f7\3\2\2\2\u0102T\3\2\2\2\u0103\u0113\5_\60\2\u0104\u0105"+
		"\5_\60\2\u0105\u0107\t\5\2\2\u0106\u0108\7/\2\2\u0107\u0106\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\5S*\2\u010a\u0113\3\2\2"+
		"\2\u010b\u010c\5S*\2\u010c\u010e\t\5\2\2\u010d\u010f\7/\2\2\u010e\u010d"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\5S*\2\u0111"+
		"\u0113\3\2\2\2\u0112\u0103\3\2\2\2\u0112\u0104\3\2\2\2\u0112\u010b\3\2"+
		"\2\2\u0113V\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116\7\61\2\2\u0116\u011a"+
		"\3\2\2\2\u0117\u0119\13\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2"+
		"\u011a\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011d\u011f\7\17\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2"+
		"\u011f\u0121\3\2\2\2\u0120\u0122\t\6\2\2\u0121\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0124\b,\2\2\u0124X\3\2\2\2\u0125\u0126\7\61\2\2\u0126"+
		"\u0127\7,\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2"+
		"\2\2\u012a\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7,\2\2\u012f\u0130\7\61"+
		"\2\2\u0130\u0131\3\2\2\2\u0131\u0132\b-\2\2\u0132Z\3\2\2\2\u0133\u0135"+
		"\t\7\2\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\b.\2\2\u0139\\\3\2\2\2"+
		"\u013a\u013b\t\b\2\2\u013b^\3\2\2\2\u013c\u013e\5S*\2\u013d\u013c\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7\60\2\2\u0140"+
		"\u0147\5S*\2\u0141\u0142\5S*\2\u0142\u0144\7\60\2\2\u0143\u0145\5S*\2"+
		"\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u013d"+
		"\3\2\2\2\u0146\u0141\3\2\2\2\u0147`\3\2\2\2\24\2\u00e1\u00e6\u00f1\u00f9"+
		"\u00fe\u0101\u0107\u010e\u0112\u011a\u011e\u0121\u012b\u0136\u013d\u0144"+
		"\u0146\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}