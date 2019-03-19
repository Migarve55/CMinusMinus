package ast.statements;

import ast.ASTNodeImpl;
import ast.Statment;
import ast.Type;
import ast.definitions.VariableDefinition;
import semantic.AstVisitor;

public class VariableDeclaration extends ASTNodeImpl implements Statment {

	private Type type;
	private String name;
	
	private VariableDefinition varDef;
	
	public VariableDeclaration( Type type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public Type getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public VariableDefinition getVarDef() {
		return varDef;
	}

	public void setVarDef(VariableDefinition varDef) {
		this.varDef = varDef;
	}

}
