package ast.expresions;

import ast.Expresion;
import ast.Type;
import semantic.AstVisitor;

public class Cast extends AbstractExpresion {

	private Type type;
	private Expresion expresion;
	
	public Cast(Type type, Expresion expresion) {
		super();
		this.type = type;
		this.expresion = expresion;
	}

	public Type getCastType() {
		return type;
	}

	public Expresion getExpresion() {
		return expresion;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
	
}
