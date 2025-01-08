# Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129
# Aline Silmara Menezes Sales | Matrícula: 22250542

import sys
from antlr4 import *
from miniCLexer import miniCLexer
from miniCParser import miniCParser
from visitor import miniVisitor
from antlr4.tree.Trees import Trees

input_stream = FileStream(sys.argv[1])
lexer = miniCLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = miniCParser(token_stream)
tree = parser.program()
visitor = miniVisitor()
visitor.visit(tree)

if(visitor.errors):
    print("Semantic errors:")
    for error in visitor.errors:
        print(error)

else:
    print("No semantic errors")