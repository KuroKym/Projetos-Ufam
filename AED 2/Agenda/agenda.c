#include "stdio.h"
#include "stdlib.h"
#include "listase.h"

typedef struct evento{
	char tempo[20];
	char descricao[100];
	char prioridade[10];
}t_evento;


typedef struct agenda{
	t_listase *eventos;
	
}t_agenda;

t_agenda* criar_agenda(t_imprimir_agenda imprimir, t_comparar_agenda comparar){
	t_agenda *agenda = malloc(sizeof(t_agenda));
	agenda->eventos = criar_lse(NULL, NULL);

	return agenda;
}

void agendar_evento(t_agenda* agenda, t_evento* evento){
	inserir_conteudo_lse(agenda, evento);
}


int int main(int argc, char const *argv[])
{
	do{
		scanf("%d", &cmd);
		switch(cmd){
		case 1:
			agendar_evento()
			break;
		}
	}

	return 0;
}
