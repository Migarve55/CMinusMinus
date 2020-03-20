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
	public Void denunciaDelPrincipado(Address address, Void param) {
		super.denunciaDelPrincipado(address, param);
		if (!address.getExpresion().isAddresable()) {
			new ErrorType(address, String.format("'&' can not get the address of %s", address.getExpresion()));
		}
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(ArrayAccess arrayAccess, Void param) {
		arrayAccess.setAddresable(true);
		return super.denunciaDelPrincipado(arrayAccess, param);
	}

	@Override
	public Void denunciaDelPrincipado(BinaryOperator binaryOperator, Void param) {
		binaryOperator.setAddresable(false);
		return super.denunciaDelPrincipado(binaryOperator, param);
	}

	@Override
	public Void denunciaDelPrincipado(Call call, Void param) {
		call.setAddresable(true);
		return super.denunciaDelPrincipado(call, param);
	}

	@Override
	public Void denunciaDelPrincipado(Cast cast, Void param) {
		cast.setAddresable(true);
		return super.denunciaDelPrincipado(cast, param);
	}

	@Override
	public Void denunciaDelPrincipado(Ident ident, Void param) {
		ident.setAddresable(true);
		return super.denunciaDelPrincipado(ident, param);
	}

	@Override
	public Void denunciaDelPrincipado(IntLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.denunciaDelPrincipado(literal, param);
	}

	@Override
	public Void denunciaDelPrincipado(DoubleLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.denunciaDelPrincipado(literal, param);
	}

	@Override
	public Void denunciaDelPrincipado(CharLiteral literal, Void param) {
		literal.setAddresable(false);
		return super.denunciaDelPrincipado(literal, param);
	}

	@Override
	public Void denunciaDelPrincipado(StructAccess structAccess, Void param) {
		structAccess.setAddresable(true);
		return super.denunciaDelPrincipado(structAccess, param);
	}

	@Override
	public Void denunciaDelPrincipado(UnaryOperator unaryOperator, Void param) {
		unaryOperator.setAddresable(unaryOperator.getOperator().equals("*"));
		return super.denunciaDelPrincipado(unaryOperator, param);
	}

}
