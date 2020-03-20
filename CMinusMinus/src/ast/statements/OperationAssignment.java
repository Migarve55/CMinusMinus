package ast.statements;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class OperationAssignment extends ASTNodeImpl implements Statment {

	private Expresion left;
	private Expresion right;
	
	private String op;
	
	public OperationAssignment(Expresion left, String op, Expresion right) {
		super();
		this.left = left;
		this.op = op;
		this.right = right;
	}

	public Expresion getLeft() {
		return left;
	}

	public Expresion getRight() {
		return right;
	}
	
	public String getOp() {
		return op;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
