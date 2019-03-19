package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.Call;
import ast.expresions.Ident;
import ast.expresions.StructAccess;
import ast.statements.If;
import ast.statements.Invocation;
import ast.statements.Return;
import ast.statements.VariableDeclaration;
import ast.statements.While;
import ast.types.ErrorType;
import ast.types.StructType;

public class IdentificationVisitor extends AstVisitorDefaultImpl<Definition, Definition> {
	
	private SymbolTable symbolTable = new SymbolTable();

	public IdentificationVisitor() {
		super();
	}
	
	@Override
	public Definition visit(FunctionDefinition functionDefinition, Definition param) {
		if (!symbolTable.addDefinition(functionDefinition))
			new ErrorType(functionDefinition, String.format("\"Function '%s' was already declared\"", functionDefinition.getName()));
		symbolTable.set();
		super.visit(functionDefinition, functionDefinition);
		symbolTable.reset();
		return null;
	}

	@Override
	public Definition visit(VariableDefinition variableDefinition, Definition param) {
		super.visit(variableDefinition, param);
		if (!symbolTable.addDefinition(variableDefinition))
			new ErrorType(variableDefinition, String.format("\"Variable '%s' was already declared\"", variableDefinition.getName()));
		return null;
	}

	@Override
	public Definition visit(VariableDeclaration variableDeclaration, Definition param) {
		super.visit(variableDeclaration, param);
		VariableDefinition varDef = new VariableDefinition(variableDeclaration.getType(), variableDeclaration.getName());
		variableDeclaration.setVarDef(varDef);
		if (!symbolTable.addDefinition(varDef))
			new ErrorType(variableDeclaration, String.format("\"Variable '%s' was already declared\"", variableDeclaration.getName()));
		return null;
	}
	
	@Override
	public Definition visit(If ifStat, Definition param) {
		symbolTable.set();
		super.visit(ifStat, param);
		symbolTable.reset();
		return null;
	}

	@Override
	public Definition visit(While whileStat, Definition param) {
		symbolTable.set();
		super.visit(whileStat, param);
		symbolTable.reset();
		return null;
	}
	
	//Asignar
	
	@Override
	public Definition visit(Ident ident, Definition param) {
		Definition definition = symbolTable.getDefinition(ident.getName());
		if (definition == null) {
			ident.setType(new ErrorType(ident, ident.getName() + " was not declared"));
			return null;
		}
		ident.setDefinition(definition);
		return null;
	}

	@Override
	public Definition visit(StructAccess structAccess, Definition param) {
		super.visit(structAccess, param);
		Definition definition = symbolTable.getDefinition(structAccess.getField());
		if (definition == null) {
			structAccess.setType(new ErrorType(structAccess, "field was not declared"));
			return null;
		}
		structAccess.setDefinition(definition);
		return null;
	}

	@Override
	public Definition visit(Return returnStat, Definition param) {
		super.visit(returnStat, param);
		returnStat.setFunction((FunctionDefinition) param);
		return null;
	}

	@Override
	public Definition visit(StructType structType, Definition param) {
		super.visit(structType, param);
		Map<String, Definition> declared = new HashMap<String, Definition>();
		for (Definition def : structType.getFields()) {
			if (declared.containsKey(def.getName())) {
				new ErrorType(structType, String.format("%s %s has been declared before", def.getType(), def.getName()));
			} else
				declared.put(def.getName(), def);
		}
		return null;
	}

	@Override
	public Definition visit(Invocation invocation, Definition param) {
		super.visit(invocation, param);
		Definition definition = symbolTable.getDefinition(invocation.getName());
		if (definition == null) {
			new ErrorType(invocation, String.format("function \'%s\' was not declared", invocation.getName()));
			return null;
		}
		if (!(definition instanceof FunctionDefinition)) {
			new ErrorType(invocation, String.format("\'%s\' is not a function", invocation.getName()));
			return null;
		}
		invocation.setDefinition((FunctionDefinition) definition);
		return null;
	}

	@Override
	public Definition visit(Call call, Definition param) {
		super.visit(call, param);
		Definition definition = symbolTable.getDefinition(call.getName());
		if (definition == null) {
			new ErrorType(call, String.format("function \'%s\' was not declared", call.getName()));
			return null;
		}
		if (!(definition instanceof FunctionDefinition)) {
			new ErrorType(call, String.format("\'%s\' is not a function", call.getName()));
			return null;
		}
		call.setDefinition((FunctionDefinition) definition);
		return null;
	}
	
}
