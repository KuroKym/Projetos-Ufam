#include "stdio.h"
#include "stdlib.h"
#include "listaSE.h"

typedef struct elemento{
    void* cargaUtil;
    struct elemento* prox;
} tipoElemento;

/**
 * cria um elemento da LSE
*/
tipoElemento* criar_elemento_lse(void* cargaUtil){
    tipoElemento* novo = malloc(sizeof(tipoElemento));
    novo->cargaUtil = cargaUtil;
    novo->prox = NULL;

    printf("Criando: %p %p %p\n", novo, novo->cargaUtil, novo->prox);

    return novo;
}

typedef struct lse tipoLista;
struct lse{
    tipoElemento* inicio;
    tipoElemento* fim;
    int tamanho;
    // operacoes
    t_imprimir_lse imprimir;
    // t_comparar_lse comparar;

};

tipoLista* criarLista(t_imprimir_lse imprimir){
    tipoLista *l = malloc(sizeof(tipoLista));
    l->inicio = l->fim = NULL;
    l->tamanho = 0;
    // l->imprimir = imprimir;
    // l->comparar = comparar;
    return l;
}

void inserir_lse(tipoLista* lse, void* cargaUtil){
    tipoElemento* novo = criar_elemento_lse(cargaUtil);

    if (lse->inicio == NULL){
        lse->inicio = lse->fim = novo; 
    }else{
        novo->prox = lse->inicio;
        lse->inicio = novo;
    }

    lse->tamanho++;
}

void* remover_lse(tipoLista* lse){
    void* cargaUtil = NULL;
    tipoElemento *removivel = lse->inicio;
    if (lse->inicio != NULL){
        cargaUtil = removivel->cargaUtil;
        lse->inicio = removivel->prox;
        free(removivel);
        lse->tamanho--;
    }
    return cargaUtil;
}

void* acessar_lse(tipoLista* lse, int pos){
    pos = pos%(lse->tamanho+1);
    tipoElemento *cam = lse->inicio;
    void* cargaUtil=NULL;

    if (lse->inicio){
        int i=0;
        while(i<=pos){
            cam = cam->prox;
            i++;
        }
        cargaUtil = cam->cargaUtil;  
    }
    return cargaUtil;
}

void imprimirLista(tipoLista *lse){
    tipoElemento *cam = lse->inicio;
    while(cam){
        lse->imprimir(cam->cargaUtil);
        cam = cam->prox;
    }
}