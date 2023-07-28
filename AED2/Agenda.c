#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tipoEventos{
	char nome[40];
	int dia, mes, ano;
	int hora, minuto;

} tipoEventos;

typedef struct tipoNo{
	tipoEventos evento; 
	struct tipoNo *prox;
	struct tipoNo *ant;
} tipoNo;

typedef struct tipoCalendario{
	tipoNo *prim;
	tipoNo *ult;
} tipoCalendario;


void inicializarCalendario(tipoCalendario *calendario) {
    calendario->prim = NULL;
    calendario->ult = NULL;
}

void adicionaEvento(tipoCalendario *calendario, tipoEventos evento){
	tipoNo *aux = (tipoNo*)malloc(sizeof(tipoNo));

	if(!aux){
		printf("Erro ao alocar memoria para o evento.");
		return;
	}

	aux->evento = evento;
	aux->prox = NULL;
	aux->ant = calendario->ult;

	if(!calendario->prim){
		calendario->prim = aux;
	}
	else{
		calendario->ult->prox = aux;
	}
	calendario->ult = aux;
}

/*void exibirEvento(tipoCalendario *calendario){
	tipoNo *aux = calendario->prim;
	int cont = 1;

	while(aux){
		printf("Evento %d\n", cont);
		printf("Nome: %s\n", aux->evento.nome);
		printf("Data: %d/%d/%d\n", aux->evento.dia, aux->evento.mes, aux->evento.ano);
		printf("Horario: %d:%d\n", aux->evento.hora, aux->evento.minuto);
		printf("\n");

		aux = aux->prox;
		cont++;
	}
}*/
void localizarEvento(tipoCalendario *calendario, char *chave) {
    tipoNo *aux = calendario->prim;
    int encontrado = 0;

    while (aux) {
        if (strcmp(aux->evento.nome, chave) == 0) {
        	printf("---------------------------\n");
            printf("Evento encontrado:\n");
            printf("Nome: %s\n", aux->evento.nome);
            printf("Data: %02d/%02d/%d\n", aux->evento.dia, aux->evento.mes, aux->evento.ano);
            printf("Horario: %02d:%02d\n", aux->evento.hora, aux->evento.minuto);
            printf("---------------------------\n");
            encontrado = 1;
            break;
        }

        aux = aux->prox;
    }

    if (!encontrado) {
        printf("Evento \"%s\" nao foi encontrado.\n", chave);
    }
}


int main(){

	tipoCalendario calendario;
	tipoEventos evento;
	char continuar = 's';

	inicializarCalendario(&calendario);

	while(continuar == 'S' || continuar == 's'){
		printf("Digite o nome do evento: ");
		scanf("%[^\n]%*c", evento.nome);

		printf("Digite o dia, mes e ano: ");
		scanf("%d %d %d", &evento.dia, &evento.mes, &evento.ano);

		printf("Digite o horario em hora e minuto: ");
		scanf("%d %d", &evento.hora, &evento.minuto);

		adicionaEvento(&calendario, evento);

		printf("Deseja adicionar outro evento? (S/N): ");
		scanf(" %c%*c", &continuar);
	}

	printf("Deseja localizar um evento? (S/N): ");
	scanf( "%c%*c", &continuar);

	if(continuar == 's' || continuar == 'S'){
		char chave[40];
		printf("---------------------------\n");
		printf("Digite o nome do evento: ");
		scanf("%39[^\n]%*c", chave);
		localizarEvento(&calendario, chave);
	}

	return 0;
}
