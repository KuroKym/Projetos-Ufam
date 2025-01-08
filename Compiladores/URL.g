grammar URL;

url : (PROTOCOL '://')? DOMAIN (PORT)? (PATH)? (QUERY)? (FRAGMENT)? ;


// Regras para os componentes de uma URL
PROTOCOL : ( 'http' | 'https'| 'ftp' ) ;
DOMAIN : [a-zA-Z0-9_\-.]+ ;
PORT : ':' [0-9]+ ;
PATH : '/' [a-zA-Z0-9_\-./:]+ ( '/' [a-zA-Z0-9_\-./:]+ )* ;
QUERY : '?' [a-zA-Z0-9_&=\-./:]+;

FRAGMENT : '#' [a-zA-Z0-9_&\-./:]+ ;
// Espaços em branco
WS : [ \t\r\n]+ -> skip ;
