package ast.definitions;

import ast.ASTNodeImpl;
import ast.Definition;
import ast.Type;

public abstract class AbstractDefinition extends ASTNodeImpl implements Definition {

	private Type type;
	private String name;
	
	private int scope;
	private int offset;
	
	public AbstractDefinition(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
