# Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129
# Aline Silmara Menezes Sales | Matrícula: 22250542


from miniCVisitor import miniCVisitor
from miniCParser import miniCParser

class miniVisitor(miniCVisitor):
    def __init__(self):
        self.symbol_table = {}  
        self.errors = []        
        self.local_symbol_tabbles = {}
        self.return_type = None 
        self.initialize_symbol_table_with_integers() 
    def initialize_symbol_table_with_integers(self):
        numeros_inteiros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]  
        for numero in numeros_inteiros:
            self.symbol_table[str(numero)] = 'int'
            self.local_symbol_tabbles[str(numero)] = 'int'
    def add_error(self, message, ctx):
        line = ctx.start.line  
        self.errors.append(f"Line {line}: {message}")  

    def visitData_definition(self, ctx: miniCParser.Data_definitionContext):
        var_type = ctx.type_().getText()  
        declarators = ctx.declarator()  
        
        for declarator in declarators:
            var_name = declarator.IDENTIFIER().getText() 
            
            if var_name in self.symbol_table:
                self.add_error(f"Error: Variable '{var_name}' already declared", ctx)
            else:
                self.symbol_table[var_name] = var_type  
            
            
            if ctx.expression():
                expr_type = self.visitExpression(ctx.expression())
                if expr_type == 'invalido':
                    self.add_error(f"Error: empty character constant", ctx)
                    self.add_error(f"Error: missing terminating \' character", ctx)
                    self.add_error(f"{var_type} {var_name} = '''", ctx)
                    
                elif expr_type != var_type:
                    self.add_error(f"Error: Type mismatch in expression found '{var_type}' and '{expr_type}'", ctx)

    def visitLocalExpression(self, ctx: miniCParser.ExpressionContext):
        var_name = ctx.getText()
        if var_name in self.local_symbol_tabbles:
            var_type = self.local_symbol_tabbles[var_name]
        elif ctx.binary():
            return self.visitLocalBinary(ctx.binary(0))
        return var_type
    def visitExpression(self, ctx: miniCParser.ExpressionContext):
        var_name = ctx.getText()
       # print(var_name)
        if var_name in self.local_symbol_tabbles:
            var_type = self.local_symbol_tabbles[var_name]    
        elif ctx.binary():
            return self.visitBinary(ctx.binary(0))
        return var_type
    
    def visitBinary(self, ctx: miniCParser.BinaryContext):
        if ctx.unary():
            return self.visitLocalUnary(ctx.unary())
        elif isinstance(ctx.getChild(0), miniCParser.BinaryContext):
           # print("pior que e")
            self.visitBinary(ctx.binary(0))
            self.visitBinary(ctx.binary(1))
        else:
            # print("pior que n")
            self.visitBinary(ctx.getChild(2))
            var_left = ctx.getChild(0).getText() # ID texto da parada
            #print(var_left)
            if var_left in self.symbol_table:
                left_type = self.symbol_table[var_left]
            else:
                left_type = None
                self.add_error(f"Error: Variable '{var_left}' not declared", ctx)
            return left_type
    def visitLocalBinary(self, ctx: miniCParser.BinaryContext):
        if ctx.unary():
            return self.visitLocalUnary(ctx.unary())
        elif isinstance(ctx.getChild(0), miniCParser.BinaryContext):
           # print("pior que e")
            self.visitLocalBinary(ctx.binary(0))
            self.visitLocalBinary(ctx.binary(1))
        else:
            # print("pior que n")
            self.visitLocalBinary(ctx.getChild(2))
            var_left = ctx.getChild(0).getText() # ID texto da parada
            #print(var_left)
            if var_left in self.local_symbol_tabbles:
                left_type = self.local_symbol_tabbles[var_left]
            else:
                left_type = None
                self.add_error(f"Error: Variable '{var_left}' not declared", ctx)
            return left_type

    
    def visitUnary(self, ctx: miniCParser.UnaryContext):
        if ctx.IDENTIFIER():
            #print("unary identifier " + ctx.IDENTIFIER().getText())
            return ctx.IDENTIFIER().getText()
        else:
           # print("indo para primary")
            return self.visitPrimary(ctx.primary())
        
    def visitLocalUnary(self, ctx: miniCParser.UnaryContext):
       # print("visitlocalUnary")
        if ctx.IDENTIFIER():
            #print("unary identifier " + ctx.IDENTIFIER().getText())
            return ctx.IDENTIFIER().getText()
        else:
           # print("indo para primary")
            return self.visitLocalPrimary(ctx.primary())
        
    

    def visitPrimary(self, ctx: miniCParser.PrimaryContext):
        if ctx.IDENTIFIER():
            var_name = ctx.IDENTIFIER().getText()
           # print("variavel " +var_name)
            if var_name not in self.symbol_table:
                self.add_error(f"Error: Variable '{var_name}' not declared", ctx)
            return self.symbol_table.get(var_name)
        elif ctx.CONSTANT_INT():
            return 'int'
        elif ctx.CONSTANT_CHAR():
            char_value = ctx.CONSTANT_CHAR().getText()
            if char_value == "'''" or char_value == "' '":
                return 'invalido'
            else:
                return 'char'
        elif ctx.expression():
            return self.visit(ctx.expression())  # Retorna o tipo da expressão dentro dos parênteses
        else:
            self.add_error("Error: Invalid primary expression", ctx)
            return None

    def visitLocalPrimary(self, ctx: miniCParser.PrimaryContext):
        if ctx.IDENTIFIER():
            var_name = ctx.IDENTIFIER().getText()
           # print("variavel " +var_name)
            if var_name == "void":
                return None
            if var_name not in self.local_symbol_tabbles:
                self.add_error(f"Error: Variable '{var_name}' not declared", ctx)
            return self.local_symbol_tabbles.get(var_name)
        elif ctx.CONSTANT_INT():
            return 'int'
        elif ctx.CONSTANT_CHAR():
            char_value = ctx.CONSTANT_CHAR().getText()
            if char_value == "'''" or char_value == "' '":
                return 'invalido'
            else:
                return 'char'
        elif ctx.expression():
            return self.visitLocalExpression(ctx.expression())  # Retorna o tipo da expressão dentro dos parênteses
        else:
            self.add_error("Error: Invalid primary expression", ctx)
            return None

    def visitFunction_definition(self, ctx: miniCParser.Function_definitionContext):
        function_name = ctx.function_header().declarator().IDENTIFIER().getText()

        # Verifica se a função tem um tipo de retorno declarado
        if ctx.type_():
            self.return_type = ctx.type_().getText()
        else:
            self.return_type = 'void'

        # Adiciona a função à tabela de símbolos
        self.symbol_table[function_name] = self.return_type
        self.local_symbol_tabbles[function_name] = self.return_type
        if ctx.function_header().parameter_list().parameter_declaration(0) == None:
            param_type = ''
        else:
            param_type = ctx.function_header().parameter_list().parameter_declaration(0).type_().getText()
        # Adiciona os parâmetros da função à tabela de símbolos local
        for param in ctx.function_header().parameter_list().parameter_declaration():
            for declaration in param.declarator():
                param_name = declaration.IDENTIFIER().getText()
                self.local_symbol_tabbles[param_name] = param_type
                #self.symbol_table[param_name] = param_type
        self.visitFunction_body(ctx.function_body())
        for e in self.local_symbol_tabbles:
            if self.local_symbol_tabbles[e] == '':
                self.add_error(f"Parameter {e} not declared. ", ctx)

    def visitFunction_body(self, ctx: miniCParser.Function_bodyContext):
        if ctx.data_definition():
            for data in ctx.data_definition():
                var_type = data.type_().getText()  # Obtém o tipo da variável (int ou char)
                declarators = data.declarator()  # Obtém todos os declaradores
                
                for declarator in declarators:
                    var_name = declarator.IDENTIFIER().getText() # Obtém o nome do identificador
                    
                    # Verifica se a variável já foi declarada localmente nesta função
                    if var_name in self.local_symbol_tabbles:
                        self.add_error(f"Error: Variable '{var_name}' already declared in this function", ctx)
                    else:
                        self.local_symbol_tabbles[var_name] = var_type  # Adiciona a variável à tabela de símbolos local
                    
                    # Verifica se há uma expressão associada à declaração da variável
                    if data.expression():
                        expr_type = self.visitExpression(data.expression())
                        if expr_type == 'invalido':
                            self.add_error(f"Error: empty character constant", ctx)
                            self.add_error(f"Error: missing terminating \' character", ctx)
                            self.add_error(f"{var_type} {var_name} = '''", ctx)
                            
                        elif expr_type != var_type:
                            self.add_error(f"Error: Type mismatch in expression found '{var_type}' and '{expr_type}'", ctx)
           
        if ctx.statement():
            for i in ctx.statement():
                self.visitStatement(i)

    def visitStatement(self, ctx: miniCParser.StatementContext):

        if ctx.getChild(0).getText() == "return":
            var_name = ctx.getChild(1).getText()
            var_name = var_name[0]
            if var_name in self.local_symbol_tabbles: 
                var = self.local_symbol_tabbles[var_name]
                if var != self.return_type:
                    self.add_error(f"Error: Type mismatch in return statement found '{self.return_type}' and '{var}'", ctx)
            else:
                self.add_error(f"Error: Variable '{var_name}' not declared", ctx)
        
        if ctx.expression():
            self.visitLocalExpression(ctx.expression())

        if ctx.statement():
            for i in ctx.statement():
                self.visit(i)
        if ctx.block():
            return self.visit(ctx.block())


    def visitIf_statement(self, ctx: miniCParser.StatementContext):
        expr = ctx.expression()
        print("expr: "+expr.getText())
        var_name = expr.getText()
        if var_name in self.local_symbol_tabbles:
            var_type = self.local_symbol_tabbles[var_name]
            if var_name not in self.symbol_table:
                self.symbol_table[var_name] = var_type
        if expr:
            self.visitExpression(expr)
        if ctx.statement(0):
            self.visitStatement(ctx.statement(0))
        if ctx.statement(1):
            self.visitStatement(ctx.statement(1))

    def visitWhile_statement(self, ctx: miniCParser.StatementContext):
       # print("while")
        expr = ctx.expression()
        if expr:
            self.visitExpression(expr)
        if ctx.statement():
            self.visitStatement(ctx.statement())

    def visitReturn_statement(self, ctx: miniCParser.StatementContext):
        expr = ctx.expression()
        if expr:
            self.visitExpression(expr)
        return

    def visitBlock(self, ctx: miniCParser.BlockContext):
        #print("visitando block")
        for statement in ctx.statement():
            self.visitStatement(statement)

    