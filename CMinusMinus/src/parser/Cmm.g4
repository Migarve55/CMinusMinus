grammar Cmm;	

@parser::header {
import ast.*;
import ast.definitions.*;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;
}

program returns [Program ast]:
       definitions { $ast = new Program($definitions.ast); } EOF
       ;
       
definitions returns [List<Definition> ast=new ArrayList<Definition>()]:
	     (varDefs { $ast.addAll($varDefs.ast); } 
	   | funcDef  { $ast.add($funcDef.ast); } )*  
	     mainDef  { $ast.add($mainDef.ast); }
       ;
          
//Definitions

funcDef returns [FunctionDefinition ast]: 
       type ID '(' params ')' '{' statments '}'  { $ast = new FunctionDefinition($ID.text,new FunctionType($type.ast, $params.ast),$statments.ast); $ast.setLine($ID.line); $ast.setColumn($ID.getCharPositionInLine() + 1);}
       ;
       
mainDef returns [FunctionDefinition ast]: 
       'void' t='main' '(' ')' '{' statments '}'  { $ast = new FunctionDefinition("main",new FunctionType(new VoidType()),$statments.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1);}
       ;   
    
params returns [List<VariableDeclaration> ast=new ArrayList<VariableDeclaration>()]:
       (t1=type id1=ID        { $ast.add(new VariableDeclaration($type.ast, $id1.text)); }
       (',' t2=type id2=ID    { $ast.add(new VariableDeclaration($type.ast, $id2.text)); } )*)?
      ;
       
varDefs returns [List<VariableDefinition> ast=new ArrayList<VariableDefinition>()]: 
       type ids ';' { 
       		for (String id : $ids.ast) {
       			VariableDefinition vd = new VariableDefinition($type.ast, id);
       			vd.setLine($type.ast.getLine());
       			vd.setColumn($type.ast.getColumn());
       			$ast.add(vd); 
       		}
       }
      ;
      
fieldDefs returns [List<VariableDefinition> ast=new ArrayList<VariableDefinition>()]: 
       ( type ids ';'  { 
       		for (String id : $ids.ast) {
       			VariableDefinition vd = new VariableDefinition($type.ast, id);
       			vd.setLine($type.ast.getLine());
       			vd.setColumn($type.ast.getColumn());
       			$ast.add(vd); 
       		}
       } )*
       ;
      
ids returns [List<String> ast=new ArrayList<String>()]:
        id1=ID      { $ast.add($id1.text); }
      ( ',' id2=ID  { $ast.add($id2.text); } )*
      ;

//Types

