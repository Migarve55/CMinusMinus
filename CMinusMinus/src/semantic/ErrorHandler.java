package semantic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

public class ErrorHandler {

	private static ErrorHandler _instance;
	
	private List<ErrorType> errors = new ArrayList<ErrorType>();
	
	private ErrorHandler() {
		
	}
	
	public static ErrorHandler getInstance() {
		if (_instance == null)
			_instance = new ErrorHandler();
		return _instance;
	}
	
	public boolean anyError() {
		return !errors.isEmpty();
	}
	
	public void addError(ErrorType error) {
		errors.add(error);
	}
	
	public void showErrors(PrintStream out) {
		errors.forEach(error -> out.println(error));
	}
	
}
