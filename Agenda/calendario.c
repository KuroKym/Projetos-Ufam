#include <stdio.h> 
 #include <stdlib.h> 
 #include <string.h> 
 #include "calendario.h" 
  
  
 void agendar_evento(tipoCalendario *calendario, void *evento) { 
     tipoNo *novoEvento = (tipoNo*)malloc(sizeof(tipoNo)); 
  
     if (!novoEvento) { 
         printf("Erro ao alocar memoria para o evento.\n"); 
         return; 
     } 
  
     tipoEventos *eventoPtr = (tipoEventos*)evento; 
     novoEvento->evento = *eventoPtr; 
     calendario->tam++;
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
  
 void proximo_evento(tipoCalendario *calendario) {
 	tipoNo *aux = calendario->prim;
    if (aux) {
    	printf("Evento encontrado:\n");
    	printf("---------------------------\n");
        printf("Nome: %s\n", aux->evento.nome);
        printf("Data: %s\n", aux->evento.data); 
        printf("Horario: %s\n", aux->evento.hora); 
        printf("---------------------------\n");
    } else {
  	  printf("Agenda Vazia.\n");
        
    }
}
 
  
  
 void criar_agenda (tipoCalendario *calendario){ 
     calendario->prim =NULL; 
     calendario->ult = NULL; 
     calendario->tam = 0;

 } 
  
  
void finalizar_evento(tipoCalendario *calendario) { 
    tipoNo *aux = calendario->prim; 

    if (aux) {
    	calendario->tam--;
        calendario->prim = aux->prox;
        printf("Evento Removido:\n");
        printf("%s\n", aux->evento.data);
        printf("%s\n", aux->evento.hora);
        printf("%s\n", aux->evento.nome);
        free(aux);
    } else {
        printf("Agenda Vazia\n");
    }
}

int quantificar_evento(tipoCalendario *calendario){
	return calendario->tam;
}


void modificar_evento(tipoCalendario *calendario, void *chavedata, void *chavehora) {
    tipoNo *aux = calendario->prim;
    int encontrado = 0;

    char *chaveStrdata = (char*)chavedata;
    char *chaveStrhora = (char*)chavehora;	
	
    while (aux) {
        if ((strcmp(aux->evento.data, chaveStrdata) == 0) || (strcmp(aux->evento.hora, chaveStrhora) == 0)) {
                printf("Digite o nome do evento: "); 
                scanf(" %[^\n]%*c", aux->evento.nome);
                printf("Digite a data do evento: ");  	 
                scanf(" %[^\n]%*c", aux->evento.data);
                printf("Digite a hora do evento: "); 
                scanf(" %[^\n]%*c", aux->evento.hora);
        }

    }
}
