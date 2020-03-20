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
	public Boolean denunciaDelPrincipado(FunctionDefinition functionDefinition, Boolean param) {
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
	public Boolean denunciaDelPrincipado(Return returnStat, Boolean param) {
		Type returns = returnStat.getReturns() != null ? returnStat.getReturns().getType() : new VoidType();
		Type shouldReturn = ((FunctionType) returnStat.getFunction().getType()).getReturnType();
		if (!returns.equals(shouldReturn)) {
			new ErrorType(returnStat, String.format("it should return an %s, not a %s", returns, shouldReturn));
			return false;
		}
		return true;
	}
	
	//Other statments

	@Override
	public Boolean denunciaDelPrincipado(If ifStat, Boolean param) {
		super.denunciaDelPrincipado(ifStat, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(While whileStat, Boolean param) {
		super.denunciaDelPrincipado(whileStat, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(For forStat, Boolean param) {
		super.denunciaDelPrincipado(forStat, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(Assignment assignment, Boolean param) {
		super.denunciaDelPrincipado(assignment, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(Invocation invocation, Boolean param) {
		super.denunciaDelPrincipado(invocation, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(Read read, Boolean param) {
		super.denunciaDelPrincipado(read, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(VariableDeclaration variableDeclaration, Boolean param) {
		super.denunciaDelPrincipado(variableDeclaration, param);
		return false;
	}

	@Override
	public Boolean denunciaDelPrincipado(Write write, Boolean param) {
		super.denunciaDelPrincipado(write, param);
		return false;
	}
	
}
