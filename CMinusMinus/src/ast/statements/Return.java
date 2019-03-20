package ast.statements;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import ast.definitions.FunctionDefinition;
import semantic.AstVisitor;

public class Return extends ASTNodeImpl implements Statment {

	private Expresion returns;
	
	private FunctionDefinition function;
	
	public Return() {
		super();
	}
	
	public Return(Expresion returns) {
		super();
		this.returns = returns;
	}

	public Expresion getReturns() {
		return returns;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public FunctionDefinition getFunction() {
		return function;
	}

	public void setFunction(FunctionDefinition function) {
		this.function = function;
	}

}
