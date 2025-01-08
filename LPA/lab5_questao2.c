// Nome : Jhonnatha Luiz de Souza Carvalho 
// Matrícula : 22251129

#include <stdio.h>
#include <string.h>
#include "verifica_senha.h"


char *senhaCriptografada = "$6$LrSF5BAseToYYHJ0$SYY1avj8FRoRGpn.1kPXuZ6Xn5WTl2kL3"
 "hxc3yMWdDUyz4c/Ac3Av3WO8Q9LciP8o4c9WaeLcgxIXWaHpJMFb."; //--> 0451
//char *senhaCriptografada = "$6$rMAk28dVkWjpYoA3$SkWbPYqEB8O/10ryvvjm1qN9BOrkeBOXp"
 //"JScVSGDL5L88OIs0UCBuP.pnd9TQ6SBx60dLKwR9WAzfnLtvjGvj."; --> cpp
 //char *senhaCriptografada = "$6$l2xE4w9twgjtnZBz$9YK9krslZFraLffy5VNiahAfT.xZNvB54"
 //"j91DMCMIoVFvj335ZKxb11qgVMn.KzU2GqVPPyS2FTBqPSciYq761"; // --> 31337

void GenerateAllPasswords(char *pwd, int pos, int siz, char *chars) {
    if (pos < siz) {
        for (int i = 0; i < strlen(chars); i++) {
            pwd[pos] = chars[i];
            GenerateAllPasswords(pwd, pos + 1, siz, chars);
        }
    } else {
        if(!verificaSenha(pwd, senhaCriptografada)){
            printf("%s --> sim! Senha encontrada!\n", pwd);
            return;
        }
        else{
            printf("%s --> não\n", pwd);
        }
    }
}

int main() {
    char password[10];
    int size = 4;
    char charset[] = /*"abcdefghijklmnopqrstuvwxyz";*/"0123456789";

    for(int i = 1; i <= size; i++){
        password[i] = '\0';
        GenerateAllPasswords(password, 0, i, charset);
    }
    

    return 0;
}
