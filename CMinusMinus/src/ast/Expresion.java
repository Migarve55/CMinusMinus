package ast;

public interface Expresion extends ASTNode {
	
	public Type getType();
	public void setType(Type type);
	
	public boolean getLValue();
	public void setLValue(boolean lvalue);
	
	public boolean isAddresable();
	public void setAddresable(boolean addresable);
	
}