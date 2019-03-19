package ast.expresions;

import ast.Type;
import ast.types.DoubleType;
import semantic.AstVisitor;

public class DoubleLiteral extends AbstractExpresion {

	private double value;
	
	public DoubleLiteral(String value) {
		super();
		Type type = new DoubleType();
		this.value = Double.parseDouble(value);
		setType(type);
	}

	public double getValue() {
		return value;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

}
