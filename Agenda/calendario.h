#ifndef CALENDARIO_H
#define CALENDARIO_H

typedef struct tipoEventos {
    char nome[40];
    char data[20];
    char hora[10];
} tipoEventos;

typedef struct tipoNo {
    tipoEventos evento;
    struct tipoNo *prox;
} tipoNo;

typedef struct tipoCalendario {
    tipoNo *prim;
    tipoNo *ult;
} tipoCalendario;


void inicializaCalendario(tipoCalendario *calendario);
void adicionaEvento(tipoCalendario *calendario, void *evento);
void exibirEvento(tipoCalendario *calendario);
void localizarEvento(tipoCalendario *calendario, void *chave);
void removeEvento(tipoCalendario *calendario, void *chave);

#endif