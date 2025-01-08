import java.util.Scanner;

public class AreaPoligono {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double vetx[] = new double[100];
        double vety[] = new double[100];

        double num1 = scan.nextDouble();
        int i = 0;
        int tamanho = 0;
        while(num1 != -1){
            vetx[i] = num1;
            i++;
            tamanho++;
            num1 = scan.nextDouble();
        }

        double num2 = scan.nextDouble();
        int j = 0;
        while(num2 != -1){
            vety[j] = num2;
            j++;
            num2 = scan.nextDouble();
        }
        scan.close();

        double soma = 0;
        for(int k = 0; k < tamanho-1; k++){
            soma = soma + (vetx[k+1]+vetx[k])*(vety[k+1]-vety[k]);
        }
        
        double area = Math.abs(soma)/2;
        System.out.printf("%.4f\n", area);
    }
}
