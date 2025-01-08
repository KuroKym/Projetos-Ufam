import java.util.Scanner;

public class Mediana {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double numeros[] = new double[100];
        double valor = scan.nextDouble();
        int i = 0;
        int tam = 0;
        while(valor != -1){
            numeros[i] = valor;
            i++;
            tam++;
            valor = scan.nextDouble();
        }
        scan.close();

        int meio = tam/2;
        double mediana = 0;
        if(tam%2 == 0){
            meio--;
            mediana = (numeros[meio] + numeros[meio+1])/2;
        }else{
            mediana = numeros[meio];
        }
        System.out.printf("%.1f\n", mediana);
   }
}
