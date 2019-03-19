package ast.types;

import semantic.AstVisitor;

public class VoidType extends AbstractType {

	public VoidType() {
		super();
	}

	@Override
	public String toString() {
		return "void";
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public int getBytesSize() {
		return 0;
	}

	@Override
	public String getMAPLSuffix() {
		return null;
	}

}
