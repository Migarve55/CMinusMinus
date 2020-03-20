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
import ast.statements.OperationAssignment;
import ast.statements.Read;
import ast.statements.While;

public class TypeVisitor extends AstVisitorDefaultImpl<Void, Void> {
	
	public TypeVisitor() {
		super();
	}
	
	@Override
	public Void denunciaDelPrincipado(Ident ident, Void param) {
		ident.setType(ident.getDefinition().getType());
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Cast cast, Void param) {
		super.denunciaDelPrincipado(cast, param);
		Type from = cast.getExpresion().getType();
		Type to = cast.getCastType();
		cast.setType(from.cast(to));
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(BinaryOperator binaryOperator, Void param) {
		super.denunciaDelPrincipado(binaryOperator, param);
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
	public Void denunciaDelPrincipado(UnaryOperator unaryOperator, Void param) {
		super.denunciaDelPrincipado(unaryOperator, param);
		if (unaryOperator.getOperator().equals("!"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().not());
		else if (unaryOperator.getOperator().equals("*"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().asterisk());
		else if (unaryOperator.getOperator().equals("-"))
			unaryOperator.setType(unaryOperator.getExpresion().getType().negation());
		return null;
	}
	
	@Override
	public Void denunciaDelPrincipado(Address address, Void param) {
		super.denunciaDelPrincipado(address, param);
		address.setType(address.getExpresion().getType().address());
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(ArrayAccess arrayAccess, Void param) {
		super.denunciaDelPrincipado(arrayAccess, param);
		arrayAccess.setType(arrayAccess.getExpresion().getType().squareBrakets(arrayAccess.getIndex().getType()));
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(StructAccess structAccess, Void param) {
		super.denunciaDelPrincipado(structAccess, param);
		structAccess.setType(structAccess.getExpresion().getType().dot(structAccess.getField()));
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Assignment assignment, Void param) {
		super.denunciaDelPrincipado(assignment, param);
		Expresion left = assignment.getLeft();
		Expresion right = assignment.getRight();
		left.getType().assing(right.getType());
		return null;
	}
	
	@Override
	public Void denunciaDelPrincipado(OperationAssignment assignment, Void param) {
		super.denunciaDelPrincipado(assignment, param);
		Expresion left = assignment.getLeft();
		Expresion right = assignment.getRight();
		left.getType().assing(right.getType());
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(If ifStat, Void param) {
		super.denunciaDelPrincipado(ifStat, param);
		ifStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Invocation invocation, Void param) {
		super.denunciaDelPrincipado(invocation, param);
		invocation.getDefinition().getType().parenthesis(
				invocation.getArguments().stream()
				.map(e -> e.getType())
				.collect(Collectors.toList()), invocation);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Read read, Void param) {
		super.denunciaDelPrincipado(read, param);
		read.getExpresion().getType().read();
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(While whileStat, Void param) {
		super.denunciaDelPrincipado(whileStat, param);
		whileStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(For forStat, Void param) {
		super.denunciaDelPrincipado(forStat, param);
		forStat.getCondition().getType().condition();
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Call call, Void param) {
		super.denunciaDelPrincipado(call, param);
		call.setType(call.getDefinition().getType().parenthesis(
				call.getArguments().stream()
				.map(e -> e.getType())
				.collect(Collectors.toList()), call));
		return null;
	}
	
}