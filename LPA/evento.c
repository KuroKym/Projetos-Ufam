//LPA - 2024/01
//  Aluno: Jhonnatha Luiz de Souza Carvalho || Matrícula: 22251129


#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct evento_t
{
    double tempo;
    int alvo;
    int tipo;

} evento_t;

typedef struct lista_eventos_t
{
    evento_t *evento;
    struct lista_eventos_t *prox;
} lista_eventos_t;

bool lista_eventos_adicionar_inicio(evento_t *evento, lista_eventos_t **lista)
{
    lista_eventos_t *novo = malloc(sizeof(lista_eventos_t));

    if (novo == NULL)
    {
        return 0;
    }
    novo->evento = evento;
    novo->prox = *lista;
    *lista = novo;
}

void listar_eventos(lista_eventos_t *lista)
{
    if (lista == NULL)
    {
        printf("Lista vazia");
        return;
    }
    lista_eventos_t *aux = lista;
    while (aux)
    {
        printf("%3.6f\t%d\t%d\n", aux->evento->tempo, aux->evento->alvo, aux->evento->tipo);
        aux = aux->prox;
    }
}

evento_t *criar_evento(double tempo, int alvo, int tipo)
{
    evento_t *novo = malloc(sizeof(evento_t));
    if (novo == NULL)
    {
        return NULL;
    }
    novo->tempo = tempo;
    novo->alvo = alvo;
    novo->tipo = tipo;

    return novo;
}

bool lista_eventos_adicionar_ordenado(evento_t *evento, lista_eventos_t **lista)
{
    lista_eventos_t *novo = malloc(sizeof(lista_eventos_t));
    if (novo == NULL)
    {
        return false;
    }
    novo->evento = evento;
    novo->prox = NULL;

    lista_eventos_t **indireto = lista;
    while (*indireto && (*indireto)->evento->tempo < evento->tempo)
    {
        indireto = &(*indireto)->prox;
    }
    novo->prox = *indireto;
    *indireto = novo;

    return true;
}

bool lista_eventos_adicionar_fim(evento_t *evento, lista_eventos_t **lista)
{

    if (lista == NULL)
    {
        printf("Erro");
        return 0;
    }

    lista_eventos_t *aux = malloc(sizeof(lista_eventos_t));

    if (aux == NULL)
    {
        return 0;
    }

    aux->evento = evento;
    aux->prox = NULL;

    if (*lista == NULL)
    {
        *lista = aux;
        return 1;
    }

    lista_eventos_t *atual = *lista;
    while (atual->prox)
    {
        atual = atual->prox;
    }
    atual->prox = aux;
    return 1;
}

int main(int argc, char *argv[])
{
    FILE *f = fopen(argv[1], "r");
    if (!f)
    {
        printf("Erro ao abrir arquivo\n");
        return 0;
    }
    double tempo = 0;
    int alvo = 0;
    int tipo = 0;
    evento_t *novo = NULL;
    lista_eventos_t *lista = NULL;
    while (!feof(f))
    {
        fscanf(f, "%lf\t%d\t%d\n", &tempo, &alvo, &tipo);
        novo = criar_evento(tempo, alvo, tipo);
        lista_eventos_adicionar_ordenado(novo, &lista);
    }

    listar_eventos(lista);
}
