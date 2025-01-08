#include <stdio.h>
#include <string.h>
#include "verifica_senha.h"


char *senhaCriptografada = "$6$LrSF5BAseToYYHJ0$SYY1avj8FRoRGpn.1kPXuZ6Xn5WTl2kL3"
 "hxc3yMWdDUyz4c/Ac3Av3WO8Q9LciP8o4c9WaeLcgxIXWaHpJMFb.";
/*char *senhaCriptografada = "$6$rMAk28dVkWjpYoA3$SkWbPYqEB8O/10ryvvjm1qN9BOrkeBOXp"
 "JScVSGDL5L88OIs0UCBuP.pnd9TQ6SBx60dLKwR9WAzfnLtvjGvj.";*/
 /*char *senhaCriptografada = "$6$l2xE4w9twgjtnZBz$9YK9krslZFraLffy5VNiahAfT.xZNvB54"
 "j91DMCMIoVFvj335ZKxb11qgVMn.KzU2GqVPPyS2FTBqPSciYq761";*/

void GenerateAllPasswordsIterative(int size, char *chars) {
    int charsetSize = strlen(chars);
    int indices[size];
    char pwd[size + 1];
    pwd[size] = '\0'; // Adiciona terminador de string

    for (int i = 0; i < size; i++) {
        indices[i] = 0;
    }

    while (1) {
        for (int i = 0; i < size; i++) {
            pwd[i] = chars[indices[i]];
        }

        if (!verificaSenha(pwd, senhaCriptografada)) {
            printf("%s --> sim! Senha encontrada!\n", pwd);
            return;
        }
        else{
            printf("%s --> não\n", pwd);
        }
        int pos = size - 1;
        while (pos >= 0) {
            indices[pos]++;
            if (indices[pos] < charsetSize) {
                break;
            }
            indices[pos] = 0;
            pos--;
        }
        if (pos < 0) {
            break;
        }
    }
}

int main() {
    int size = 4; // Tamanho do password
    char charset[] = "0123456789"; // Caracteres permitidos

    for (int i = 1; i <= size; i++) {
        GenerateAllPasswordsIterative(i, charset);
    }

    return 0;
}
