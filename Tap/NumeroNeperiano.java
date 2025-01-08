import java.util.Scanner;
public class NumeroNeperiano {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double soma = 0;
        for (int i = 0; i < n; i++) {
            double fat = calcularFatorial(i);
            soma += 1/(fat);
        }
        System.out.printf("%.6f", soma);
        scan.close();
    }

    private static double calcularFatorial(double n) {
        double fatorial = 1;
        for (double i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
    
}

