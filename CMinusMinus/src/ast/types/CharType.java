package ast.types;

import ast.Type;
import semantic.AstVisitor;

public class CharType extends AbstractType {

	public CharType() {
		super();
	}
	
	@Override
	public String toString() {
		return "char";
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

	@Override
	public int getBytesSize() {
		return 1;
	}
	
	@Override
	public String getMAPLSuffix() {
		return "b";
	}
	
	@Override
	public Type assing(Type type) {
		if (this.equals(type))
			return null;
		return super.assing(type);
	}

	@Override
	public Type cast(Type type) {
		if (type instanceof IntegerType)
			return type;
		return super.cast(type);
	}
	
	@Override
	public Type arithmetic(Type type) {
		if (type instanceof CharType)
			return new IntegerType();
		return super.arithmetic(type);
	}

	@Override
	public Type address() {
		return new PointerType(this);
	}
	
	@Override
	public Type read() {
		return this;
	}

}
