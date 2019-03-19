package ast.expresions;

import ast.Definition;
import semantic.AstVisitor;

public class Ident extends AbstractExpresion {
	
	private String name;
	
	private Definition definition;

	public Ident(String name) {
		super();
		this.name = name;
	}
	
	public Ident(String name, int line, int column) {
		this(name);
		setLine(line);
		setColumn(column);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
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
