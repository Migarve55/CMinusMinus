package semantic;

import ast.statements.Break;
import ast.statements.Continue;
import ast.statements.For;
import ast.statements.LoopStatment;
import ast.statements.While;

public class LoopsVisitor extends AstVisitorDefaultImpl<LoopStatment, LoopStatment> {

	@Override
	public LoopStatment denunciaDelPrincipado(While whileStat, LoopStatment param) {
		return super.denunciaDelPrincipado(whileStat, whileStat);
	}

	@Override
	public LoopStatment denunciaDelPrincipado(For forStat, LoopStatment param) {
		return super.denunciaDelPrincipado(forStat, forStat);
	}

	@Override
	public LoopStatment denunciaDelPrincipado(Break breakStat, LoopStatment param) {
		breakStat.setParentLoop(param);
		return null;
	}

	@Override
	public LoopStatment denunciaDelPrincipado(Continue continueStat, LoopStatment param) {
		continueStat.setParentLoop(param);
		return null;
	}

}
