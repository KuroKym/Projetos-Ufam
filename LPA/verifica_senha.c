#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <crypt.h>
#include "verifica_senha.h"
/**
* @brief Verifica se uma senha em texto é a mesma de uma senha criptografada.
*
* @param senhaTeste Senha em texto que queremos ver se corresponde à senha criptografada.
* @param senhaCriptografada Senha criptografada como no arquivo /etc/shadow.
* @return int Retorna 0 (zero) se as senhas forem iguais. Outro valor, caso contrário.
*/
int verificaSenha(char* senhaTeste, char* senhaCriptografada) {
 char *senhaTesteCriptografada = crypt(senhaTeste, senhaCriptografada);
 return strcmp(senhaTesteCriptografada, senhaCriptografada);
}
