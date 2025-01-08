import java.util.Scanner;
public class AproximacaoSeno {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = Math.toRadians(scan.nextDouble());
        double result = x;
        int n = scan.nextInt();
        double aux = 3;
        if (n == 1){
            System.out.println(x);
        }
        else{
            System.out.printf("%.10f\n", x);
            for (int i = 2; i <= n; i++) {
                double fat = calcularFatorial(aux);
                if((i % 2) == 0){
                    result -= (Math.pow(x, aux))/fat;
                }
                else{
                    result += (Math.pow(x, aux))/fat;
                }   
                System.out.printf("%.10f\n", result);
                aux+=2; 
            }
            
        }
        
        
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
