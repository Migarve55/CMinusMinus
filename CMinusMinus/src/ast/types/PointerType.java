package ast.types;

import ast.Type;
import semantic.AstVisitor;

public class PointerType extends AbstractType {

	private Type type;
	
	public PointerType(Type type) {
		super();
		this.type = type;
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
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public Type getPointerType() {
		return type;
	}
	
	@Override
	public Type equivalent(Type type) {
		if (this.getClass().equals(type.getClass()))
			return this;
		return super.equivalent(type);
	}
	
	@Override
	public Type assing(Type type) {
		if (type instanceof ErrorType)
			return type;
		if (this.getClass().equals(type.getClass())) {
			PointerType pType = (PointerType) type;
			if (pType.getPointerType().getClass().equals(getPointerType().getClass()))
				return null;
			else
				return new ErrorType(parent, String.format("%s can not be assigned to %s", pType.getPointerType(), this.type));
		}
		return new ErrorType(parent, String.format("%s can not be assigned to %s", type, this));
	}
	
	@Override
	public Type address() {
		return new PointerType(this);
	}

	@Override
	public Type asterisk() {
		return type;
	}

	@Override
	public String toString() {
		return "address";
	}

}
