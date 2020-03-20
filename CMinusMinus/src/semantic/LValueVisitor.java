package semantic;

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
import ast.statements.OperationAssignment;
import ast.statements.Read;
import ast.types.ErrorType;

public class LValueVisitor extends AstVisitorDefaultImpl<Void, Void> {

	public LValueVisitor() {
		super();
	}

	@Override
	public Void denunciaDelPrincipado(Assignment assignment, Void param) {
		super.denunciaDelPrincipado(assignment, param);
		if (!assignment.getLeft().getLValue()) {
			new ErrorType(assignment, 
				String.format("Can not assign '%s' to '%s'", 
					assignment.getRight(), 
					assignment.getLeft()));
		}
		return null;
	}
	
	@Override
	public Void denunciaDelPrincipado(OperationAssignment assignment, Void param) {
		super.denunciaDelPrincipado(assignment, param);
		if (!assignment.getLeft().getLValue()) {
			new ErrorType(assignment, 
				String.format("Can not assign '%s' to '%s'", 
					assignment.getRight(), 
					assignment.getLeft()));
		}
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Read read, Void param) {
		super.denunciaDelPrincipado(read, param);
		if (!read.getExpresion().getLValue()) {
			new ErrorType(read, 
				String.format("Can not put read result into '%s'", 
					read.getExpresion()));
		}
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Call call, Void param) {
		super.denunciaDelPrincipado(call, param);
		call.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Cast cast, Void param) {
		super.denunciaDelPrincipado(cast, param);
		cast.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(ArrayAccess arrayAccess, Void param) {
		super.denunciaDelPrincipado(arrayAccess, param);
		arrayAccess.setLValue(true);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(BinaryOperator binaryOperator, Void param) {
		super.denunciaDelPrincipado(binaryOperator, param);
		binaryOperator.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(UnaryOperator unaryOperator, Void param) {
		super.denunciaDelPrincipado(unaryOperator, param);
		unaryOperator.setLValue(!unaryOperator.equals("*"));
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(Ident ident, Void param) {
		super.denunciaDelPrincipado(ident, param);
		ident.setLValue(true);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(IntLiteral literal, Void param) {
		super.denunciaDelPrincipado(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(DoubleLiteral literal, Void param) {
		super.denunciaDelPrincipado(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(CharLiteral literal, Void param) {
		super.denunciaDelPrincipado(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void denunciaDelPrincipado(StructAccess structAccess, Void param) {
		super.denunciaDelPrincipado(structAccess, param);
		structAccess.setLValue(true);
		return null;
	}
	
}
