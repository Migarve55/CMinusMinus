package ast.statements;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class Read extends ASTNodeImpl implements Statment {

	private Expresion expresion;
	
	public Read(Expresion returns) {
		super();
		this.expresion = returns;
	}

	public Expresion getExpresion() {
		return expresion;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
