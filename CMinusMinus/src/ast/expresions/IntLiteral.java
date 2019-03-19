package ast.expresions;

import ast.Type;
import ast.types.IntegerType;
import semantic.AstVisitor;

public class IntLiteral extends AbstractExpresion {

	private int value;
	
	public IntLiteral(String value) {
		super();
		Type type = new IntegerType();
		this.value = Integer.parseInt(value);
		setType(type);
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		return String.format("%d", value);
	}

}
