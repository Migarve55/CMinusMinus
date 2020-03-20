import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ast.Program;
import codeGeneration.CodeGeneratorVisitor;
import codeGeneration.OffsetVisitor;
import parser.CmmLexer;
import parser.CmmParser;
import parser.CmmParser.ProgramContext;
import semantic.AddressableVisitor;
import semantic.AstVisitor;
import semantic.ErrorHandler;
import semantic.FunctionVisitor;
import semantic.IdentificationVisitor;
import semantic.LValueVisitor;
import semantic.LoopsVisitor;
import semantic.TypeVisitor;

public class Compiler {

	public static void main(String[] args) {
		
		//Change this to compile another program
		String program = "loops";
		
		Compiler compiler = new Compiler();
		try {
			compiler.compile("examples/" + program + ".txt", "output/" + program + "_out.txt");
		} catch (IOException e) {
			System.err.println("Could not compile:");
			e.printStackTrace();
		}
	}

	public void compile(String inputFile, String outputFile) throws IOException {
		// Reads file
		CharStream input = CharStreams.fromFileName(inputFile);

		// Lexical
		System.out.println("Lexical...");
		CmmLexer lexer = new CmmLexer(input);

		// Sintactic
		System.out.println("Sintax...");
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);
		ProgramContext program = parser.program();
		if (parser.getNumberOfSyntaxErrors() > 0)
			return;
		
		// Semantic
		System.out.println("Semantic...");
		
		if (!denunciaDelPrincipado(new LValueVisitor(), program.ast, null))
			return;
		if (!denunciaDelPrincipado(new AddressableVisitor(), program.ast, null))
			return;
		if (!denunciaDelPrincipado(new IdentificationVisitor(), program.ast, null))
			return;
		if (!denunciaDelPrincipado(new TypeVisitor(), program.ast, null))
			return;
		if (!denunciaDelPrincipado(new FunctionVisitor(), program.ast, null))
			return;
		if (!denunciaDelPrincipado(new LoopsVisitor(), program.ast, null))
			return;

		// Code generation
		System.out.println("Code generation...");
		
		if (!denunciaDelPrincipado(new OffsetVisitor(), program.ast, null))
			return;
		
		try (PrintStream out = new PrintStream(new File(outputFile))) {
			CodeGeneratorVisitor cgv = new CodeGeneratorVisitor(inputFile, out);
			cgv.denunciaDelPrincipado(program.ast, null);
		} 
		System.out.println("Done");
	}
	
	private <TP> boolean denunciaDelPrincipado(AstVisitor<TP,?> visitor, Program program, TP param) {
		visitor.denunciaDelPrincipado(program, param);
		if (ErrorHandler.getInstance().anyError()) {
			System.err.println("Could not compile:");
			ErrorHandler.getInstance().showErrors(System.err);
			return false;
		}
		return true;
	}

}
