from MiniCParser import MiniCParser
from MiniCVisitor import MiniCVisitor

# Nome Aline Silmara Menezes Sales | Matrícula : 22250542
# Nome: Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129

class EvalVisitor(MiniCVisitor):
    def __init__(self):
        self.symbol_table = {}
        self.errors = []
        self.return_type = None
        self.temp_count = 0
        self.temp = []
        self.data = {}
        self.output_file = open("output.txt", "w+")  # Open the output file in write mode

    def add_error(self, message, ctx):
        line = ctx.start.line
        char_position_in_line = ctx.start.column
        self.errors.append(f"Line {line}:{char_position_in_line}: {message}")

    def new_temp(self):
        self.temp_count += 1
        return f't{self.temp_count}'

    def visitProgram(self, ctx: MiniCParser.ProgramContext):
        return self.visitChildren(ctx)

    def visitDefinition(self, ctx: MiniCParser.DefinitionContext):
        return self.visitChildren(ctx)

    def visitData_definition(self, ctx: MiniCParser.Data_definitionContext):
        for declaration in ctx.declarator():
            if declaration.getText() in self.symbol_table:
                self.add_error(f"Error: Variable '{ctx.declarator(0).getText()}' already declared", ctx)
            else:
                self.symbol_table[self.visit(declaration)] = ctx.getChild(0).getText()
        return self.visitChildren(ctx)

    def visitDeclarator(self, ctx: MiniCParser.DeclaratorContext):
        return ctx.IDENTIFIER().getText()

    def visitFunction_definition(self, ctx: MiniCParser.Function_definitionContext):
        function_type = ctx.getChild(0).getText()

        function_information = self.visit(ctx.function_header())

        if function_type == 'int' or function_type == 'char':
            self.symbol_table[function_information[0]] = [function_type, function_information[1]]
            self.return_type = function_type
        else:
            self.symbol_table[function_information[0]] = 'void'
            self.return_type = function_type

        self.visit(ctx.function_body())
        self.current_function_return_type = None
        return

    def visitFunction_header(self, ctx: MiniCParser.Function_headerContext):
        function_name = self.visit(ctx.declarator())
        #self.output_file.write(function_name + "():\n")  # Write to the output file
        arguments_count = self.visit(ctx.parameter_list())
        return [function_name, arguments_count]

    def visitParameter_list(self, ctx: MiniCParser.Parameter_listContext):
        if ctx.parameter_declaration():
            arguments_count = self.visit(ctx.parameter_declaration())
            return arguments_count
        return 0

    def visitParameter_declaration(self, ctx: MiniCParser.Parameter_declarationContext):
        if ctx.getChild(0).getText() == 'int' or ctx.getChild(0).getText() == 'char':
            for i in ctx.declarator():
                self.symbol_table[self.visit(i)] = ctx.getChild(0).getText()
            return len(ctx.declarator())

    def visitFunction_body(self, ctx: MiniCParser.Function_bodyContext):
        for i in ctx.data_definition():
            self.visit(i)
        for i in ctx.statement():
            self.visit(i)

    def visitStatement(self, ctx: MiniCParser.StatementContext):
        if ctx.getChild(0).getText() == "return":
            var = self.visit(ctx.expression()) if ctx.expression() else 'void'
            if var in self.symbol_table:
                var_type = self.symbol_table[var]
            else:
                return

            self.output_file.write(ctx.getChild(0).getText() + ' ' + var + "\n")  # Write to the output file
            if var_type != self.return_type:
                self.add_error(f"Error: Invalid return type. Expecting '{self.return_type}' and got '{var_type}'", ctx)
        if self.errors == []:
            return self.visitChildren(ctx)

    def visitIfStat(self, ctx: MiniCParser.IfStatContext):
        if self.errors == []:
            cond = self.visit(ctx.expression())
            then_label = self.new_temp()
            end_label = self.new_temp()
            self.output_file.write(f"if {cond} goto {then_label}\ngoto {end_label}\n{then_label}:\n")  # Write to the output file

            for statement in ctx.statement():
                self.visit(statement)

            self.output_file.write(f"{end_label}:\n")  # Write to the output file
            return

    def visitWhileStat(self, ctx: MiniCParser.WhileStatContext):
        if self.errors == []:
            start_label = self.new_temp()
            middle_label = self.new_temp()
            end_label = self.new_temp()
            self.output_file.write(f'{start_label}:\n')
            cond = self.visit(ctx.expression())
            self.output_file.write(f"if {cond} goto {middle_label}\ngoto {end_label}\n{middle_label}:\n")
            self.visit(ctx.statement())
            self.output_file.write(f"goto {start_label}\n{end_label}:\n")
            return

    def visitAssignState(self, ctx: MiniCParser.AssignStateContext):
        if self.errors == []:
            var_name = ctx.IDENTIFIER().getText()
            value = self.visit(ctx.exprStat())
            code = f"{var_name} = {value};"
            self.output_file.write(code + "\n")  # Write to the output file
            return code

    def visitExprStat(self, ctx: MiniCParser.ExprStatContext):
        if self.errors == []:
            if ctx.expression():
                expression = self.visit(ctx.expression())
                code = f"{expression};"
               # self.output_file.write(code + "\n")  # Write to the output file
                return code

    def visitAssingExpression(self, ctx: MiniCParser.AssingExpressionContext):
        var_name = ctx.IDENTIFIER().getText()

        value = self.visit(ctx.binary())
        if value not in self.temp:
            if self.symbol_table.get(var_name) is None:
                self.add_error(f"Error: Variable '{var_name}' not declared", ctx)
            elif self.symbol_table.get(var_name) != self.symbol_table.get(value):
                self.add_error(f"Error: Type mismatch in expression found '{self.symbol_table.get(var_name)}' and '{self.symbol_table.get(value)}'", ctx)

        if self.errors == []:
            code = f"{var_name} = {value};"
            if code not in self.output_file:
                self.output_file.write(code + "\n")  # Write to the output file
                return code

    def visitRelationalBinary(self, ctx: MiniCParser.RelationalBinaryContext):
        left = self.visit(ctx.binary(0))
        op = ctx.getChild(1).getText()
        right = self.visit(ctx.binary(1))
        if self.errors == []:
            temp = self.new_temp()
            self.temp.append(temp)
            self.output_file.write(f"{temp} = {left} {op} {right}\n")  # Write to the output file
            return temp
        return

    def visitUnary(self, ctx: MiniCParser.UnaryContext):
        if ctx.IDENTIFIER() is not None:
            var_name = ctx.IDENTIFIER().getText()
            if self.symbol_table.get(var_name) != 'int':
                self.add_error("Error: Invalid type int in unary.", ctx)
            return var_name
        else:
            return self.visit(ctx.getChild(0))

    def visitPrimary(self, ctx: MiniCParser.PrimaryContext):
        l = list(ctx.getChildren())

        if len(l) == 4:
            var_name = ctx.IDENTIFIER().getText()
            if var_name not in self.symbol_table:
                self.add_error(f"Error: Variable '{var_name}' not declared", ctx)

            else:
                argument_list_size = self.visit(l[2])
                function_info = self.symbol_table.get(ctx.IDENTIFIER().getText())
                self.return_type = function_info[0]

                if function_info[1] > argument_list_size:
                    self.add_error(f"Error: Too few arguments. Expecting {function_info[1]} and got {argument_list_size} ", ctx)

                elif function_info[1] < argument_list_size:
                    self.add_error(f"Error: Too many arguments. Expecting {function_info[1]} and {argument_list_size} foram informados", ctx)

                else:
                    parametro = self.get_argument_types(l[2])
                    for i in range(argument_list_size):
                        if parametro[i] != self.return_type:
                            self.add_error(f"Error: Invalid argument in {i+1}. Expeting '{self.return_type}' and got '{parametro[i]}'", ctx)

        elif len(l) == 3:
            return self.visit(l[1])

        else:
            if ctx.IDENTIFIER():
                if ctx.IDENTIFIER().getText() not in self.symbol_table and ctx.IDENTIFIER().getText() != 'return':
                    self.add_error(f"Error: Variable '{ctx.IDENTIFIER().getText()}' not declared", ctx)
                return ctx.IDENTIFIER().getText()

            elif ctx.CONSTANT_INT():
                self.symbol_table[ctx.CONSTANT_INT().getText()] = 'int'
                return ctx.CONSTANT_INT().getText()

            elif ctx.CONSTANT_CHAR():
                self.symbol_table[ctx.CONSTANT_CHAR().getText()] = 'char'
                return ctx.CONSTANT_CHAR().getText()

    def get_argument_types(self, argument_list_ctx):
        types = []
        for i in range(0, argument_list_ctx.getChildCount(), 2):
            arg = argument_list_ctx.getChild(i)
            if arg.getText() in self.symbol_table:
                types.append(self.symbol_table[arg.getText()])
            else:
                types.append(self.visit(arg))
        return types

    def visitArgument_list(self, ctx: MiniCParser.Argument_listContext):
        for i in ctx.binary():
            self.visit(i)
        return len(ctx.binary())

    def visitBlock(self, ctx: MiniCParser.BlockContext):
        if ctx.statement():
            for i in ctx.statement():
                self.visit(i)

    def __del__(self):
        self.output_file.close() 

    '''
    Esse código foi feito pelo gepeto, tem algumas modificações que eu fiz mas nada muito absurdo, só algumas alterações pontuais pra ficar mais parecido com o código esperado. Tem alguns comentários que estão no próprio assembly, se quiserem ver é só executar.
    '''
