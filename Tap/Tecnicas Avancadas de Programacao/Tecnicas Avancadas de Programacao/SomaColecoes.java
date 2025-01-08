import java.util.Scanner;

public class SomaColecoes {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int vet[] = new int[100];
        int numero = scan.nextInt();
        scan.close();
        int i = 0;
        while(true){
            vet[i] = numero;
            i++;
            int verif = numero;
            numero = scan.nextInt();
            verif = verif + numero;
            if(verif == -2){
                break;
            }
        }
        int soma = 0;
        for(int j = 0; j < vet.length; j++){
            if(vet[j] != -1){
                soma = soma + vet[j];
            }else{
                System.out.printf("%d\n", soma);
                soma = 0;
            }
        }
    }
}
