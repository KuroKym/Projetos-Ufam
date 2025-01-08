# Generated from .//MathOps.g by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .MathOpsParser import MathOpsParser
else:
    from MathOpsParser import MathOpsParser

# This class defines a complete listener for a parse tree produced by MathOpsParser.
class MathOpsListener(ParseTreeListener):

    # Enter a parse tree produced by MathOpsParser#expr.
    def enterExpr(self, ctx:MathOpsParser.ExprContext):
        pass

    # Exit a parse tree produced by MathOpsParser#expr.
    def exitExpr(self, ctx:MathOpsParser.ExprContext):
        pass



del MathOpsParser