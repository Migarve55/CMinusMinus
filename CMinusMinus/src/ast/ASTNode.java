package ast;

import semantic.AstVisitor;

public interface ASTNode {

	public int getLine();
	public int getColumn();
	
	public void setLine(int line);
	public void setColumn(int column);
	
	//For the visitor
	public <TP,TR> TR accept(AstVisitor<TP, TR> visitor, TP param);
	
}
