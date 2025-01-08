// Nome Aline Silmara Menezes Sales | Matrícula : 22250542
// Nome: Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129
 
grammar MiniC;

program : definition (definition)*;

definition: data_definition | function_definition;

data_definition : type declarator (',' declarator)* ';';

type 
        : 'int'
        | 'char'
        ;

declarator : IDENTIFIER;

function_definition : type? function_header function_body;

function_header : declarator parameter_list;

parameter_list : '(' (parameter_declaration)? ')';

parameter_declaration : type declarator (',' declarator)*;

function_body : '{' (data_definition)* (statement)* '}';

block : '{' (statement)* '}' ;

statement
        :  ifStat
        |   whileStat
        |   assignState
        |   exprStat
        |   block
        |   binary
        |   'return' expression? ';'
        ;

ifStat : 'if' '(' expression ')' statement ('else' statement)? ;  
whileStat : 'while' '(' expression ')' statement ;
assignState : IDENTIFIER '=' (exprStat) ';' ;
exprStat : (expression) ';' ;

expression : IDENTIFIER '=' binary #assingExpression
           | binary (',' binary)*  #binaryExrpression
           ;

binary
        : IDENTIFIER '+=' binary #IncrementBinary
        | IDENTIFIER '-=' binary #DecrementBinary
        | IDENTIFIER '*=' binary #MultiplyBinary        
        | IDENTIFIER '/=' binary #DivideBinary
        | IDENTIFIER '%=' binary #ModuleBinary
        | binary '*' binary #RelationalBinary
        | binary '/' binary #RelationalBinary
        | binary '+' binary #RelationalBinary
        | binary '-' binary #RelationalBinary
        | binary '==' binary #RelationalBinary
        | binary '!=' binary #RelationalBinary
        | binary '<' binary #RelationalBinary
        | binary '<=' binary  #RelationalBinary
        | binary '>' binary #RelationalBinary
        | binary '>=' binary #RelationalBinary
        | binary '%' binary #RelationalBinary
        | unary #UnaryBinary
        ;

unary 
        : '++' IDENTIFIER 
        | '--' IDENTIFIER 
        | primary
        ;

primary 
        : IDENTIFIER 
        | CONSTANT_INT 
        | CONSTANT_CHAR 
        |'(' expression ')' 
        | IDENTIFIER '(' (argument_list)? ')'
        ;

argument_list : binary (',' binary)* ;

IDENTIFIER : [a-zA-Z] [a-zA-Z0-9_]* ;

CONSTANT_INT: [0-9]+;

CONSTANT_CHAR: '\'' [a-zA-Z]+ '\'';


WS : [ \t\r\n]+ -> skip ;
