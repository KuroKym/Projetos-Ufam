#include "stdio.h"
#include "stdlib.h"
#include "listaSE.h"


typedef struct medicao tipoMedicao;

struct medidor
{
	int hora, minuto;
	double temp;
};

criarMedicao( int hora, int min, double temp){
	tipoMedicao* m = malloc(sizeof(tipoMedicao));
	m->temp = temp;
	m->hora = hora;
	m->minuto = minuto;

	return m;
}

void imprimirMedicao(void* m){
	tipoMedicao *mm = m;
	printf("%d:%d %.2lf\n",mm->hora, mm->minuto, mm->temp);
}

int compararMedicao (void* m1, void* m2){
	tipoMedicao *mm1 = m1;
	tipoMedicao *mm2 = m2;

}

tipoMedicao* lerMedicao(){
	int hora, minuto;
	double temp;

	scanf("%d", &hora);
	if(hora < 0)
	scanf("%d", &minuto);
	scanf("%d", &temp);
	return criarMedicao(hora, minuto, temp);
}


int main(int argc, char const *argv[])
{

	tListaSE* medicoes = criarLista();
	short aindaTem = 1;
	while(aindaTem){
		tipoMedicao* nova = lerMedicao();
		if(nova){
			inserirNaLista(medicoes, nova);
		}
		else{
			aindaTem = 0;
		}
	}

	imprimirMedicao(medicoes);

	return 0;
}