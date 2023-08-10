#include "stdio.h"
#include "stdlib.h"
#include "listase.h"

typedef struct evento{
	char tempo[21];
	char descricao[141];
	char prioridade[11];
}t_evento;


typedef struct agenda{
	t_lse *eventos;
	
}t_agenda;


/* void proximo_evetno(void* e){
	t_evento* ee = e;
	printf("%s", ee->descricao);
	printf("%s", ee->tempo);
} */

void imprimir_evento(void* evento){
	t_evento* e = evento;
	char  data[11];
	char hora[6];
	sscanf(e->tempo, "%s %s", data, hora);
	printf("%s\n",data);
	printf("%s\n",hora);
	
}

int comparar_evento(void* cargaLista, void* carga){
	t_evento* e1 = cargaLista;
	t_evento* e2 = carga;
	
	// dd/mm/aaaa hh:mm

	char tempo1[21] = e1->tempo;
	char tempo2[21] = e2->tempo;

	int dia1, mes1, ano1, hora1, minuto1;
	int dia2, mes2, ano2, hora2, minuto2;

	sscanf(tempo1,"%d/%d/%d %d:%d", &dia1, &mes1, &ano1, &hora1, &minuto1);
	sscanf(tempo2,"%d/%d/%d %d:%d", &dia2, &mes2, &ano2, &hora2, &minuto2);

	if(ano1 != ano2){
		return ano2 - ano1;
	}
	else if(mes1 != mes2){
		return mes2 - mes1;
	}
	else if(dia1 != dia2){
		return dia2 - dia1;
	}
	else if(hora1 != hora2){
		return hora2 - hora1;
	}
	else{
		return minuto2 - minuto1;
	}
	
}

t_evento* criar_evento(char info[]){
	t_evento* novo = malloc(sizeof(t_evento));
	sscanf(info, "%s %s" ,novo->tempo, novo ->descricao, novo->prioridade);
	return novo;
}

t_agenda* criar_agenda(t_imprimir_lse imprimir, t_comparar_lse comparar){
	t_agenda *agenda = malloc(sizeof(t_agenda));
	agenda->eventos = criar_lse(imprimir,comparar);

	return agenda;
} 

void agendar_evento(t_agenda* agenda, t_evento* evento){
	inserir_conteudo_lse(agenda, evento);
}

t_evento* ler_evento(void* info){
	t_evento* e1 = info;
	sscanf()
	return evento;
}

int main(int argc, char const *argv[])
{
	t_agenda* agenda = criar_agenda(imprimir_evento, comparar_evento);
	int op;
	char resto[300];
	scanf("%d %s", &op, resto);
	
	if(op == 1) {
		agendar_evento(agenda, ler_evento(resto));
	}

	return 0;
}
