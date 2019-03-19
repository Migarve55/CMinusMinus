package ast.statements;

import java.util.Collections;
import java.util.List;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class If extends ASTNodeImpl implements Statment {

	private Expresion condition;
	private List<Statment> ifBody;
	private List<Statment> elseBody;
	
	public If(Expresion condition, List<Statment> ifBody) {
		super();
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = Collections.<Statment>emptyList();
	}
	
	public If(Expresion condition, List<Statment> ifBody, List<Statment> elseBody) {
		this(condition, ifBody);
		this.elseBody = elseBody;
	}

	public Expresion getCondition() {
		return condition;
	}

	public List<Statment> getIfBody() {
		return ifBody;
	}

	public List<Statment> getElseBody() {
		return elseBody;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
