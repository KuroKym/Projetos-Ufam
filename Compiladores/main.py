from antlr4 import *
from URLLexer import URLLexer
from URLParser import URLParser

class MyListener(ParseTreeListener):
    def enterUrl(self, ctx):
        print("URL encontrado! exibindo detalhes:")
        print(ctx.getText())
        print("Protocolo:", ctx.PROTOCOL().getText() if ctx.PROTOCOL() else "Não incluído")
        print("Domínio:", ctx.DOMAIN().getText())
        print("Porta:", ctx.PORT().getText() if ctx.PORT() else "Não incluído")
        print("Caminho:", ctx.PATH().getText() if ctx.PATH() else "Não incluído")
        print("Query:", ctx.QUERY().getText() if ctx.QUERY() else "Não incluído")
        print("Fragmento:", ctx.FRAGMENT().getText() if ctx.FRAGMENT() else "Não incluído")

def main():
    # Carregar a entrada
    input_stream = InputStream(input('? '))
    
    # Criar o lexer
    lexer = URLLexer(input_stream)
    
    # Criar o stream de tokens para o parser
    stream = CommonTokenStream(lexer)
    
    # Criar o parser
    parser = URLParser(stream)
    
    # Iniciar o parse da regra inicial
    tree = parser.url()
    
    # Criar um listener
    listener = MyListener()
    
    # Adicionar o listener ao parser
    walker = ParseTreeWalker()
    walker.walk(listener, tree)

if __name__ == '__main__':
    main()
