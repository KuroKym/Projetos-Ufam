#include "heap.h"

struct heap{
    void* elems;
    int tamanho;
    int ocupacao;
    t_heap_comparar comparar;
}

typedef struct heap t_heap;

t_heap* criar_heap(int tamanho, t_heap_comparar comparar){
    t_heap* heap = malloc(sizeof(t_heap));
    heap->elems = malloc(sizeof(void*)*tamanho);
    heap->tamanho = tamanho;
    heap->ocupacao = 0;
    heap->comparar = comparar;

    return heap;
}

void primeiro_heap(t_heap* heap){
    void* elem = NULL;
    if(heap->ocupacao > 0){
        elem = heap->elems[0];
    }
    return elem;
}



desce_heap(void* elems[], int j, t_heap_comparar comparar){

}

static void trocar(void* elems[], int i, int j){
    void* aux = elems[i];
    elems[i] = elems[j];
    elems[j] = aux;

}

void* remover_heap(t_heap){
    void* elem = NULL;
    if(heap->ocupacao > 0){
        elem = heap->elems[0];
        trocar(heap->elem, 0, heap->ocupacao-1);
        heap->ocupacao--;
        desce_heap(heap->elems, 0, heap->comparar);
    }
    return elem;
}

sobe_heap(void* elems[], int i, t_heap_comparar comparar){
    
}

void inserir_heap(t_heap* heap, void* elem){
    heap->elems[heap->ocupacao] = elem;
    sobe_heap(heap->elems, heap->ocupacao, heap->comparar);
    heap->ocupacao++;
}