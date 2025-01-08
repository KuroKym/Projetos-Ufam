// Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129
// Aline Silmara Menezes Sales | Matrícula: 22250542


grammar miniC;

program
    : definition+ EOF
    ;

definition
    : data_definition
    | function_definition
    | expression
    ;

data_definition
    : type declarator ((',' declarator)*|('=' expression)?) ';'  
    ;


type
    : 'int'
    | 'char'
    ;

declarator
    : IDENTIFIER
    ;

function_definition
    : type function_header function_body
    | function_header function_body
    ;

function_header
    : declarator parameter_list
    ;

parameter_list
    : '(' (parameter_declaration (',' parameter_declaration)*)? ')'
    ;

parameter_declaration
    : type declarator ((',' declarator)*)
    ;

function_body
    : '{' data_definition* statement* '}'
    
    ;

block
    : '{' statement* '}'
    ;

statement
    : expression ';'
    | 'if' '(' expression ')' statement ('else' statement)?
    | 'while' '(' expression ')' statement
    | 'break' ';'
    | 'continue' ';'
    | 'return' expression? ';'
    | block
    | ';'
    ;
    
expression
    : binary (',' binary)*
    ;

binary
    : IDENTIFIER '=' binary
    | IDENTIFIER '+=' binary
    | IDENTIFIER '-=' binary
    | IDENTIFIER '*=' binary
    | IDENTIFIER '/=' binary
    | IDENTIFIER '%=' binary
    | binary '==' binary
    | binary '!=' binary
    | binary '<' binary
    | binary '<=' binary
    | binary '>' binary
    | binary '>=' binary
    | binary '+' binary
    | binary '-' binary
    | binary '*' binary
    | binary '/' binary
    | binary '%' binary
    | unary
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
    | '(' expression ')'
    | IDENTIFIER '(' argument_list? ')'
    ;

argument_list
    : binary (',' binary)*
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

CONSTANT_INT
    : [0-9]+
    ;

CONSTANT_CHAR
    : '\'' . '\''
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
COMMENT
    : '//' ~[\r\n]* -> skip  // Ignora comentários do tipo //
    ;
