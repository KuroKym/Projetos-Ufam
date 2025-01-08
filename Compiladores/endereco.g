grammar endereco;
url : protocol '://' domain (':' port)? (path)? ('?' query )? ('#' frag)?  ;


protocol : 'http' | 'ftp' | 'https' ;
domain : DOMAIN (DOMAIN)* ;
port : PORT ;
path : PATH ;
query : QUERY ;
frag : FRAG ;

PORT : [0-9]+ ;

DOMAIN : [a-zA-Z0-9.]+[a-zA-Z0-9.]* ;
PATH : ('/'.[a-z]*('.''zip')?)+ ;
QUERY : [a-z]+'='[a-z0-9]+('&'[a-z]+'='[a-z0-9]*)* ;
FRAG : [A-Za-z0-9]+ EOF ;
WS : [ \t\r\n]+ -> skip ;


