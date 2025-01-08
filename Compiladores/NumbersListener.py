# Generated from .//Numbers.g by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .NumbersParser import NumbersParser
else:
    from NumbersParser import NumbersParser

# This class defines a complete listener for a parse tree produced by NumbersParser.
class NumbersListener(ParseTreeListener):

    # Enter a parse tree produced by NumbersParser#number.
    def enterNumber(self, ctx:NumbersParser.NumberContext):
        pass

    # Exit a parse tree produced by NumbersParser#number.
    def exitNumber(self, ctx:NumbersParser.NumberContext):
        pass



del NumbersParser