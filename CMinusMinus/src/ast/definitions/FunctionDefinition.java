package ast.definitions;

import java.util.List;

import ast.Statment;
import ast.Type;
import semantic.AstVisitor;

public class FunctionDefinition extends AbstractDefinition {
	
	private List<Statment> body;
	
	private boolean needsReturn;
	
	public FunctionDefinition(String name, Type type, List<Statment> body) {
		super(type, name);
		this.body = body;
	}

	public List<Statment> getBody() {
		return body;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public boolean needsReturn() {
		return needsReturn;
	}

	public void setNeedsReturn(boolean needsReturn) {
		this.needsReturn = needsReturn;
	}

}
