package semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.Definition;

public class SymbolTable {

	private List<Map<String,Definition>> symbolTable = new ArrayList<Map<String,Definition>>();
	
	public SymbolTable() {
		//Global scope
		set();
	}
	
	public void set() {
		symbolTable.add(new HashMap<String,Definition>());
	}
	
	public void reset() {
		symbolTable.remove(getScope());
	}
	
	public boolean addDefinition(Definition definition) {
		int scope = getScope();
		if (symbolTable.get(scope).containsKey(definition.getName()))
			return false;
		definition.setScope(scope);
		symbolTable.get(scope).put(definition.getName(), definition);
		return true;
	}
	
	/**
	 * Search for a simple in all the scopes
	 * @param ident
	 * @return null if not found
	 */
	public Definition getDefinition(String ident) {
		for (int i = getScope();i >= 0;i--) {
			Map<String,Definition> scope = symbolTable.get(i);
			Definition definition = scope.get(ident);
			if (definition != null)
				return definition;
		}
		return null;
	}
	
	public int getScope() {
		return symbolTable.size() - 1;
	}

}
