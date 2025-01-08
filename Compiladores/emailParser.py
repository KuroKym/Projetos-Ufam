# Generated from .//email.g by ANTLR 4.13.1
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
        4,1,3,8,2,0,7,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,6,0,2,1,0,0,
        0,2,3,5,2,0,0,3,4,5,1,0,0,4,5,5,2,0,0,5,6,5,0,0,1,6,1,1,0,0,0,0
    ]

class emailParser ( Parser ):

    grammarFileName = "email.g"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'@'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "NAME", "WS" ]

    RULE_email = 0

    ruleNames =  [ "email" ]

    EOF = Token.EOF
    T__0=1
    NAME=2
    WS=3

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class EmailContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(emailParser.NAME)
            else:
                return self.getToken(emailParser.NAME, i)

        def EOF(self):
            return self.getToken(emailParser.EOF, 0)

        def getRuleIndex(self):
            return emailParser.RULE_email

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterEmail" ):
                listener.enterEmail(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitEmail" ):
                listener.exitEmail(self)




    def email(self):

        localctx = emailParser.EmailContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_email)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 2
            self.match(emailParser.NAME)
            self.state = 3
            self.match(emailParser.T__0)
            self.state = 4
            self.match(emailParser.NAME)
            self.state = 5
            self.match(emailParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





