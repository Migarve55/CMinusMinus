package ast.statements;

import java.util.List;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import ast.definitions.FunctionDefinition;
import semantic.AstVisitor;

public class Invocation extends ASTNodeImpl implements Statment {

	private String name;
	private List<Expresion> arguments;
	
	private FunctionDefinition definition;
	
	public Invocation(String name, List<Expresion> arguments) {
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
		return visitor.denunciaDelPrincipado(this, param);
	}

	public FunctionDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(FunctionDefinition definition) {
		this.definition = definition;
	}

}
