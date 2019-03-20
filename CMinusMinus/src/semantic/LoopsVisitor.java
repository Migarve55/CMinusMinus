package semantic;

import ast.statements.Break;
import ast.statements.Continue;
import ast.statements.For;
import ast.statements.LoopStatment;
import ast.statements.While;

public class LoopsVisitor extends AstVisitorDefaultImpl<LoopStatment, LoopStatment> {

	@Override
	public LoopStatment visit(While whileStat, LoopStatment param) {
		return super.visit(whileStat, whileStat);
	}

	@Override
	public LoopStatment visit(For forStat, LoopStatment param) {
		return super.visit(forStat, forStat);
	}

	@Override
	public LoopStatment visit(Break breakStat, LoopStatment param) {
		breakStat.setParentLoop(param);
		return null;
	}

	@Override
	public LoopStatment visit(Continue continueStat, LoopStatment param) {
		continueStat.setParentLoop(param);
		return null;
	}

}
