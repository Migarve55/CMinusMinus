package ast.expresions;

import ast.Expresion;
import semantic.AstVisitor;

public class UnaryOperator extends AbstractExpresion {
	
	private String operator;
	private Expresion expresion;
	
	public UnaryOperator(String operator, Expresion expresion) {
		super();
		this.operator = operator;
		this.expresion = expresion;
	}

	public String getOperator() {
		return operator;
	}
	
	public Expresion getExpresion() {
		return expresion;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", operator, expresion);
	}

}
