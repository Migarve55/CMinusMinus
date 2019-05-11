package semantic;

import ast.Program;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public interface AstVisitor<TP,TR> {
	
	public TR visit(Program program, TP param);
	
	//Definitions
	
	public TR visit(FunctionDefinition functionDefinition, TP param);
	
	public TR visit(VariableDefinition variableDefinition, TP param);
	
	//Statements
	
	public TR visit(Assignment assignment, TP param);
	
	public TR visit(OperationAssignment assignment, TP param);
	
	public TR visit(If ifStat, TP param);
	
	public TR visit(Invocation invocation, TP param);
	
	public TR visit(Read read, TP param);
	
	public TR visit(Return returnStat, TP param);
	
	public TR visit(VariableDeclaration variableDeclaration, TP param);
	
	public TR visit(While whileStat, TP param);
	
	public TR visit(Write write, TP param);
	
	public TR visit(For forStat, TP param);
	
	public TR visit(Break breakStat, TP param);

	public TR visit(Continue continueStat, TP param);

	//Expressions
	
	public TR visit(ArrayAccess arrayAccess, TP param);
	
	public TR visit(BinaryOperator binaryOperator, TP param);
	
	public TR visit(Call call, TP param);
	
	public TR visit(Cast cast, TP param);
	
	public TR visit(Ident ident, TP param);
	
	public TR visit(IntLiteral literal, TP param);
	
	public TR visit(DoubleLiteral literal, TP param);
	
	public TR visit(CharLiteral literal, TP param);
	
	public TR visit(StructAccess structAccess, TP param);
	
	public TR visit(UnaryOperator unaryOperator, TP param);
	
	public TR visit(Address address, TP param);
	
	//Types
	
	public TR visit(ArrayType arrayType, TP param);
	
	public TR visit(CharType charType, TP param);
	
	public TR visit(DoubleType doubleType, TP param);
	
	public TR visit(ErrorType errorType, TP param);
	
	public TR visit(FunctionType functionType, TP param);
	
	public TR visit(IntegerType integerType, TP param);
	
	public TR visit(StructType structType, TP param);
	
	public TR visit(VoidType voidType, TP param);

	public TR visit(PointerType pointerType, TP param);
	
}
