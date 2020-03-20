package ast.expresions;

import ast.Type;
import ast.types.CharType;
import semantic.AstVisitor;

public class CharLiteral extends AbstractExpresion {

	private char value;
	
	public CharLiteral(String value) {
		super();
		Type type = new CharType();
		this.value = fromLexeme(value);
		setType(type);
	}

	public char getValue() {
		return value;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

	public char fromLexeme(String lexeme) {
		if (lexeme.length() == 3)
			return lexeme.charAt(1);
		//Special chars
		if (lexeme.equals("'\\n'"))
			return '\n';
		if (lexeme.equals("'\\t'"))
			return '\t';
		return getFromNumericChar(lexeme);
	}
	
	private static char getFromNumericChar(String str) {
		String number = str.substring(2,str.length() - 1);
		int n = Integer.parseInt(number);
		return (char) (n % 126);
	}
}
