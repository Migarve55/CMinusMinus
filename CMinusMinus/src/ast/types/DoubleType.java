package ast.types;

import ast.Type;
import semantic.AstVisitor;

public class DoubleType extends AbstractType {

	public DoubleType() {
		super();
	}
	
	@Override
	public String toString() {
		return "real";
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public int getBytesSize() {
		return 4;
	}
	
	@Override
	public String getMAPLSuffix() {
		return "f";
	}
	
	@Override
	public Type arithmetic(Type type) {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Type cast(Type type) {
		if (type instanceof IntegerType)
			return type;
		return super.cast(type);
	}

	@Override
	public Type equivalent(Type type) {
		if (this.getClass().equals(type.getClass()))
			return new IntegerType();
		return super.equivalent(type);
	}
	
	@Override
	public Type assing(Type type) {
		if (this.getClass().equals(type.getClass()))
			return null;
		return super.assing(type);
	}
	
	@Override
	public Type read() {
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
