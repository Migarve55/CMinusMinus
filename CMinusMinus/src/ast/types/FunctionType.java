package ast.types;

import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Type;
import ast.statements.VariableDeclaration;
import semantic.AstVisitor;

public class FunctionType extends AbstractType {
	
	private Type returnType;
	private List<VariableDeclaration> parameters;
	
	private int localVarsSize;
	
	public FunctionType(Type returnType) {
		super();
		this.returnType = returnType;
		this.parameters = Collections.<VariableDeclaration>emptyList();
	}
	
	public FunctionType(Type returnType, List<VariableDeclaration> args) {
		this(returnType);
		this.parameters = args;
	}
	
	public Type getReturnType() {
		return returnType;
	}
	
	public List<VariableDeclaration> getParameters() {
		return parameters;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public String toString() {
		return String.format("f(%s) : %s", parameters, returnType);
	}

	@Override
	public int getBytesSize() {
		return getReturnSize() + getLocalVarsSize() + getParametersSize();
	}
	
	@Override
	public String getMAPLSuffix() {
		return null;
	}
	
	public int getReturnSize() {
		return returnType.getBytesSize();
	}
	
	public int getLocalVarsSize() {
		return localVarsSize;
	}
	
	public void setLocalVarsSize(int size) {
		localVarsSize = size;
	}
	
	public int getParametersSize() {
		return parameters.stream()
				.map(param -> param.getType().getBytesSize())
				.mapToInt(Integer::intValue).sum();
	}

	@Override
	public Type parenthesis(List<Type> args, ASTNode calledFrom) {
		if (args.size() != parameters.size())
			return new ErrorType(calledFrom, "The number of parameters is not equal");
		for (int i = 0;i < parameters.size();i++) {
			Type arg = args.get(i);
			VariableDeclaration param = parameters.get(i);
			if (!param.getType().getClass().equals(arg.getClass())) {
				return new ErrorType(calledFrom, String.format("argument %d must be a %s, not a %s", i, arg, param.getType()));
			}
		}
		return returnType;
	}
	
}
