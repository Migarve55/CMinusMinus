package ast;

import java.util.List;

public interface Type extends ASTNode {
	
	//Errors
	
	public void setParent(ASTNode parent);

	//For type checking
	
	public Type arithmetic(Type type);
	public Type booleanOp(Type type);
	public Type squareBrakets(Type type);
	public Type cast(Type type);
	public Type parenthesis(List<Type> type, ASTNode calledFrom);
	public Type equivalent(Type type);
	public Type assing(Type type);
	public Type dot(String field);
	public Type read();
	public Type condition();
	public Type not();
	public Type negation();
	//For pointers
	public Type address();
	public Type asterisk();
	
	//Code generation
	
	public int getBytesSize();
	public String getMAPLSuffix();

	
	
}
