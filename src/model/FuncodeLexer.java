package model;

// Generated from Funcode.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FuncodeLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, INICIO=4, FUN=5, ELEMENTOS=6, ANIMACION=7, MOVER=8, 
		TP=9, ESPERAR=10, OCULTAR=11, MOSTRAR=12, POSICION=13, DIRECCION=14, PASOS=15, 
		DURANTE=16, INSERTAR=17, TIEMPO=18, SEG=19, NEWLINE=20, HACIA=21, SIMBOLO=22, 
		NUMERO=23, NOMBRE=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "':'", "';'", "'inicio'", "'FUN'", "'elementos'", "'animacion'", 
		"'mover'", "'tp'", "'esperar'", "'ocultar'", "'mostrar'", "'posicion'", 
		"'direccion'", "'pasos'", "'durante'", "'insertar'", "'tiempo'", "'segundos'", 
		"NEWLINE", "HACIA", "SIMBOLO", "NUMERO", "NOMBRE"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "INICIO", "FUN", "ELEMENTOS", "ANIMACION", "MOVER", 
		"TP", "ESPERAR", "OCULTAR", "MOSTRAR", "POSICION", "DIRECCION", "PASOS", 
		"DURANTE", "INSERTAR", "TIEMPO", "SEG", "NEWLINE", "HACIA", "SIMBOLO", 
		"NUMERO", "NOMBRE"
	};


	public FuncodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Funcode.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u00b5\n\25\r\25\16\25\u00b6\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u00d6\n\26\3\27\3\27\3\30\6\30\u00db\n\30\r\30\16\30\u00dc\3\31\6"+
		"\31\u00e0\n\31\r\31\16\31\u00e1\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\3\2\6\5\2\13\f\16\17\"\"\4\2--//\3\2\62;\5\2\62;C\\c|\u00e8"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13@"+
		"\3\2\2\2\rD\3\2\2\2\17N\3\2\2\2\21X\3\2\2\2\23^\3\2\2\2\25a\3\2\2\2\27"+
		"i\3\2\2\2\31q\3\2\2\2\33y\3\2\2\2\35\u0082\3\2\2\2\37\u008c\3\2\2\2!\u0092"+
		"\3\2\2\2#\u009a\3\2\2\2%\u00a3\3\2\2\2\'\u00aa\3\2\2\2)\u00b4\3\2\2\2"+
		"+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00da\3\2\2\2\61\u00df\3\2\2\2\63\64\7"+
		".\2\2\64\4\3\2\2\2\65\66\7<\2\2\66\6\3\2\2\2\678\7=\2\28\b\3\2\2\29:\7"+
		"k\2\2:;\7p\2\2;<\7k\2\2<=\7e\2\2=>\7k\2\2>?\7q\2\2?\n\3\2\2\2@A\7H\2\2"+
		"AB\7W\2\2BC\7P\2\2C\f\3\2\2\2DE\7g\2\2EF\7n\2\2FG\7g\2\2GH\7o\2\2HI\7"+
		"g\2\2IJ\7p\2\2JK\7v\2\2KL\7q\2\2LM\7u\2\2M\16\3\2\2\2NO\7c\2\2OP\7p\2"+
		"\2PQ\7k\2\2QR\7o\2\2RS\7c\2\2ST\7e\2\2TU\7k\2\2UV\7q\2\2VW\7p\2\2W\20"+
		"\3\2\2\2XY\7o\2\2YZ\7q\2\2Z[\7x\2\2[\\\7g\2\2\\]\7t\2\2]\22\3\2\2\2^_"+
		"\7v\2\2_`\7r\2\2`\24\3\2\2\2ab\7g\2\2bc\7u\2\2cd\7r\2\2de\7g\2\2ef\7t"+
		"\2\2fg\7c\2\2gh\7t\2\2h\26\3\2\2\2ij\7q\2\2jk\7e\2\2kl\7w\2\2lm\7n\2\2"+
		"mn\7v\2\2no\7c\2\2op\7t\2\2p\30\3\2\2\2qr\7o\2\2rs\7q\2\2st\7u\2\2tu\7"+
		"v\2\2uv\7t\2\2vw\7c\2\2wx\7t\2\2x\32\3\2\2\2yz\7r\2\2z{\7q\2\2{|\7u\2"+
		"\2|}\7k\2\2}~\7e\2\2~\177\7k\2\2\177\u0080\7q\2\2\u0080\u0081\7p\2\2\u0081"+
		"\34\3\2\2\2\u0082\u0083\7f\2\2\u0083\u0084\7k\2\2\u0084\u0085\7t\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0087\7e\2\2\u0087\u0088\7e\2\2\u0088\u0089\7k\2\2"+
		"\u0089\u008a\7q\2\2\u008a\u008b\7p\2\2\u008b\36\3\2\2\2\u008c\u008d\7"+
		"r\2\2\u008d\u008e\7c\2\2\u008e\u008f\7u\2\2\u008f\u0090\7q\2\2\u0090\u0091"+
		"\7u\2\2\u0091 \3\2\2\2\u0092\u0093\7f\2\2\u0093\u0094\7w\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7c\2\2\u0096\u0097\7p\2\2\u0097\u0098\7v\2\2\u0098"+
		"\u0099\7g\2\2\u0099\"\3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c"+
		"\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\u00a1\7c\2\2\u00a1\u00a2\7t\2\2\u00a2$\3\2\2\2\u00a3\u00a4\7v\2"+
		"\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7o\2\2\u00a7\u00a8"+
		"\7r\2\2\u00a8\u00a9\7q\2\2\u00a9&\3\2\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac"+
		"\7g\2\2\u00ac\u00ad\7i\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7p\2\2\u00af"+
		"\u00b0\7f\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7u\2\2\u00b2(\3\2\2\2\u00b3"+
		"\u00b5\t\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\25\2\2\u00b9"+
		"*\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7|\2\2\u00bc\u00bd\7s\2\2\u00bd"+
		"\u00be\7w\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7t\2\2"+
		"\u00c1\u00c2\7f\2\2\u00c2\u00d6\7c\2\2\u00c3\u00c4\7f\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7e\2\2\u00c8"+
		"\u00c9\7j\2\2\u00c9\u00d6\7c\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7t\2\2"+
		"\u00cc\u00cd\7t\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7d\2\2\u00cf\u00d6"+
		"\7c\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7d\2\2\u00d2\u00d3\7c\2\2\u00d3"+
		"\u00d4\7l\2\2\u00d4\u00d6\7q\2\2\u00d5\u00ba\3\2\2\2\u00d5\u00c3\3\2\2"+
		"\2\u00d5\u00ca\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d6,\3\2\2\2\u00d7\u00d8"+
		"\t\3\2\2\u00d8.\3\2\2\2\u00d9\u00db\t\4\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\60\3\2\2"+
		"\2\u00de\u00e0\t\5\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\62\3\2\2\2\7\2\u00b6\u00d5\u00dc\u00e1"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}