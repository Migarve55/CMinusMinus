package ast.expresions;

import ast.Expresion;
import semantic.AstVisitor;

public class Address extends AbstractExpresion {

	private Expresion expresion;

	public Address(Expresion expresion) {
		super();
		this.expresion = expresion;
	}

	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public Expresion getExpresion() {
		return expresion;
	}

}
