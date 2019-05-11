package codeGeneration;

import java.util.HashMap;
import java.util.Map;

import ast.Type;

public class OperatorsUtil {
	
	private Map<String,String> binaryOperators = new HashMap<String,String>();
	private Map<String,String> binaryTypedOperators = new HashMap<String,String>();
	private Map<String,String> unaryOperators = new HashMap<String,String>();

	public OperatorsUtil() {
		//Load operators
		binaryOperators.put("&&", "and");
		binaryOperators.put("||", "or");
		binaryOperators.put("%", "mod");
		binaryTypedOperators.put("==", "eq");
		binaryTypedOperators.put("!=", "ne");
		binaryTypedOperators.put(">=", "ge");
		binaryTypedOperators.put("<=", "le");
		binaryTypedOperators.put("<", "lt");
		binaryTypedOperators.put(">", "gt");
		binaryTypedOperators.put("+", "add");
		binaryTypedOperators.put("-", "sub");
		binaryTypedOperators.put("*", "mul");
		binaryTypedOperators.put("/", "div");
		binaryTypedOperators.put("+=", "add");
		binaryTypedOperators.put("-=", "sub");
		binaryTypedOperators.put("*=", "mul");
		binaryTypedOperators.put("/=", "div");
		unaryOperators.put("!", "not");
		unaryOperators.put("-", "not");
		unaryOperators.put("*", "load%s");
	}
	
	//Métodos
	
	/**
	 * Devuelve la instrucción de MAPL para operadores unarios
	 * @param type
	 * @return
	 */
	public String getMAPLInstruction(String op) {
		return String.format("%s", unaryOperators.get(op));
	}
	
	/**
	 * Devuelve la instrucción de MAPL para operadores binarios
	 * @param op
	 * @param type
	 * @return
	 */
	public String getMAPLInstruction(String op, Type type) {
		if (binaryTypedOperators.containsKey(op))
			return String.format("%s%s", binaryTypedOperators.get(op), type.getMAPLSuffix());
		else
			return String.format("%s", binaryOperators.get(op));
	}

}
