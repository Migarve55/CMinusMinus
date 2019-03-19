package codeGeneration;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.VariableDeclaration;
import ast.types.FunctionType;
import ast.types.StructType;
import semantic.AstVisitorDefaultImpl;

public class OffsetVisitor extends AstVisitorDefaultImpl<Boolean, Boolean> {
	
	private int globalVarsOffset = 0;
	private int localVarsOffset = 0;
	private int localParamsOffset = 0;

	public OffsetVisitor() {
		
	}

	@Override
	public Boolean visit(FunctionDefinition functionDefinition, Boolean isParam) {
		FunctionType type = (FunctionType) functionDefinition.getType();
		localVarsOffset = 0;
		localParamsOffset = 4;
		functionDefinition.getType().accept(this, true);
		functionDefinition.getBody().forEach(stat -> stat.accept(this, false));
		type.setLocalVarsSize(localVarsOffset);
		return null;
	}

	@Override
	public Boolean visit(VariableDefinition variableDefinition, Boolean isParam) {
		super.visit(variableDefinition, isParam);
		//Globals
		if (variableDefinition.getOffset() < 1) {
			variableDefinition.setOffset(globalVarsOffset);
			globalVarsOffset += variableDefinition.getType().getBytesSize();
		} else {
			System.err.println("Out of place: " + variableDefinition);
		}
		return null;
	}
	
	@Override
	public Boolean visit(VariableDeclaration variableDeclaration, Boolean isParam) {
		super.visit(variableDeclaration, isParam);
		int bsize = variableDeclaration.getType().getBytesSize();
		if (isParam) {
			variableDeclaration.getVarDef().setOffset(localParamsOffset);
			localParamsOffset += bsize;
		} else {
			localVarsOffset += bsize;
			variableDeclaration.getVarDef().setOffset(-localVarsOffset);
		}
		return null;
	}

	@Override
	public Boolean visit(StructType structType, Boolean isParam) {
		super.visit(structType, isParam);
		int offset = 0;
		for (VariableDefinition varDef : structType.getFields()) {
			varDef.setOffset(offset);
			offset += varDef.getType().getBytesSize();
		}
		return null;
	}

}
