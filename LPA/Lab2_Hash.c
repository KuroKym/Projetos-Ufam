#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


typedef struct pessoa {
    char nome[51];
    long long int cpf;
    int idade;
} pessoa_t;

typedef struct lista_pessoas {
    pessoa_t *pessoa;
    struct lista_pessoas *prox;
} lista_pessoas_t;

typedef lista_pessoas_t** tabela_hash_t;

int tabela_hash_tam;

tabela_hash_t tabela_hash_pessoas_criar() {
    tabela_hash_t tabela_hash = (tabela_hash_t)malloc(sizeof(lista_pessoas_t*) * tabela_hash_tam);
    for (int i = 0; i < tabela_hash_tam; i++) {
        tabela_hash[i] = NULL;
    }
    return tabela_hash;
}

int tabela_hash_pessoas_funcao(long long int cpf) {
    return cpf % tabela_hash_tam;
}

bool lista_pessoa_adicionar(pessoa_t *pessoa, lista_pessoas_t **lista)
{
    lista_pessoas_t *novo = malloc(sizeof(lista_pessoas_t));

    if (novo == NULL)
    {
        return false;
    }
    novo->pessoa = pessoa;
    novo->prox = *lista;
    *lista = novo;
    return true;
}

void listar_pessoas(lista_pessoas_t *lista)
{
    lista_pessoas_t* aux = lista;
    while (aux)
    {
        printf("%s, %lld, %d\n", aux->pessoa->nome, aux->pessoa->cpf, aux->pessoa->idade);
        aux = aux->prox;
    }
}

bool tabela_hash_pessoas_adicionar(pessoa_t *pessoa, tabela_hash_t tabela_hash) {
    int indice = tabela_hash_pessoas_funcao(pessoa->cpf);
    lista_pessoas_t **lista = &tabela_hash[indice];
    return lista_pessoa_adicionar(pessoa, lista);
}

void tabela_hash_pessoas_listar(tabela_hash_t tabela_hash) {
    for (int i = 0; i < tabela_hash_tam; i++) {
        printf("Posicao %d:\n", i);
        listar_pessoas(tabela_hash[i]);
        printf("\n");
    }
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Algumentos insuficientes\n", argv[0]);
        return 1;
    }
    sscanf(argv[1], "%d", &tabela_hash_tam);
    FILE *arquivo = fopen(argv[2], "r");
    if (!arquivo) {
        fprintf(stderr, "Erro ao abrir o arquivo\n");
        return 1;
    }
    tabela_hash_t tabela_hash = tabela_hash_pessoas_criar();
    char nome[51];
    long long int cpf;
    int idade;
    while (fscanf(arquivo, "%50[^\t]%lld\t%d\n", nome, &cpf, &idade) == 3) {
        pessoa_t *nova_pessoa = (pessoa_t *)malloc(sizeof(pessoa_t));
        if (nova_pessoa == NULL) {
            fprintf(stderr, "Erro ao alocar memória\n");
            return 1;
        }
        strcpy(nova_pessoa->nome, nome);
        nova_pessoa->cpf = cpf;
        nova_pessoa->idade = idade;
        if (!tabela_hash_pessoas_adicionar(nova_pessoa, tabela_hash)) {
            fprintf(stderr, "Erro ao adicionar pessoa na tabela hash\n");
            return 1;
        }
    }
    fclose(arquivo);

    tabela_hash_pessoas_listar(tabela_hash);

    return 0;
}