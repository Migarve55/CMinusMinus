package codeGeneration;

import java.io.PrintStream;

import ast.ASTNode;
import ast.Expresion;
import ast.Program;
import ast.Type;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.Address;
import ast.expresions.ArrayAccess;
import ast.expresions.BinaryOperator;
import ast.expresions.Call;
import ast.expresions.Cast;
import ast.expresions.CharLiteral;
import ast.expresions.DoubleLiteral;
import ast.expresions.Ident;
import ast.expresions.IntLiteral;
import ast.expresions.StructAccess;
import ast.expresions.UnaryOperator;
import ast.statements.Assignment;
import ast.statements.Break;
import ast.statements.Continue;
import ast.statements.For;
import ast.statements.If;
import ast.statements.Invocation;
import ast.statements.OperationAssignment;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.VariableDeclaration;
import ast.statements.While;
import ast.statements.Write;
import ast.types.FunctionType;
import ast.types.StructType;
import ast.types.VoidType;
import semantic.AstVisitorDefaultImpl;

public class CodeGeneratorVisitor extends AstVisitorDefaultImpl<Boolean, Boolean> {

	private String sourceName;
	private PrintStream out;
	
	private OperatorsUtil operatorsUtil = new OperatorsUtil();
	
	private int conditionalTagCounter = 0;

	public CodeGeneratorVisitor(String sourceName, PrintStream out) {
		super();
		this.sourceName = sourceName;
		this.out = out;
	}

	@Override
	public Boolean visit(Program program, Boolean param) {
		out.printf("#source \"%s\"%n%n", sourceName);
		printInstruction("call main");
		printInstruction("halt");
		super.visit(program, param);
		return null;
	}

	//Definitions
	
	@Override
	public Boolean visit(FunctionDefinition funcDef, Boolean param) {
		printLine(funcDef);
		FunctionType type = (FunctionType) funcDef.getType();
		int localVarsSize = type.getLocalVarsSize();
		//Generation
		printInstruction("%n%s:", funcDef.getName());
		out.printf("#func %s%n", funcDef.getName());
		if (localVarsSize > 0)
			printInstruction("enter %d", localVarsSize);
		out.printf("#ret %s%n", type.getReturnType());
		for (VariableDeclaration p : type.getParameters())
			out.printf("#param %s:%s%n", p.getName(), p.getType());
		funcDef.getBody().forEach(stat -> stat.accept(this, param));
		if (funcDef.needsReturn())
			printInstruction("ret %d,%d,%d", type.getReturnSize(), localVarsSize, type.getParametersSize());
		return null;
	}

	@Override
	public Boolean visit(VariableDefinition variableDefinition, Boolean param) {
		out.printf("#global %s:%s%n", variableDefinition.getName(), variableDefinition.getType());
		super.visit(variableDefinition, param);
		return null;
	}
	
	//Statments

	@Override
	public Boolean visit(VariableDeclaration variableDeclaration, Boolean param) {
		super.visit(variableDeclaration, param);
		out.printf("#local %s:%s%n", variableDeclaration.getName(), variableDeclaration.getType());
		return null;
	}

	@Override
	public Boolean visit(Assignment assignment, Boolean param) {
		printLine(assignment);
		assignment.getLeft().accept(this, false);
		assignment.getRight().accept(this, true);
		printInstruction("store%s", assignment.getRight().getType().getMAPLSuffix());
		return null;
	}
	
