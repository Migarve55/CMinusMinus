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
	public Void visit(Assignment assignment, Void param) {
		super.visit(assignment, param);
		if (!assignment.getLeft().getLValue()) {
			new ErrorType(assignment, 
				String.format("Can not assign '%s' to '%s'", 
					assignment.getRight(), 
					assignment.getLeft()));
		}
		return null;
	}
	
	@Override
	public Void visit(OperationAssignment assignment, Void param) {
		super.visit(assignment, param);
		if (!assignment.getLeft().getLValue()) {
			new ErrorType(assignment, 
				String.format("Can not assign '%s' to '%s'", 
					assignment.getRight(), 
					assignment.getLeft()));
		}
		return null;
	}

	@Override
	public Void visit(Read read, Void param) {
		super.visit(read, param);
		if (!read.getExpresion().getLValue()) {
			new ErrorType(read, 
				String.format("Can not put read result into '%s'", 
					read.getExpresion()));
		}
		return null;
	}

	@Override
	public Void visit(Call call, Void param) {
		super.visit(call, param);
		call.setLValue(false);
		return null;
	}

	@Override
	public Void visit(Cast cast, Void param) {
		super.visit(cast, param);
		cast.setLValue(false);
		return null;
	}

	@Override
	public Void visit(ArrayAccess arrayAccess, Void param) {
		super.visit(arrayAccess, param);
		arrayAccess.setLValue(true);
		return null;
	}

	@Override
	public Void visit(BinaryOperator binaryOperator, Void param) {
		super.visit(binaryOperator, param);
		binaryOperator.setLValue(false);
		return null;
	}

	@Override
	public Void visit(UnaryOperator unaryOperator, Void param) {
		super.visit(unaryOperator, param);
		unaryOperator.setLValue(!unaryOperator.equals("*"));
		return null;
	}

	@Override
	public Void visit(Ident ident, Void param) {
		super.visit(ident, param);
		ident.setLValue(true);
		return null;
	}

	@Override
	public Void visit(IntLiteral literal, Void param) {
		super.visit(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void visit(DoubleLiteral literal, Void param) {
		super.visit(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void visit(CharLiteral literal, Void param) {
		super.visit(literal, param);
		literal.setLValue(false);
		return null;
	}

	@Override
	public Void visit(StructAccess structAccess, Void param) {
		super.visit(structAccess, param);
		structAccess.setLValue(true);
		return null;
	}
	
}
