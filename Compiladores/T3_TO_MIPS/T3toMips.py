# Nome Aline Silmara Menezes Sales | Matrícula : 22250542
# Nome: Jhonnatha Luiz de Souza Carvalho | Matrícula: 22251129

def ler_arquivo_entrada(nome_arquivo):
    with open(nome_arquivo, 'r') as f:
        return f.readlines()

def escrever_arquivo_saida(nome_arquivo, linhas):
    with open(nome_arquivo, 'w') as f:
        f.writelines(linhas)

def converter_para_mips(linhas_intermediarias):
    linhas_mips = []
    inicializacoes = {}
    tarq = []
    ignore = []
    count = 0
    countT = 1
    countST = 0
    reg = {}
    num_if = 0
    linha_if = []
    flag_if = 0

    # Primeira passada: Declarar variáveis e inicializações
    for linha in linhas_intermediarias:
        partes = linha.strip().split()
        if len(partes) == 3 and partes[1] == "=":
            var = partes[0]
            valor = partes[2].strip(";")
            if 't' not in valor:
                inicializacoes[var] = valor
        
    linhas_mips.append(".data\n")
    for var, valor in inicializacoes.items():
            linhas_mips.append(f"{var}: .word {valor} ; {var} = {valor}\n")

    linhas_mips.append(".text\nmain:\n")

    # Inicialização das variáveis
    for var, valor in inicializacoes.items():
        if valor.isdigit():
            linhas_mips.append(f"   lw $s{count}, {var}($zero) ;\n")
            reg[var] = f"$s{count}"
        else:
            linhas_mips.append(f"   lw $s{count}, {var} ;\n")
            reg[var] = f"$s{count}"
        count += 1

    for i in range(len(linhas_intermediarias)):
        linha = linhas_intermediarias[i]
        partes = linha.strip().split()
        linha_if = []
        proxima_linha_if = []
        contador = i
        proxima_linha = linhas_intermediarias[i + 1].strip().split() if i + 1 < len(linhas_intermediarias) else None

        if len(partes) >= 5 or 'if' in partes[0]:
            if 'if' in partes[0]:
                num_if += 1
                linha_if = linhas_intermediarias[contador + 3].strip().split() if 'if' in partes[0] and contador + 3 < len(linhas_intermediarias) and ':' not in linhas_intermediarias[contador+3] else None
                proxima_linha_if = linhas_intermediarias[contador + 4].strip().split() if contador + 4 < len(linhas_intermediarias) and ':' not in linhas_intermediarias[contador+4] else None
                
            elif partes[0] not in reg:
                reg[partes[0]] = f"$s{count}"
            elif linha_if[0] not in reg:
                reg[linha_if[0]] = f"$s{count}"
            
            elif proxima_linha[0] not in reg:
                reg[proxima_linha[0]] = f"$s{count}"
            
            
            
         
            contador+=1
            
            if partes[3] in ['<', '>']:
                if partes[2] in reg and partes[4] in reg:
                    linhas_mips.append(f"   slt $t{countST}, {reg[partes[2]]}, {reg[partes[4]]}\n")
                    linhas_mips.append(f"   beq $t{countST}, $zero, t{countT + 1}\n")
                    tarq.append(f"t{countT + 1}")
                    linhas_mips.append(f"then:\n")
                
            
            elif partes[3] == '+' or (len(linha_if) > 4 and linha_if[3] == '+'):
                    if linha_if != None and len(linha_if) > 4:
                        flag_if = contador+2
                        if (linha_if[2] in reg and linha_if[4] in reg):
                            linhas_mips.append(f"   addi {reg[proxima_linha_if[0]]}, {reg[linha_if[2]]}, {reg[linha_if[4]]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                        elif linha_if[2] in reg:
                            linhas_mips.append(f"   addi {reg[proxima_linha_if[0]]}, {reg[linha_if[2]]}, {linha_if[4]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                        elif linha_if[4] in reg:
                            linhas_mips.append(f"   addi {reg[proxima_linha_if[0]]}, {partes[2]}, {reg[partes[4]]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    elif flag_if != i:
                        if partes[2] in reg and partes[4] in reg:
                            linhas_mips.append(f"   addi {reg[proxima_linha[0]]}, {reg[partes[2]]}, {reg[partes[4]]}\n")
                        elif partes[2] in reg:
                            linhas_mips.append(f"   addi {reg[proxima_linha[0]]}, {reg[partes[2]]}, {partes[4]}\n") 
                        elif partes[4] in reg:
                            linhas_mips.append(f"   addi {reg[proxima_linha[0]]}, {partes[2]}, {reg[partes[4]]}\n") 
                    
                    
            elif partes[3] == '-' or (len(linha_if) > 4 and linha_if[3] == '-'):
                    if linha_if != None and len(linha_if) > 4:
                        flag_if = contador+2
                        if (linha_if[2] in reg and linha_if[4] in reg):
                            linhas_mips.append(f"   sub {reg[proxima_linha_if[0]]}, {reg[linha_if[2]]}, {reg[linha_if[4]]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                        elif linha_if[2] in reg:
                            linhas_mips.append(f"   sub {reg[proxima_linha_if[0]]}, {reg[linha_if[2]]}, {linha_if[4]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                        elif linha_if[4] in reg:
                            linhas_mips.append(f"   sub {reg[proxima_linha_if[0]]}, {partes[2]}, {reg[partes[4]]}\n")
                            linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    elif flag_if != i:
                        if partes[2] in reg and partes[4] in reg:
                            linhas_mips.append(f"   sub {reg[proxima_linha[0]]}, {reg[partes[2]]}, {reg[partes[4]]}\n")
                        elif partes[2] in reg:
                            linhas_mips.append(f"   sub {reg[proxima_linha[0]]}, {reg[partes[2]]}, {partes[4]}\n") 
                        elif partes[4] in reg:
                            linhas_mips.append(f"   sub {reg[proxima_linha[0]]}, {partes[2]}, {reg[partes[4]]}\n") 
                    count += 1 
            
            elif partes[3] == '*' or (len(linha_if) > 4 and linha_if[3] == '*'):
                if linha_if != None and len(linha_if) > 4:
                    flag_if = contador+2
                    if (linha_if[2] in reg and linha_if[4] in reg):
                        linhas_mips.append(f"   mult {reg[linha_if[2]]}, {reg[linha_if[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    elif linha_if[2] in reg:
                        linhas_mips.append(f"   mult {reg[linha_if[2]]}, {linha_if[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    elif linha_if[4] in reg:
                        linhas_mips.append(f"   mult {linha_if[2]}, {reg[linha_if[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    else:
                        linhas_mips.append(f"   mult {linha_if[2]}, {linha_if[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")

                elif flag_if != i:
                    if partes[2] in reg and partes[4] in reg:
                        linhas_mips.append(f"   mult {reg[partes[2]]}, {reg[partes[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                    elif partes[2] in reg:
                        linhas_mips.append(f"   mult {reg[partes[2]]}, {partes[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                    elif partes[4] in reg:
                        linhas_mips.append(f"   mult {partes[2]}, {reg[partes[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                    else:
                        linhas_mips.append(f"   mult {partes[2]}, {partes[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                count += 1
            
            elif partes[3] == '/' or (len(linha_if) > 4 and linha_if[3] == '/'):
                if linha_if != None and len(linha_if) > 4:
                    flag_if = contador+2
                    if (linha_if[2] in reg and linha_if[4] in reg):
                        linhas_mips.append(f"   div {reg[linha_if[2]]}, {reg[linha_if[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[0]]}, {linha_if[0]}($zero) ; \n")
                    elif linha_if[2] in reg:
                        linhas_mips.append(f"   div {reg[linha_if[2]]}, {linha_if[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    elif linha_if[4] in reg:
                        linhas_mips.append(f"   div {linha_if[2]}, {reg[linha_if[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")
                    else:
                        linhas_mips.append(f"   div {linha_if[2]}, {linha_if[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        linhas_mips.append(f"   sw {reg[linha_if[2]]}, {linha_if[2]}($zero) ; \n")

                elif flag_if != i:
                    if partes[2] in reg and partes[4] in reg:
                        linhas_mips.append(f"   div {reg[partes[2]]}, {reg[partes[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")
                        
                    elif partes[2] in reg:
                        linhas_mips.append(f"   div {reg[partes[2]]}, {partes[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")

                    elif partes[4] in reg:
                        linhas_mips.append(f"   div {partes[2]}, {reg[partes[4]]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")

                    else:
                        linhas_mips.append(f"   div {partes[2]}, {partes[4]}\n")
                        linhas_mips.append(f"   mflo $s{count}\n")

        elif len(partes) == 3:
            if ";" in partes[2]:
                idzin = partes[2].split(";")[0]
                if idzin in reg and flag_if != i:
                    linhas_mips.append(f"   sw {reg[partes[0]]}, {partes[0]}($zero) ; \n")
        
        elif partes[0].endswith(":"):
            if partes[0].split(":")[0] not in ignore:
                linhas_mips.append(partes[0]+ "\n")
                countT += 1
        
        elif partes[0] == "goto":
            linhas_mips.append(f"   j {partes[1]} ; \n")

        elif partes[0] == "if":
            ignore.append(partes[3])
        # elif len(partes) == 4:
        #     if 'if' in partes[0]:
        #         linhas_mips.append(f"then:\n")
        #         linhas_mips.append(f"   j {partes[3]}\n")
            
   
    linhas_mips.append("SYSCALL 0 ;")
    return linhas_mips

'''def main():
    arquivo_entrada = 'output.txt'
    arquivo_saida = 'codigo_mips.asm'
    linhas_intermediarias = ler_arquivo_entrada(arquivo_entrada)
    linhas_mips = converter_para_mips(linhas_intermediarias)
    escrever_arquivo_saida(arquivo_saida, linhas_mips)

if __name__ == '__main__':
    main()
'''