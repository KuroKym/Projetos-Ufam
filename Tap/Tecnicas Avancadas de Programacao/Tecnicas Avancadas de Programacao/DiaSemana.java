import java.util.Scanner;

public class DiaSemana{
    
    static int horasDia(int vet[], int dia, int tamVet){
        int soma = 0;
        for(int cont = dia; cont<tamVet; cont = cont + 7){
            soma = soma + vet[cont];
        }
        return soma;
    }
    static int diaMaisCheio(int vet[]){
        int maior = vet[0];
        for(int i = 0; i < 7; i++){
            if(maior < vet[i]){
                maior = vet[i];
            }
        }
        return maior;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int horas[] = new int[100];
        int diasSemana[] = {0,0,0,0,0,0,0};
        int res[] = {0,0,0,0,0,0,0};
        int hora = scan.nextInt();
        int i = 0;
        while(hora != -1){
            horas[i] = hora;
            hora = scan.nextInt();
            i++;
        }

        scan.close();

        for(int j = 0; j < 7; j++){
            diasSemana[j] = horasDia(horas, j, i);
        }

        int maior = diaMaisCheio(diasSemana);
        int cont = 0;
        int k = 0;
        for(int l = 0; l < 7; l++){
            if(maior == diasSemana[l]){
                res[k] = l;
                cont++;
                k++;
            }
        }

        for(int p = 0; p < cont; p++){
            System.out.printf("%d\n", res[p]+1);
        }
    }
}
