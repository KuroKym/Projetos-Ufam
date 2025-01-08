import java.util.Scanner;
public class Desconto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double valor = scan.nextDouble();
        if(valor > 200.00){
            double desconto = valor * 0.05;
            valor -= desconto;
        }
        System.out.printf("%.2f", valor);
        scan.close();
    }
    
}
