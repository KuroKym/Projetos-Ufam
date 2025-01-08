import java.util.Scanner;
public class OperacoesInteiros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num  = scan.nextInt();
        int vetor[] = new int[50];
        
        
        
        while(num != -1){
            int tam = 0;
            int i = 0;
            while(num != -1) {
                vetor[i] = num;
                num = scan.nextInt();
                tam++;
                i++;
            }
            int sum = 0;
            int par = 0;
            int impar = 0;
            int maior = 0;
            int menor = vetor[0];
            for(i = 0; i < tam; i++) {
                sum += vetor[i];
                if(vetor[i] > maior){
                    maior = vetor[i];
                }
                if (vetor[i] < menor){
                    menor = vetor[i];
                }
                if ((vetor[i] % 2) == 0){
                    par++;
                }
                else {
                    impar++;
                }
            }
            double media = (double)sum/tam;
            System.out.println(tam);
            System.out.println(par);
            System.out.println(impar);
            System.out.println(sum);
            System.out.printf("%.2f\n", media);
            System.out.println(maior);
            System.out.println(menor);
            num = scan.nextInt();

        }

        scan.close();
    }   
}
