package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public static char lexemeToChar(String str) {
		if (str.length() == 3)
			return str.charAt(1);
		//Special chars
		if (str.equals("'\\n'"))
			return '\n';
		if (str.equals("'\\t'"))
			return '\t';
		return getFromNumericChar(str);
	}
	
	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
	//Auxiliars
	
	private static char getFromNumericChar(String str) {
		String number = str.substring(2,str.length() - 1);
		int n = Integer.parseInt(number);
		return (char) n;
	}
	
}
