package ast.types;

import ast.Type;
import semantic.AstVisitor;

public class IntegerType extends AbstractType {

	public IntegerType() {
		super();
	}
	
	@Override
	public String toString() {
		return "int";
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

	@Override
	public int getBytesSize() {
		return 2;
	}
	
	@Override
	public String getMAPLSuffix() {
		return "i";
	}

	@Override
	public Type arithmetic(Type type) {
		return type;
	}
	
	@Override
	public Type booleanOp(Type type) {
		return type;
	}

	@Override
	public Type cast(Type type) {
		if (type instanceof CharType)
			return type;
		if (type instanceof DoubleType)
			return type;
		return super.cast(type);
	}

	@Override
	public Type equivalent(Type type) {
		if (this.equals(type))
			return this;
		return super.equivalent(type);
	}
	
	@Override
	public Type assing(Type type) {
		if (this.equals(type))
			return null;
		return super.assing(type);
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

	@Override
	public Type address() {
		return new PointerType(this);
	}

}
