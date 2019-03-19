package ast.expresions;

import ast.Definition;
import ast.Expresion;
import semantic.AstVisitor;

public class StructAccess extends AbstractExpresion {

	private Expresion expr;
	private String field;
	
	private Definition definition;
	
	public StructAccess(Expresion expr, String field) {
		super();
		this.expr = expr;
		this.field = field;
	}

	public Expresion getExpresion() {
		return expr;
	}

	public String getField() {
		return field;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

}
