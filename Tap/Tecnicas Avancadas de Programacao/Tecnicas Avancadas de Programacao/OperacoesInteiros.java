import java.util.Scanner;

public class OperacoesInteiros {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double vet[] = new double[100];
        double num = scan.nextDouble();
        int i = 0;
        double verif;
        while(true){
            vet[i] = num;
            i++;
            verif = num;
            num = scan.nextDouble();
            verif = verif + num;
            if(verif == -2){
                break;
            }
        }
        scan.close();

        int elementos = 0;
        int pares = 0;
        int impares = 0;
        double soma = 0;
        double media = 0;
        double maior = vet[0];
        double menor = vet[0];
        for(int j = 0; j<vet.length; j++){
            if(vet[j] != -1){
                elementos++;
                if(vet[j]%2 == 0){
                    pares++;
                }else{
                    impares++;
                }
                soma = soma + vet[j];
                if(maior < vet[j]){
                    maior = vet[j];
                }
                if(menor > vet[j]){
                    menor = vet[j];
                }
            }else{
                System.out.printf("%d\n", elementos);
                System.out.printf("%d\n", pares);
                System.out.printf("%d\n", impares);
                System.out.printf("%.0f\n", soma);
                media = soma/elementos;
                System.out.printf("%.2f\n", media);
                System.out.printf("%.0f\n", maior);
                System.out.printf("%.0f\n", menor);
                elementos = 0;
                pares = 0;
                impares = 0;
                soma = 0;
                media = 0;
                maior = vet[j+1];
                menor = vet[j+1];
            }
        }
    }
}
