package ast;

public interface Definition extends ASTNode {

	public Type getType();
	public String getName();
	
	public void setScope(int scope);
	public int getScope();
	
	public void setOffset(int scope);
	public int getOffset();
	
}
