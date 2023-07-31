#include <stdio.h>
#include "calendario.h"

int main() {
    tipoCalendario calendario;
    tipoEventos evento;
    char continuar = 's';
    int selection = 0;
    
    inicializaCalendario(&calendario);


    while(selection >= 0 && selection <= 4){
        continuar = 's';
        printf("O que deseja fazer: \n");
        printf("----------------------------------\n");
        printf("1) Adicionar evento.\n");
        printf("2) Localizar evento.\n");
        printf("3) Exibir todos os eventos\n");
        printf("4) Remover evento\n");
        printf("Digite qualquer outra coisa para sair.\n");
        printf("----------------------------------\n");

        scanf("%d", &selection);

        switch (selection) {
        case 1:
            while (continuar == 'S' || continuar == 's') {
                printf("Digite o nome do evento: ");
                scanf(" %[^\n]%*c", evento.nome);

                printf("Digite a data do evento (dd/mm/aaaa): ");
                scanf(" %[^\n]%*c", evento.data);

                printf("Digite o horario do evento (xx:xx) ");
                scanf(" %s", evento.hora);

                adicionaEvento(&calendario, (void*)&evento);

                printf("Deseja adicionar outro evento? (S/N): ");
                scanf(" %c%*c", &continuar);
            }
            break;

        case 2:
            {
                char chave[40];
                printf("---------------------------\n");
                printf("Digite o nome, data ou hora do evento: ");
                scanf(" %39[^\n]%*c", chave);
                localizarEvento(&calendario, (void*)chave);
            }
            break;

        case 3:
            exibirEvento(&calendario);
            break;
        case 4:
            {
                char chave[40];
                printf("---------------------------\n");
                printf("Digite a data ou hora do evento: ");
                scanf(" %39[^\n]%*c", chave);
                removeEvento(&calendario, (void*)chave);
            }
            break;
        default:
            return 0;
        }
    }

    return 0;
}
