# Nome Aline Silmara Menezes Sales | Matrícula : 22250542
# Nome: Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129
from antlr4 import *
from T3toMips import *
from MiniCLexer import MiniCLexer
from MiniCParser import MiniCParser
from Visitor import EvalVisitor

import sys

input_text = FileStream(sys.argv[1])
lexer = MiniCLexer(input_text)
stream = CommonTokenStream(lexer)
parser = MiniCParser(stream)

tree = parser.program()
visitor = EvalVisitor()
visitor.visit(tree)


visitor.__del__()

arquivo_entrada = 'output.txt'
arquivo_saida = 'codigo_mips.asm'

linhas_intermediarias = ler_arquivo_entrada(arquivo_entrada)
linhas_mips = converter_para_mips(linhas_intermediarias)
if(visitor.errors):
    print("Semantic errors:")
    for error in visitor.errors:
        print(error)

else:
    escrever_arquivo_saida(arquivo_saida, linhas_mips)
    print("No semantic errors")
#print(visitor.errors)
#rint(tree.toStringTree(recog=parser))
#print(visitor.errors)

    
#print(visitor.symbol_table)