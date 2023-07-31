#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "calendario.h"


void adicionaEvento(tipoCalendario *calendario, void *evento) {
    tipoNo *novoEvento = (tipoNo*)malloc(sizeof(tipoNo));

    if (!novoEvento) {
        printf("Erro ao alocar memoria para o evento.\n");
        return;
    }

    tipoEventos *eventoPtr = (tipoEventos*)evento;
    novoEvento->evento = *eventoPtr;
    novoEvento->prox = NULL;

    if (!calendario->prim) {
        calendario->prim = novoEvento;
        calendario->ult = novoEvento;
        return;
    }

    int novoAno, novoMes, novoDia;
    int eventoAno, eventoMes, eventoDia;
    sscanf(novoEvento->evento.data, "%d/%d/%d", &novoDia, &novoMes, &novoAno);

    tipoNo *tmp = NULL;
    tipoNo *aux = calendario->prim;
    while (aux) {
        sscanf(aux->evento.data, "%d/%d/%d", &eventoDia, &eventoMes, &eventoAno);
        if (novoAno < eventoAno ||
            (novoAno == eventoAno && novoMes < eventoMes) ||
            (novoAno == eventoAno && novoMes == eventoMes && novoDia < eventoDia)) {
            if (tmp) {
                tmp->prox = novoEvento;
            } else {
                calendario->prim = novoEvento;
            }
            novoEvento->prox = aux;
            return;
        }
        tmp = aux;
        aux = aux->prox;
    }

    tmp->prox = novoEvento;
    calendario->ult = novoEvento;
}


void localizarEvento(tipoCalendario *calendario, void *chave) {
    tipoNo *aux = calendario->prim;
    int encontrado = 0;

    char *chaveStr = (char*)chave;

    while (aux) {
        if ((strcmp(aux->evento.data, chaveStr) == 0) || (strcmp(aux->evento.hora, chaveStr) == 0) || (strcmp(aux->evento.nome, chaveStr) == 0)) {
            printf("---------------------------\n");
            printf("Evento encontrado:\n");
            printf("Nome: %s\n", aux->evento.nome);
            printf("Data: %s\n", aux->evento.data);
            printf("Horario: %s\n", aux->evento.hora);
            printf("---------------------------\n");
            encontrado = 1;
            aux = aux->prox;
        }
 
    }

    if (!encontrado) {
        printf("Evento \"%s\" nao foi encontrado.\n", chaveStr);
    }
}

void inicializaCalendario(tipoCalendario *calendario){
    calendario->prim =NULL;
    calendario->ult = NULL;
}

void exibirEvento(tipoCalendario *calendario) {
    tipoNo *aux = calendario->prim;
    int cont = 1;

    while (aux) {
        printf("Evento %d\n", cont);
        printf("Nome: %s\n", aux->evento.nome);
        printf("Data: %s\n", aux->evento.data);
        printf("Horario: %s\n", aux->evento.hora); 
        printf("\n");

        aux = aux->prox;
        cont++;
    }
}

void removeEvento(tipoCalendario *calendario, void *chave) {
    tipoNo *aux = calendario->prim;
    tipoNo *tmp;

    if (!aux) {
        printf("Calendario vazio\n");
        return;
    }

    while (aux && ((strcmp(aux->evento.nome, (char *)chave) == 0) || (strcmp(aux->evento.data, (char *)chave) == 0))) {
        calendario->prim = aux->prox;
        free(aux);
        aux = calendario->prim;
        printf("Evento Removido\n");
    }

    while (aux && aux->prox) {
        if ((strcmp(aux->prox->evento.nome, (char *)chave) == 0) || (strcmp(aux->prox->evento.data, (char *)chave) == 0)) {
            tmp = aux->prox;
            aux->prox = tmp->prox;
            if (calendario->ult == tmp) {
                calendario->ult = aux;
            }
            free(tmp);
            printf("Evento Removido\n");
        } else {
            aux = aux->prox;
        }
    }
}





