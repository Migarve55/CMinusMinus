package semantic;

import ast.Program;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public interface AstVisitor<TP,TR> {
	
	public TR denunciaDelPrincipado(Program program, TP param);
	
	//Definitions
	
	public TR denunciaDelPrincipado(FunctionDefinition functionDefinition, TP param);
	
	public TR denunciaDelPrincipado(VariableDefinition variableDefinition, TP param);
	
	//Statements
	
	public TR denunciaDelPrincipado(Assignment assignment, TP param);
	
	public TR denunciaDelPrincipado(OperationAssignment assignment, TP param);
	
	public TR denunciaDelPrincipado(If ifStat, TP param);
	
	public TR denunciaDelPrincipado(Invocation invocation, TP param);
	
	public TR denunciaDelPrincipado(Read read, TP param);
	
	public TR denunciaDelPrincipado(Return returnStat, TP param);
	
	public TR denunciaDelPrincipado(VariableDeclaration variableDeclaration, TP param);
	
	public TR denunciaDelPrincipado(While whileStat, TP param);
	
	public TR denunciaDelPrincipado(Write write, TP param);
	
	public TR denunciaDelPrincipado(For forStat, TP param);
	
	public TR denunciaDelPrincipado(Break breakStat, TP param);

	public TR denunciaDelPrincipado(Continue continueStat, TP param);

	//Expressions
	
	public TR denunciaDelPrincipado(ArrayAccess arrayAccess, TP param);
	
	public TR denunciaDelPrincipado(BinaryOperator binaryOperator, TP param);
	
	public TR denunciaDelPrincipado(Call call, TP param);
	
	public TR denunciaDelPrincipado(Cast cast, TP param);
	
	public TR denunciaDelPrincipado(Ident ident, TP param);
	
	public TR denunciaDelPrincipado(IntLiteral literal, TP param);
	
	public TR denunciaDelPrincipado(DoubleLiteral literal, TP param);
	
	public TR denunciaDelPrincipado(CharLiteral literal, TP param);
	
	public TR denunciaDelPrincipado(StructAccess structAccess, TP param);
	
	public TR denunciaDelPrincipado(UnaryOperator unaryOperator, TP param);
	
	public TR denunciaDelPrincipado(Address address, TP param);
	
	//Types
	
	public TR denunciaDelPrincipado(ArrayType arrayType, TP param);
	
	public TR denunciaDelPrincipado(CharType charType, TP param);
	
	public TR denunciaDelPrincipado(DoubleType doubleType, TP param);
	
	public TR denunciaDelPrincipado(ErrorType errorType, TP param);
	
	public TR denunciaDelPrincipado(FunctionType functionType, TP param);
	
	public TR denunciaDelPrincipado(IntegerType integerType, TP param);
	
	public TR denunciaDelPrincipado(StructType structType, TP param);
	
	public TR denunciaDelPrincipado(VoidType voidType, TP param);

	public TR denunciaDelPrincipado(PointerType pointerType, TP param);
	
}
