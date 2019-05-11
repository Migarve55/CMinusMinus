package semantic;

import ast.Program;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AstVisitorDefaultImpl<TP, TR> implements AstVisitor<TP, TR> {

	@Override
	public TR visit(Program program, TP param) {
		program.getDefinitions().forEach(def -> def.accept(this, param));
		return null;
	}

	@Override
	public TR visit(FunctionDefinition functionDefinition, TP param) {
		functionDefinition.getType().accept(this, param);
		functionDefinition.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR visit(VariableDefinition variableDefinition, TP param) {
		variableDefinition.getType().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Assignment assignment, TP param) {
		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}
	
	@Override
	public TR visit(OperationAssignment assignment, TP param) {
		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}

	@Override
	public TR visit(If ifStat, TP param) {
		ifStat.getCondition().accept(this, param);
		ifStat.getIfBody().forEach(stat -> stat.accept(this, param));
		ifStat.getElseBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR visit(Invocation invocation, TP param) {
		invocation.getArguments().forEach(arg -> arg.accept(this, param));
		return null;
	}

	@Override
	public TR visit(Read read, TP param) {
		read.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Return returnStat, TP param) {
		if (returnStat.getReturns() != null)
			returnStat.getReturns().accept(this, param);
		return null;
	}

	@Override
	public TR visit(VariableDeclaration variableDeclaration, TP param) {
		variableDeclaration.getType().accept(this, param);
		return null;
	}

	@Override
	public TR visit(While whileStat, TP param) {
		whileStat.getCondition().accept(this, param);
		whileStat.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR visit(Write write, TP param) {
		write.getExpresions().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public TR visit(For forStat, TP param) {
		forStat.getVars().accept(this, param);
		forStat.getCondition().accept(this, param);
		forStat.getIncrement().accept(this, param);
		forStat.getBody().forEach(stat -> stat.accept(this, param));
		return null;
	}

	@Override
	public TR visit(Break breakStat, TP param) {
		return null;
	}

	@Override
	public TR visit(Continue continueStat, TP param) {
		return null;
	}

	@Override
	public TR visit(ArrayAccess arrayAccess, TP param) {
		arrayAccess.getExpresion().accept(this, param);
		arrayAccess.getIndex().accept(this, param);
		return null;
	}

	@Override
	public TR visit(BinaryOperator binaryOperator, TP param) {
		binaryOperator.getLeft().accept(this, param);
		binaryOperator.getRight().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Call call, TP param) {
		call.getArguments().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public TR visit(Cast cast, TP param) {
		cast.getCastType().accept(this, param);
		cast.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Ident ident, TP param) {
		return null;
	}

	@Override
	public TR visit(IntLiteral literal, TP param) {
		return null;
	}
	
	@Override
	public TR visit(DoubleLiteral literal, TP param) {
		return null;
	}
	
	@Override
	public TR visit(CharLiteral literal, TP param) {
		return null;
	}

	@Override
	public TR visit(StructAccess structAccess, TP param) {
		structAccess.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR visit(UnaryOperator unaryOperator, TP param) {
		unaryOperator.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR visit(Address address, TP param) {
		address.getExpresion().accept(this, param);
		return null;
	}

	@Override
	public TR visit(ArrayType arrayAccess, TP param) {
		arrayAccess.getType().accept(this, param);
		return null;
	}

	@Override
	public TR visit(CharType charType, TP param) {
		return null;
	}

	@Override
	public TR visit(DoubleType doubleType, TP param) {
		return null;
	}

	@Override
	public TR visit(ErrorType errorType, TP param) {
		return null;
	}

	@Override
	public TR visit(FunctionType functionType, TP param) {
		functionType.getParameters().forEach(varDef -> varDef.accept(this, param));
		functionType.getReturnType().accept(this, param);
		return null;
	}

	@Override
	public TR visit(IntegerType integerType, TP param) {
		return null;
	}

	@Override
	public TR visit(StructType structType, TP param) {
		structType.getFields().forEach(def -> def.accept(this, param));
		return null;
	}

	@Override
	public TR visit(VoidType voidType, TP param) {
		return null;
	}

	@Override
	public TR visit(PointerType pointerType, TP param) {
		return pointerType.getPointerType().accept(this, param);
	}
	
}
