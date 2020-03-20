package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.Type;
import semantic.AstVisitor;
import semantic.ErrorHandler;

public class ErrorType extends AbstractType {

	private String message;
	
	public ErrorType(int line, int column, String message) {
		setLine(line);
		setColumn(column);
		this.message = message;	
		ErrorHandler.getInstance().addError(this);
	}
	
	public ErrorType(ASTNode node, String message) {
		this(node.getLine(), node.getColumn(), message);
	}
	
	@Override
	public String toString() {
		return String.format("Error at %d:%d: %s", getLine(), getColumn(), message);
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

	@Override
	public int getBytesSize() {
		return 0;
	}
	
	@Override
	public String getMAPLSuffix() {
		return null;
	}

	@Override
	public Type arithmetic(Type type) {
		return this;
	}
	
	@Override
	public Type booleanOp(Type type) {
		return this;
	}

	@Override
	public Type squareBrakets(Type type) {
		return this;
	}

	@Override
	public Type cast(Type type) {
		return this;
	}

	@Override
	public Type parenthesis(List<Type> type, ASTNode calledFrom) {
		return this;
	}

	@Override
	public Type equivalent(Type type) {
		return this;
	}

	@Override
	public Type dot(String field) {
		return this;
	}

	@Override
	public Type read() {
		return this;
	}

	@Override
	public Type condition() {
		return this;
	}

	@Override
	public Type not() {
		return this;
	}

	@Override
	public Type negation() {
		return this;
	}

}
