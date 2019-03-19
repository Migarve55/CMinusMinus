package ast.statements;

import java.util.List;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class For extends ASTNodeImpl implements Statment {

	private Statment vars;
	private Expresion condition;
	private Statment increment;

	private List<Statment> body;

	public For(Statment vars, Expresion condition, Statment increment, List<Statment> body) {
		super();
		this.vars = vars;
		this.condition = condition;
		this.increment = increment;
		this.body = body;
	}

	public Statment getVars() {
		return vars;
	}

	public Expresion getCondition() {
		return condition;
	}

	public Statment getIncrement() {
		return increment;
	}

	public List<Statment> getBody() {
		return body;
	}

	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