type returns [Type ast]:
      t='void'                       { $ast = new VoidType(); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
    | t='int'                        { $ast = new IntegerType(); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
    | t='double'                     { $ast = new DoubleType(); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
    | t='char'                       { $ast = new CharType(); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
    | t2=type t='[' INT_CONSTANT ']' { $ast = new ArrayType($t2.ast, Integer.parseInt($INT_CONSTANT.text)); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
    | t='struct' '{' fieldDefs '}'   { $ast = new StructType($fieldDefs.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); } 
    | t2=type t='*'                  { $ast = new PointerType($t2.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); } 
    ;

//Statments

statments returns [List<Statment> ast=new ArrayList<Statment>()]:
      ( statment     { $ast.add($statment.ast); }
      | type ids ';' { 
      		for (String id : $ids.ast) {
      		    VariableDeclaration vd = new VariableDeclaration($type.ast, id);
      		    vd.setLine($type.ast.getLine());
      		    vd.setColumn($type.ast.getColumn());
       			$ast.add(vd); 
       		}
       }  )*
      ;

statment returns [Statment ast]:
          assigment ';'           								{ $ast = $assigment.ast; }
        | ifStat                              					{ $ast = $ifStat.ast; }
        | t='while' '(' expr ')' block        					{ $ast = new While($expr.ast, $block.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
        | t='return' expr ';'                 					{ $ast = new Return($expr.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
        | t='write' args ';'                 				 	{ $ast = new Write($args.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }    
        | t='read' expr ';'                   					{ $ast = new Read($expr.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
        | ID t='(' args ')' ';'               					{ $ast = new Invocation($ID.text, $args.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
        | t='for' '(' vars=assigment ';' cond=expr ';' incr=assigment ')' block	{ $ast = new For($vars.ast,$cond.ast,$incr.ast,$block.ast); $ast.setColumn($t.getCharPositionInLine() + 1); }
        ;
        
assigment returns [Statment ast]:
		e1=expr t='=' e2=expr  { $ast = new Assignment($e1.ast, $e2.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
		;

ifStat returns [If ast]: 
        t='if' '(' expr ')' block                      { $ast = new If($expr.ast, $block.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
      | t='if' '(' expr ')' b1=block 'else' b2=block   { $ast = new If($expr.ast, $b1.ast, $b2.ast); $ast.setLine($t.line); $ast.setColumn($t.getCharPositionInLine() + 1); }
      ;
      
block returns [List<Statment> ast=new ArrayList<Statment>()]:
       statment     { $ast.add($statment.ast); }
     | '{' statments '}' { $ast.addAll($statments.ast);  }
     ;
          
args returns [List<Expresion> ast=new ArrayList<Expresion>()]:
    ( expr     { $ast.add($expr.ast); }
    ( ',' expr { $ast.add($expr.ast); }  )*)?
    ;
          
//Expresions

expr returns [Expresion ast]:
      '(' expr ')'            			{ $ast = $expr.ast; }
    | ID                      			{ $ast = new Ident($ID.text); $ast.setLine($ID.line); $ast.setColumn($ID.getCharPositionInLine() + 1); }
    | e1=expr op='[' e2=expr ']' 		{ $ast = new ArrayAccess($e1.ast, $e2.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | e=expr op='.' ID           		{ $ast = new StructAccess($e.ast, $ID.text); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | op='(' type ')' expr       		{ $ast = new Cast($type.ast, $expr.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | op='&' expr  						{ $ast = new Address($expr.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | op='*' expr                       { $ast = new UnaryOperator($op.text, $expr.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | ID op='(' args ')'         		{ $ast = new Call($ID.text, $args.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }  
    | e1=expr op=('*'|'/'|'%') e2=expr  { $ast = new BinaryOperator($e1.ast, $op.text, $e2.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | e1=expr op=('+'|'-') e2=expr      { $ast = new BinaryOperator($e1.ast, $op.text, $e2.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | op=('!'|'-') expr      		    { $ast = new UnaryOperator($op.text, $expr.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | e1=expr op=('=='|'!='|'<='|'>='|'<'|'>') e2=expr 	{ $ast = new BinaryOperator($e1.ast, $op.text, $e2.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | e1=expr op=('&&'|'||') e2=expr	{ $ast = new BinaryOperator($e1.ast, $op.text, $e2.ast); $ast.setLine($op.line); $ast.setColumn($op.getCharPositionInLine() + 1); }
    | INT_CONSTANT            			{ $ast = new IntLiteral($INT_CONSTANT.text); $ast.setLine($INT_CONSTANT.line); $ast.setColumn($INT_CONSTANT.getCharPositionInLine() + 1); }
    | REAL_CONSTANT          			{ $ast = new DoubleLiteral($REAL_CONSTANT.text); $ast.setLine($REAL_CONSTANT.line); $ast.setColumn($REAL_CONSTANT.getCharPositionInLine() + 1); }
    | CHAR_CONSTANT         			{ $ast = new CharLiteral($CHAR_CONSTANT.text);   $ast.setLine($CHAR_CONSTANT.line); $ast.setColumn($CHAR_CONSTANT.getCharPositionInLine() + 1); }
    ;

////////////////////      
//Lexical analysis//
////////////////////

//Keywords

//Symbols & Operators

//Others

ID: [a-zA-Z_]+[a-zA-Z0-9_]* 
  ;

CHAR_CONSTANT: '\''(.|'\\t'|'\\n'|('\\'INT_CONSTANT))'\''
             ;

INT_CONSTANT: '0' 
            | [1-9]+DIGIT* 
            ;

REAL_CONSTANT: FLOAT
             | FLOAT[eE]'-'?INT_CONSTANT
             | INT_CONSTANT[eE]'-'?INT_CONSTANT
             ;
             
LINE_COMMENT: '//'.*?'\r'?('\n'|EOF)  -> skip
            ; 

MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip 
                  ; 
                  
WHITE_SPACES: (' '|'\t'|'\n'|'\r')+ -> skip
            ; 

fragment DIGIT: [0-9]
              ;
              
fragment FLOAT: INT_CONSTANT?'.'INT_CONSTANT
             |  INT_CONSTANT'.'INT_CONSTANT?
             ;
