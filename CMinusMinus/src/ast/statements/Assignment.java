package ast.statements;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class Assignment extends ASTNodeImpl implements Statment {

	private Expresion left;
	private Expresion right;
	
	public Assignment(Expresion left, Expresion right) {
		super();
		this.left = left;
		this.right = right;
	}

	public Expresion getLeft() {
		return left;
	}

	public Expresion getRight() {
		return right;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
