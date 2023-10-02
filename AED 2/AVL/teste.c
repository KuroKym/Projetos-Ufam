#include <stdio.h>
#include <stdlib.h>
#include "avl.h" // Certifique-se de incluir o cabeçalho onde sua árvore AVL está definida

// Função de comparação para inteiros
int comparar_inteiros(void* a, void* b) {
    int int_a = *((int*)a);
    int int_b = *((int*)b);

    if (int_a < int_b) return -1;
    if (int_a > int_b) return 1;
    return 0;
}

// Função de destruição para inteiros
void destruir_inteiro(void* info) {
    free(info);
}

// Função de impressão para inteiros
void imprimir_inteiro(void* info) {
    int* valor = (int*)info;
    printf("%d ", *valor);
}

int main() {
    t_avl* avl = criar_avl(comparar_inteiros, destruir_inteiro, imprimir_inteiro);

    // Inserindo elementos na árvore
    int* valor1 = malloc(sizeof(int));
    *valor1 = 5;
    inserir_avl(avl, valor1);

    int* valor2 = malloc(sizeof(int));
    *valor2 = 4;
    inserir_avl(avl, valor2);

    int* valor3 = malloc(sizeof(int));
    *valor3 = 3;
    inserir_avl(avl, valor3);

    int* valor4 = malloc(sizeof(int));
    *valor4 = 1;
    inserir_avl(avl, valor4);

    int* valor5 = malloc(sizeof(int));
    *valor5 = 2;
    inserir_avl(avl, valor5);

    // Imprimindo a árvore AVL
    printf("Arvore AVL:\n");
    imprimir_avl(avl);

    // Buscando elementos
    int chave = 3;
    int* resultado = (int*)buscar_avl(avl, &chave);
    if (resultado != NULL) {
        printf("\nElemento %d encontrado na arvore AVL.\n", chave);
    } else {
        printf("\nElemento %d não encontrado na arvore AVL.\n", chave);
    }

    // Limpando a arvore AVL
    podar_avl(avl, valor1);
    podar_avl(avl, valor2);
    podar_avl(avl, valor3);
    podar_avl(avl, valor4);
    podar_avl(avl, valor5);

    // Liberando a memória da árvore AVL
    free(avl);

    return 0;
}
