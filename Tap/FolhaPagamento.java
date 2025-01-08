import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double valorHora = scan.nextDouble();
        int horas = scan.nextInt();
        double salario = valorHora * horas;
        double ir = 0.11 * salario;
        double inss = 0.08 * salario;
        double descontos = ir + inss;
        double total = salario - descontos;

        System.out.printf("Salario bruto: R$%.2f\n", salario);
        System.out.printf("IR: R$%.2f\n", ir);
        System.out.printf("INSS: R$%.2f\n", inss);
        System.out.printf("Total de descontos: R$%.2f\n", descontos);
        System.out.printf("Salario liquido: R$%.2f\n", total);
        scan.close();
    }
    
}
