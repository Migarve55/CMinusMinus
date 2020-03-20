package ast.types;

import ast.Type;
import semantic.AstVisitor;

public class ArrayType extends AbstractType {

	private Type type;
	private int size;
	
	public ArrayType(Type type, int size) {
		super();
		this.type = type;
		this.size = size;
	}

	public Type getType() {
		return type;
	}
	
	public Type getArrayType() {
		if (type instanceof ArrayType)
			return ((ArrayType) type).getArrayType();
		return type;
	}
	
	@Override
	public int getBytesSize() {
		return type.getBytesSize() * size;
	}

	public int getArraySize() {
		return size;
	}
	
	@Override
	public String toString() {
		return String.format("%d*%s", size, type);
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}
	
	@Override
	public String getMAPLSuffix() {
		return "i";
	}

	@Override
	public Type squareBrakets(Type type) {
		return this.type;
	}
	
	@Override
	public Type address() {
		return new PointerType(this);
	}

}
