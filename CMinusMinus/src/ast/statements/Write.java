package ast.statements;

import java.util.List;

import ast.ASTNodeImpl;
import ast.Expresion;
import ast.Statment;
import semantic.AstVisitor;

public class Write extends ASTNodeImpl implements Statment {

	private List<Expresion> expresion;
	
	public Write(List<Expresion> expresion) {
		super();
		this.expresion = expresion;
	}

	public List<Expresion> getExpresions() {
		return expresion;
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
