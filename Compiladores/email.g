grammar email;
email : NAME '@' NAME EOF ;
NAME: [a-zA-Z0-9._]+ ;
WS : [ \t\r\n]+ -> skip ;