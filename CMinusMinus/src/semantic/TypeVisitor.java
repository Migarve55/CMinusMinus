package semantic;

import java.util.stream.Collectors;

import ast.Expresion;
import ast.Type;
import ast.expresions.Address;
import ast.expresions.ArrayAccess;
import ast.expresions.BinaryOperator;
import ast.expresions.Call;
import ast.expresions.Cast;
import ast.expresions.Ident;
import ast.expresions.StructAccess;
import ast.expresions.UnaryOperator;
import ast.statements.Assignment;
import ast.statements.For;
import ast.statements.If;
import ast.statements.Invocation;
import ast.statements.Read;
import ast.statements.Return;
import ast.statements.While;
import ast.types.ErrorType;
import ast.types.FunctionType;

public class TypeVisitor extends AstVisitorDefaultImpl<Void, Void> {
	
	public TypeVisitor() {
		super();
	}
	
	@Override
	public Void visit(Ident ident, Void param) {
		ident.setType(ident.getDefinition().getType());
		return null;
	}

	@Override
	public Void visit(Cast cast, Void param) {
		super.visit(cast, param);
		Type from = cast.getExpresion().getType();
		Type to = cast.getCastType();
		cast.setType(from.cast(to));
		return null;
	}

	@Override
	public Void visit(BinaryOperator binaryOperator, Void param) {
		super.visit(binaryOperator, param);
		Expresion left = binaryOperator.getLeft();
		Expresion right = binaryOperator.getRight();
		if (binaryOperator.getOperator().equals("||") || binaryOperator.getOperator().equals("&&"))
			binaryOperator.setType(left.getType().booleanOp(right.getType()));
		else if (binaryOperator.getOperator().equals("=="))
			binaryOperator.setType(left.getType().equivalent(right.getType()));
		else
			binaryOperator.setType(left.getType().arithmetic(right.getType()));
		return null;
	}
	
	@Override
	public Void visit(UnaryOperator unaryOperator, Void param) {
		super.visit(unaryOperator, param);
		if (unaryOperator.getOperator().equals("!"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().not());
		else if (unaryOperator.getOperator().equals("*"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().asterisk());
		else if (unaryOperator.getOperator().equals("-"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().negation());
		return null;
	}
	
	@Override
	public Void visit(Address address, Void param) {
		super.visit(address, param);
		address.setType(address.getExpresion().getType().address());
		return null;
	}

	@Override
	public Void visit(ArrayAccess arrayAccess, Void param) {
		super.visit(arrayAccess, param);
		arrayAccess.setType(arrayAccess.getExpresion().getType().squareBrakets(arrayAccess.getIndex().getType()));
		return null;
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		super.visit(structAccess, param);
		structAccess.setType(structAccess.getExpresion().getType().dot(structAccess.getField()));
		return null;
	}

	@Override
	public Void visit(Assignment assignment, Void param) {
		super.visit(assignment, param);
		Expresion left = assignment.getLeft();
		Expresion right = assignment.getRight();
		left.getType().assing(right.getType());
		return null;
	}

	@Override
	public Void visit(Return returnStat, Void param) {
		super.visit(returnStat, param);
		Type returns = returnStat.getReturns().getType();
		Type shouldReturn = ((FunctionType) returnStat.getFunction().getType()).getReturnType();
		if (!returns.getClass().equals(shouldReturn.getClass()))
			new ErrorType(returnStat, String.format("it should return an %s, not a %s", returns, shouldReturn));
		return null;
	}

	@Override
	public Void visit(If ifStat, Void param) {
		super.visit(ifStat, param);
		ifStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void visit(Invocation invocation, Void param) {
		super.visit(invocation, param);
		invocation.getDefinition().getType().parenthesis(
				invocation.getArguments().stream()
				.map(e -> e.getType())
				.collect(Collectors.toList()), invocation);
		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		super.visit(read, param);
		read.getExpresion().getType().read();
		return null;
	}

	@Override
	public Void visit(While whileStat, Void param) {
		super.visit(whileStat, param);
		whileStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void visit(For forStat, Void param) {
		super.visit(forStat, param);
		forStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void visit(Call call, Void param) {
		super.visit(call, param);
		call.setType(call.getDefinition().getType().parenthesis(
				call.getArguments().stream()
				.map(e -> e.getType())
				.collect(Collectors.toList()), call));
		return null;
	}
	
}