package ast.statements;

import ast.ASTNodeImpl;
import ast.Statment;
import semantic.AstVisitor;

public class Continue extends ASTNodeImpl implements Statment {

	private LoopStatment parentLoop;
	
	public Continue() {
		super();
	}

	public LoopStatment getParentLoop() {
		return parentLoop;
	}

	public void setParentLoop(LoopStatment parentLoop) {
		this.parentLoop = parentLoop;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
