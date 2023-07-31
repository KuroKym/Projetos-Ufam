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
     int tam; 
 } tipoCalendario; 
  
  
 void criar_agenda(tipoCalendario *calendario); 
 void adiciona_evento(tipoCalendario *calendario, void *evento); 
 void proximo_evento(tipoCalendario *calendario); 
 void finalizar_evento(tipoCalendario *calendario); 
 void quantificar_evento(tipoCalendario *calendario); 
  
 #endif