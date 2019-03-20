package ast.statements;

import java.util.List;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class While extends ASTNodeImpl implements Statment, LoopStatment {

	private Expresion condition;
	private List<Statment> body;
	
	private int labelId;
	
	public While(Expresion condition, List<Statment> body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	public Expresion getCondition() {
		return condition;
	}

	public List<Statment> getBody() {
		return body;
	}
	
	@Override
	public void setLabelId(int id) {
		this.labelId = id;
	}

	@Override
	public int getLabelId() {
		return labelId;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
	
}
