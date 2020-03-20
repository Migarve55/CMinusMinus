package ast.expresions;

import ast.Expresion;
import semantic.AstVisitor;

public class BinaryOperator extends AbstractExpresion {

	private String operator;
	private Expresion left;
	private Expresion right;

	public BinaryOperator(Expresion left, String operator, Expresion right) {
		super();
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	public String getOperator() {
		return operator;
	}

	public Expresion getLeft() {
		return left;
	}

	public Expresion getRight() {
		return right;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
