package ast.expresions;

import ast.Expresion;
import semantic.AstVisitor;

public class ArrayAccess extends AbstractExpresion {

	private Expresion expresion;
	private Expresion index;
	
	public ArrayAccess(Expresion expresion, Expresion index) {
		super();
		this.expresion = expresion;
		this.index = index;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	public Expresion getIndex() {
		return index;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
