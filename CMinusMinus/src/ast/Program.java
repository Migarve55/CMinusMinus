package ast;

import java.util.List;

import semantic.AstVisitor;

public class Program extends ASTNodeImpl {

	private List<Definition> definitions;
	
	public Program(List<Definition> definitions) {
		super();
		this.definitions = definitions;
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

}