	@Override
	public Boolean visit(OperationAssignment assignment, Boolean param) {
		printLine(assignment);
		assignment.getLeft().accept(this, false);
		assignment.getLeft().accept(this, true);
		assignment.getRight().accept(this, true);
		printInstruction(operatorsUtil.getMAPLInstruction(assignment.getOp(), assignment.getLeft().getType()));
		printInstruction("store%s", assignment.getRight().getType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(If ifStat, Boolean param) {
		printLine(ifStat);
		int ctg = conditionalTagCounter++;
		if (ifStat.getElseBody().isEmpty()) {
			ifStat.getCondition().accept(this, true);
			printInstruction("jz out%d", ctg);
			ifStat.getIfBody().forEach(stat -> stat.accept(this, param));
			out.printf("out%d:%n", ctg);
		} else {
			ifStat.getCondition().accept(this, true);
			printInstruction("jz else%d", ctg);
			ifStat.getIfBody().forEach(stat -> stat.accept(this, param));
			printInstruction("jmp out%d", ctg);
			out.printf("else%d:%n", ctg);
			ifStat.getElseBody().forEach(stat -> stat.accept(this, param));
			out.printf("out%d:%n", ctg);
		}
		return null;
	}

	@Override
	public Boolean visit(Invocation invocation, Boolean param) {
		printLine(invocation);
		super.visit(invocation, false);
		printInstruction("call %s", invocation.getName());
		Type type = ((FunctionType) invocation.getDefinition().getType()).getReturnType();
		if (!(type instanceof VoidType))
			printInstruction("pop%s", type.getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(Read read, Boolean param) {
		printLine(read);
		super.visit(read, false);
		printInstruction("in%s" , read.getExpresion().getType().getMAPLSuffix());
		printInstruction("store%s" , read.getExpresion().getType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(Return returnStat, Boolean param) {
		printLine(returnStat);
		super.visit(returnStat, true);
		FunctionType type = (FunctionType) returnStat.getFunction().getType();
		printInstruction("ret %d,%d,%d", type.getReturnSize(), type.getLocalVarsSize(), type.getParametersSize());
		return null;
	}

	@Override
	public Boolean visit(While whileStat, Boolean param) {
		printLine(whileStat);
		int ctg = conditionalTagCounter++;
		whileStat.setLabelId(ctg);
		out.printf("loop%d:%n", ctg);
		whileStat.getCondition().accept(this, true);
		printInstruction("jz out%d", ctg);
		whileStat.getBody().forEach(stat -> stat.accept(this, param));
		out.printf("endLoop%d:%n", ctg);
		printInstruction("jmp loop%d", ctg);
		out.printf("out%d:%n", ctg);
		return null;
	}

	@Override
	public Boolean visit(Write write, Boolean param) {
		printLine(write);
		for (Expresion expr : write.getExpresions()) {
			expr.accept(this, true);
			printInstruction("out%s" , expr.getType().getMAPLSuffix());
		}
		return null;
	}
	
	@Override
	public Boolean visit(For forStat, Boolean param) {
		printLine(forStat);
		int ctg = conditionalTagCounter++;
		forStat.setLabelId(ctg);
		forStat.getVars().accept(this, param);
		out.printf("loop%d:%n", ctg);
		forStat.getCondition().accept(this, true);
		printInstruction("jz out%d", ctg);
		forStat.getBody().forEach(stat -> stat.accept(this, param));
		out.printf("endLoop%d:%n", ctg);
		forStat.getIncrement().accept(this, param);
		printInstruction("jmp loop%d", ctg);
		out.printf("out%d:%n", ctg);
		return null;
	}
	
	@Override
	public Boolean visit(Break breakStat, Boolean param) {
		printInstruction("jmp out%d", breakStat.getParentLoop().getLabelId());
		return null;
	}

	@Override
	public Boolean visit(Continue continueStat, Boolean param) {
		printInstruction("jmp endLoop%d", continueStat.getParentLoop().getLabelId());
		return null;
	}
	
	//Expressions

	@Override
	public Boolean visit(ArrayAccess arrayAccess, Boolean loadValue) {
		arrayAccess.getExpresion().accept(this, false);
		arrayAccess.getIndex().accept(this, true);
		printInstruction("push %d", arrayAccess.getType().getBytesSize());
		printInstruction("mul");
		printInstruction("add");
		if (loadValue)
			printInstruction("load%s", arrayAccess.getType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(BinaryOperator op, Boolean param) {
		op.getLeft().accept(this, param);
		if (!op.getLeft().getType().equals(op.getType())) {
			printInstruction("%s2%s", op.getLeft().getType().getMAPLSuffix(), op.getType().getMAPLSuffix());
		}
		op.getRight().accept(this, param);
		if (!op.getRight().getType().equals(op.getType())) {
			printInstruction("%s2%s", op.getRight().getType().getMAPLSuffix(), op.getType().getMAPLSuffix());
		}
		printInstruction(operatorsUtil.getMAPLInstruction(op.getOperator(), op.getType()));
		return null;
	}

	@Override
	public Boolean visit(Call call, Boolean param) {
		super.visit(call, param);
		printInstruction("call %s", call.getName());
		return null;
	}

	@Override
	public Boolean visit(Cast cast, Boolean param) {
		super.visit(cast, param);
		printInstruction("%s2%s", cast.getExpresion().getType().getMAPLSuffix(), cast.getCastType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(Ident ident, Boolean loadValue) {
		int scope = ident.getDefinition().getScope();
		int offset = ident.getDefinition().getOffset();
		printInstruction("pushi %d", offset);
		if (scope > 0) {
			printInstruction("pusha bp");
			printInstruction("add");
		}
		if (loadValue)
			printInstruction("load%s", ident.getType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(StructAccess structAccess, Boolean loadValue) {
		super.visit(structAccess, false);
		StructType type = (StructType) structAccess.getExpresion().getType();
		int offset = type.getOffsetForField(structAccess.getField());
		printInstruction("pushi %d", offset);
		printInstruction("add");
		if (loadValue)
			printInstruction("load%s", structAccess.getType().getMAPLSuffix());
		return null;
	}

	@Override
	public Boolean visit(UnaryOperator unaryOperator, Boolean param) {
		super.visit(unaryOperator, param);
		if (unaryOperator.getOperator().equals("*")) 
			printInstruction(operatorsUtil.getMAPLInstruction(unaryOperator.getOperator()), unaryOperator.getType().getMAPLSuffix());
		else 
			printInstruction(operatorsUtil.getMAPLInstruction(unaryOperator.getOperator()));
		return null;
	}
	
	@Override
	public Boolean visit(Address address, Boolean param) {
		address.getExpresion().accept(this, false);
		return null;
	}

	@Override
	public Boolean visit(IntLiteral literal, Boolean param) {
		printInstruction("pushi %d", literal.getValue());
		return null;
	}

	@Override
	public Boolean visit(DoubleLiteral literal, Boolean param) {
		printInstruction("pushf %.2f", literal.getValue());
		return null;
	}

	@Override
	public Boolean visit(CharLiteral literal, Boolean param) {
		printInstruction("pushb %d", (int) literal.getValue());
		return null;
	}
	
	@Override
	public Boolean visit(StructType structType, Boolean param) {
		return null;
	}
	
	//Auxiliars

	private void printLine(ASTNode node) {
		out.printf("%n#line %d%n", node.getLine());
	}

	private void printInstruction(String instruction) {
		printInstruction(instruction, null);
	}
	
	private void printInstruction(String instruction, Object... args) {
		out.printf('\t' + instruction + "%n", args);
	}

}
