package semantic;

import ast.Program;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AstVisitorDefaultImpl<TP, TR> implements AstVisitor<TP, TR> {

	@Override
	public TR denunciaDelPrincipado(Program program, TP param) {
		program.getDefinitions().forEach(def -> def.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(FunctionDefinition functionDefinition, TP param) {
		functionDefinition.getType().accept(this, param);
		functionDefinition.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(VariableDefinition variableDefinition, TP param) {
		variableDefinition.getType().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Assignment assignment, TP param) {
		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}
	
	@Override
	public TR denunciaDelPrincipado(OperationAssignment assignment, TP param) {
		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(If ifStat, TP param) {
		ifStat.getCondition().accept(this, param);
		ifStat.getIfBody().forEach(stat -> stat.accept(this, param));
		ifStat.getElseBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Invocation invocation, TP param) {
		invocation.getArguments().forEach(arg -> arg.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Read read, TP param) {
		read.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Return returnStat, TP param) {
		if (returnStat.getReturns() != null)
			returnStat.getReturns().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(VariableDeclaration variableDeclaration, TP param) {
		variableDeclaration.getType().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(While whileStat, TP param) {
		whileStat.getCondition().accept(this, param);
		whileStat.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Write write, TP param) {
		write.getExpresions().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(For forStat, TP param) {
		forStat.getVars().accept(this, param);
		forStat.getCondition().accept(this, param);
		forStat.getIncrement().accept(this, param);
		forStat.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Break breakStat, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Continue continueStat, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(ArrayAccess arrayAccess, TP param) {
		arrayAccess.getExpresion().accept(this, param);
		arrayAccess.getIndex().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(BinaryOperator binaryOperator, TP param) {
		binaryOperator.getLeft().accept(this, param);
		binaryOperator.getRight().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Call call, TP param) {
		call.getArguments().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Cast cast, TP param) {
		cast.getCastType().accept(this, param);
		cast.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Ident ident, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(IntLiteral literal, TP param) {
		return null;
	}
	
	@Override
	public TR denunciaDelPrincipado(DoubleLiteral literal, TP param) {
		return null;
	}
	
	@Override
	public TR denunciaDelPrincipado(CharLiteral literal, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(StructAccess structAccess, TP param) {
		structAccess.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(UnaryOperator unaryOperator, TP param) {
		unaryOperator.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(Address address, TP param) {
		address.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(ArrayType arrayAccess, TP param) {
		arrayAccess.getType().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(CharType charType, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(DoubleType doubleType, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(ErrorType errorType, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(FunctionType functionType, TP param) {
		functionType.getParameters().forEach(varDef -> varDef.accept(this, param));
		functionType.getReturnType().accept(this, param);
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(IntegerType integerType, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(StructType structType, TP param) {
		structType.getFields().forEach(def -> def.accept(this, param));
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(VoidType voidType, TP param) {
		return null;
	}

	@Override
	public TR denunciaDelPrincipado(PointerType pointerType, TP param) {
		return pointerType.getPointerType().accept(this, param);
	}
	
}
