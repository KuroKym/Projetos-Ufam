# Generated from .//URL.g by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .URLParser import URLParser
else:
    from URLParser import URLParser

# This class defines a complete listener for a parse tree produced by URLParser.
class URLListener(ParseTreeListener):

    # Enter a parse tree produced by URLParser#url.
    def enterUrl(self, ctx:URLParser.UrlContext):
        pass

    # Exit a parse tree produced by URLParser#url.
    def exitUrl(self, ctx:URLParser.UrlContext):
        pass



del URLParser