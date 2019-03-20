package semantic;

import ast.Type;
import ast.definitions.FunctionDefinition;
import ast.statements.Assignment;
import ast.statements.For;
import ast.statements.If;
import ast.statements.Invocation;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.VariableDeclaration;
import ast.statements.While;
import ast.statements.Write;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.VoidType;

public class FunctionVisitor extends AstVisitorDefaultImpl<Boolean, Boolean> {
	
	@Override
	public Boolean visit(FunctionDefinition functionDefinition, Boolean param) {
		boolean isSafe = functionDefinition.getBody().stream().anyMatch(stat -> stat.accept(this, true));
		Type shouldReturn = ((FunctionType) functionDefinition.getType()).getReturnType();
		boolean returnsVoid = shouldReturn.getClass().equals(VoidType.class);
		functionDefinition.setNeedsReturn(!isSafe && returnsVoid);
		if (!(isSafe || returnsVoid)) {
			new ErrorType(functionDefinition, "No valid return point found");
		}
		return null;
	}

	@Override
	public Boolean visit(Return returnStat, Boolean param) {
		Type returns = returnStat.getReturns() != null ? returnStat.getReturns().getType() : new VoidType();
		Type shouldReturn = ((FunctionType) returnStat.getFunction().getType()).getReturnType();
		if (!returns.getClass().equals(shouldReturn.getClass())) {
			new ErrorType(returnStat, String.format("it should return an %s, not a %s", returns, shouldReturn));
			return false;
		}
		return true;
	}
	
	//Other statments

	@Override
	public Boolean visit(If ifStat, Boolean param) {
		super.visit(ifStat, param);
		return false;
	}

	@Override
	public Boolean visit(While whileStat, Boolean param) {
		super.visit(whileStat, param);
		return false;
	}

	@Override
	public Boolean visit(For forStat, Boolean param) {
		super.visit(forStat, param);
		return false;
	}

	@Override
	public Boolean visit(Assignment assignment, Boolean param) {
		super.visit(assignment, param);
		return false;
	}

	@Override
	public Boolean visit(Invocation invocation, Boolean param) {
		super.visit(invocation, param);
		return false;
	}

	@Override
	public Boolean visit(Read read, Boolean param) {
		super.visit(read, param);
		return false;
	}

	@Override
	public Boolean visit(VariableDeclaration variableDeclaration, Boolean param) {
		super.visit(variableDeclaration, param);
		return false;
	}

	@Override
	public Boolean visit(Write write, Boolean param) {
		super.visit(write, param);
		return false;
	}
	
	
	
}
