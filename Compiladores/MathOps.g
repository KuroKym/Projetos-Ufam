grammar MathOps;
expr : NUMBER ( ('+' | '-') NUMBER)* ;
NUMBER : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;