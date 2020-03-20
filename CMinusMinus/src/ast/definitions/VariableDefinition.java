package ast.definitions;

import ast.Type;
import semantic.AstVisitor;

public class VariableDefinition extends AbstractDefinition {
	
	public VariableDefinition(Type type, String name) {
		super(type, name);
	}

	@Override
	public String toString() {
		return getType() + " " + getName();
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
