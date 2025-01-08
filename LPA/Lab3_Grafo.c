#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>


typedef struct lista_vizinhos_t {
    int id_vizinho;
    struct lista_vizinhos_t *prox;
} lista_vizinhos_t;

typedef struct {
    int id;
    double x, y;
    lista_vizinhos_t *lista_vizinhos;
} no_t;

typedef no_t* grafo_t;

grafo_t criar_grafo(int tam){
    grafo_t g = (grafo_t) malloc(tam * sizeof(no_t));
    if(g == NULL){
        fprintf(stderr, "Erro ao alocar memoria.\n");
        exit(1);
    }
    return g;
}

bool adicionar_vizinhos_lista(int vizinho, lista_vizinhos_t **lista){
    lista_vizinhos_t *novo = (lista_vizinhos_t*) malloc(sizeof(lista_vizinhos_t));
    if(novo == NULL){
        fprintf(stderr, "Erro ao alocar memoria.\n");
        return false;
    }
    novo->id_vizinho = vizinho;
    novo->prox = *lista;
    *lista = novo;
    return true;
}

void imprimir_vizinhos_lista(lista_vizinhos_t *lista){
    while(lista !=  NULL) {
        printf("%d ", lista->id_vizinho);
        lista = lista->prox;
    }
}

void atualizar_vizinho_grafo(int tam, double raio_comunicacao, grafo_t grafo){
    for(int i = 0; i < tam; i++){
        for(int j = 0; j < tam; j++){
            if(i!= j){
                double distancia = sqrt(pow(grafo[i].x - grafo[j].x, 2) + pow(grafo[i].y - grafo[j].y, 2));
                if(distancia <= raio_comunicacao){
                    adicionar_vizinhos_lista(j, &grafo[i].lista_vizinhos);
                }
            }
        }
    }
}

void imprimir_grafo(int tam, grafo_t grafo){
    for(int i = 0; i < tam; i++){
        printf("NÓ %d: ", grafo[i].id);
        imprimir_vizinhos_lista(grafo[i].lista_vizinhos);
        printf("\n");
    }
}

int main(int argc, char **argv){
    if(argc < 2){
        fprintf(stderr, "Uso: %s <raio_comunicacao>\n", argv[0]);
        return 1;
    }

    FILE *f = fopen(argv[1], "r");
    if(f == NULL){
        fprintf(stderr, "Erro ao abrir arquivo.\n");
        return 1;
    }

    int qnt_nos;
    double raio_comunicacao;
    fscanf(f, "%d\t%lf\n", &qnt_nos, &raio_comunicacao);

    grafo_t grafo = criar_grafo(qnt_nos);

    for(int i = 0; i < qnt_nos; i++){
        fscanf(f, "%d\t%lf\t%lf\n", &grafo[i].id, &grafo[i].x, &grafo[i].y);
        grafo[i].lista_vizinhos = NULL;
    }

    fclose(f);
    atualizar_vizinho_grafo(qnt_nos, raio_comunicacao, grafo);
    imprimir_grafo(qnt_nos, grafo);

    return 0;
}