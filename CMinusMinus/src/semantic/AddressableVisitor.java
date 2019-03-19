package semantic;

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
import ast.types.ErrorType;

public class AddressableVisitor extends AstVisitorDefaultImpl<Void, Void> {

	public AddressableVisitor() {
		
	}
	
	@Override
	public Void visit(Address address, Void param) {
		super.visit(address, param);
		if (!address.getExpresion().isAddresable()) {
			new ErrorType(address, String.format("'&' can not get the address of %s", address.getExpresion()));
		}
		return null;
	}

	@Override
	public Void visit(ArrayAccess arrayAccess, Void param) {
		arrayAccess.setAddresable(true);
		return super.visit(arrayAccess, param);
	}

	@Override
	public Void visit(BinaryOperator binaryOperator, Void param) {
		binaryOperator.setAddresable(false);
		return super.visit(binaryOperator, param);
	}

	@Override
	public Void visit(Call call, Void param) {
		call.setAddresable(true);
		return super.visit(call, param);
	}

	@Override
	public Void visit(Cast cast, Void param) {
		cast.setAddresable(true);
		return super.visit(cast, param);
	}

	@Override
	public Void visit(Ident ident, Void param) {
		ident.setAddresable(true);
		return super.visit(ident, param);
	}

	@Override
	public Void visit(IntLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.visit(literal, param);
	}

	@Override
	public Void visit(DoubleLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.visit(literal, param);
	}

	@Override
	public Void visit(CharLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.visit(literal, param);
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		structAccess.setAddresable(true);
		return super.visit(structAccess, param);
	}

	@Override
	public Void visit(UnaryOperator unaryOperator, Void param) {
		unaryOperator.setAddresable(unaryOperator.getOperator().equals("*"));
		return super.visit(unaryOperator, param);
	}

}
