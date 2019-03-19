package ast.expresions;

import java.util.List;

import ast.Expresion;
import ast.definitions.FunctionDefinition;
import semantic.AstVisitor;

public class Call extends AbstractExpresion {

	private String name;
	private List<Expresion> arguments;
	
	private FunctionDefinition definition;
	
	public Call(String name, List<Expresion> arguments) {
		super();
		this.name = name;
		this.arguments = arguments;
	}

	public String getName() {
		return name;
	}

	public List<Expresion> getArguments() {
		return arguments;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}

	public FunctionDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(FunctionDefinition definition) {
		this.definition = definition;
	}

}
