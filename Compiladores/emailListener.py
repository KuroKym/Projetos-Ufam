# Generated from .//email.g by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .emailParser import emailParser
else:
    from emailParser import emailParser

# This class defines a complete listener for a parse tree produced by emailParser.
class emailListener(ParseTreeListener):

    # Enter a parse tree produced by emailParser#email.
    def enterEmail(self, ctx:emailParser.EmailContext):
        pass

    # Exit a parse tree produced by emailParser#email.
    def exitEmail(self, ctx:emailParser.EmailContext):
        pass



del emailParser