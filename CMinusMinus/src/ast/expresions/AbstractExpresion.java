package ast.expresions;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Type;

public abstract class AbstractExpresion extends ASTNodeImpl implements Expresion {

	private Type type;
	private boolean lvalue;
	private boolean addresable;

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
		type.setParent(this);
	}

	@Override
	public boolean getLValue() {
		return lvalue;
	}

	@Override
	public void setLValue(boolean lvalue) {
		this.lvalue = lvalue;
	}

	public boolean isAddresable() {
		return addresable;
	}

	public void setAddresable(boolean addresable) {
		this.addresable = addresable;
	}

}
