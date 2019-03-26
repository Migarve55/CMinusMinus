package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.ASTNodeImpl;
import ast.Type;
import semantic.AstVisitor;

public abstract class AbstractType extends ASTNodeImpl implements Type {
	
	protected ASTNode parent;
	
	public void setParent(ASTNode parent) {
		this.parent = parent;
	}

	@Override
	public Type arithmetic(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, String.format("can not operate %s with %s", this, type));
	}
	
	@Override
	public Type booleanOp(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, String.format("can not operate %s with %s", this, type));
	}

	@Override
	public Type squareBrakets(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, this + " is not an array");
	}

	@Override
	public Type cast(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, String.format("can not cast %s into %s", this, type));
	}

	@Override
	public Type parenthesis(List<Type> types, ASTNode calledFrom) {
		for (Type type : types)
			if (type instanceof ErrorType)
				return type;
		return new ErrorType(calledFrom, "Can not invoke " + this + ", it is not a function");
	}

	@Override
	public Type equivalent(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, String.format("%s and %s are not equal", type, this));
	}
	
	@Override
	public Type assing(Type type) {
		if (type instanceof ErrorType)
			return type;
		return new ErrorType(parent, String.format("%s can not be assigned to %s", type, this));
	}

	@Override
	public Type dot(String field) {
		return new ErrorType(parent, this + " is not a struct");
	}

	@Override
	public Type read() {
		return new ErrorType(parent, this + " can not be read from the input");
	}

	@Override
	public Type condition() {
		return new ErrorType(parent, this + " is not a valid conditional");
	}

	@Override
	public Type not() {
		return new ErrorType(parent, this + " does not operate with '!'");
	}

	@Override
	public Type negation() {
		return new ErrorType(parent, this + " does not operate with '-'");
	}

	@Override
	public Type address() {
		return new ErrorType(parent, this + " does not operate with '&'");
	}

	@Override
	public Type asterisk() {
		return new ErrorType(parent, this + " is not a pointer");
	}

	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBytesSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMAPLSuffix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass());
	}

}
