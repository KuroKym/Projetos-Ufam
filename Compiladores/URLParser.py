# Generated from .//URL.g by ANTLR 4.13.1
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,8,20,2,0,7,0,1,0,1,0,3,0,5,8,0,1,0,1,0,3,0,9,8,0,1,0,3,0,12,
        8,0,1,0,3,0,15,8,0,1,0,3,0,18,8,0,1,0,0,0,1,0,0,0,23,0,4,1,0,0,0,
        2,3,5,2,0,0,3,5,5,1,0,0,4,2,1,0,0,0,4,5,1,0,0,0,5,6,1,0,0,0,6,8,
        5,3,0,0,7,9,5,4,0,0,8,7,1,0,0,0,8,9,1,0,0,0,9,11,1,0,0,0,10,12,5,
        5,0,0,11,10,1,0,0,0,11,12,1,0,0,0,12,14,1,0,0,0,13,15,5,6,0,0,14,
        13,1,0,0,0,14,15,1,0,0,0,15,17,1,0,0,0,16,18,5,7,0,0,17,16,1,0,0,
        0,17,18,1,0,0,0,18,1,1,0,0,0,5,4,8,11,14,17
    ]

class URLParser ( Parser ):

    grammarFileName = "URL.g"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'://'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "PROTOCOL", "DOMAIN", "PORT", 
                      "PATH", "QUERY", "FRAGMENT", "WS" ]

    RULE_url = 0

    ruleNames =  [ "url" ]

    EOF = Token.EOF
    T__0=1
    PROTOCOL=2
    DOMAIN=3
    PORT=4
    PATH=5
    QUERY=6
    FRAGMENT=7
    WS=8

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class UrlContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def DOMAIN(self):
            return self.getToken(URLParser.DOMAIN, 0)

        def PROTOCOL(self):
            return self.getToken(URLParser.PROTOCOL, 0)

        def PORT(self):
            return self.getToken(URLParser.PORT, 0)

        def PATH(self):
            return self.getToken(URLParser.PATH, 0)

        def QUERY(self):
            return self.getToken(URLParser.QUERY, 0)

        def FRAGMENT(self):
            return self.getToken(URLParser.FRAGMENT, 0)

        def getRuleIndex(self):
            return URLParser.RULE_url

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterUrl" ):
                listener.enterUrl(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitUrl" ):
                listener.exitUrl(self)




    def url(self):

        localctx = URLParser.UrlContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_url)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 4
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==2:
                self.state = 2
                self.match(URLParser.PROTOCOL)
                self.state = 3
                self.match(URLParser.T__0)


            self.state = 6
            self.match(URLParser.DOMAIN)
            self.state = 8
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==4:
                self.state = 7
                self.match(URLParser.PORT)


            self.state = 11
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==5:
                self.state = 10
                self.match(URLParser.PATH)


            self.state = 14
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==6:
                self.state = 13
                self.match(URLParser.QUERY)


            self.state = 17
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==7:
                self.state = 16
                self.match(URLParser.FRAGMENT)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





