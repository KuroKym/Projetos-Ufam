#include <stdio.h> 
 #include "calendario.h" 
  
 int main() { 
     tipoCalendario calendario; 
     tipoEventos evento; 
     char continuar = 's'; 
     int selection = 0; 
  
     criar_agenda(&calendario); 
  
  
     while(selection >= 0 && selection <= 4){ 
         continuar = 's'; 
         printf("O que deseja fazer: \n"); 
         printf("----------------------------------\n"); 
         printf("1) Adicionar evento.\n"); 
         printf("2) Proximo evento.\n"); 
         printf("3) Finalizar evento\n"); 
         printf("4) Quantificar agenda.\n");
         printf("5) Modificar evento.\n"); 
         printf("Digite qualquer outra coisa para sair.\n"); 
         printf("----------------------------------\n"); 
  
         scanf("%d", &selection); 
  
         switch (selection) { 
         case 1:
            {
                 printf("Digite o nome do evento: "); 
                 scanf(" %[^\n]%*c", evento.nome); 
  
                 printf("Digite a data do evento (dd/mm/aaaa): "); 
                 scanf(" %[^\n]%*c", evento.data); 
  
                 printf("Digite o horario do evento (xx:xx) "); 
                 scanf(" %s", evento.hora); 
  
                 agendar_evento(&calendario, (void*)&evento); 
             break; 
                 }
  
         case 2: 
             {  
                proximo_evento(&calendario); 
             break; 
             } 
  
         case 3: 
             finalizar_evento(&calendario); 
             break; 
         case 4: 
             { 
                 printf("%d\n", quantificar_evento(&calendario)); 
                 break;
             } 
         case 5:
         {
            char chavedata[20];
            char chavehora[10];
            printf("Digite a data e hora do evento: (dd/mm/aaaa hh:mm)\n");
            scanf(" %s%*c %[^\n]%*c", chavedata, chavehora); 
            modificar_evento(&calendario, (void*)&chavedata, (void*)&chavehora);
             break; 
         }
         default: 
             return 0; 
         } 
     } 
  
     return 0; 
 }