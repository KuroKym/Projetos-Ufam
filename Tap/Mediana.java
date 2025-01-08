import java.util.Arrays;
import java.util.Scanner;

public class Mediana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        String input = scan.nextLine();
        scan.close();
        String[] numerosStr = input.split(" ");
        int tam = numerosStr.length-1;
        int[] vetor = new int[tam];

        for(i = 0; i < tam; i++){
            if(Integer.parseInt(numerosStr[i]) != -1){
                vetor[i] = Integer.parseInt(numerosStr[i]);
            }
            else{
                break;
            }
        }
        Arrays.sort(vetor);
        double mediana;
        if (tam % 2 == 0) {
            int n1 = vetor[(tam / 2)-1];
            int n2 = vetor[(tam / 2)];
            mediana = (n1+n2)/2.0;
        }
        else{
            int n1 = vetor[((tam + 1)/ 2)-1];
            mediana = n1;
        }
        System.out.println(mediana);
    }    
}
