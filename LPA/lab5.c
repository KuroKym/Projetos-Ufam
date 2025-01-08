#include <stdio.h>
#include <string.h>

void GenerateAllPasswords(char *pwd, int pos, int siz, char *chars) {
    if (pos < siz) {
        for (int i = 0; i < strlen(chars); i++) {
            pwd[pos] = chars[i];
            GenerateAllPasswords(pwd, pos + 1, siz, chars);
        }
    } else {
        printf("%s\n", pwd);
    }
}

int main() {
    char password[4]; // Tamanho máximo do password
    int size = 3;// Tamanho do password
    char charset[] = "abc"; // Caracteres permitidos

    for(int i = 1; i <= size; i++){
        password[i] = '\0'; // Adiciona terminador de string
        GenerateAllPasswords(password, 0, i, charset);
    }
    

    return 0;
}
