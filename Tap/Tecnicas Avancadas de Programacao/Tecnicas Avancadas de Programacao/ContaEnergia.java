import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int consumo = scan.nextInt();
        char tipo = scan.next().charAt(0);
        scan.close();

        if(consumo < 0){
            System.out.print(-1.00);
        }else{
            if(tipo == 'R'){
                if(consumo <= 500){
                    double total = consumo*0.4;
                    System.out.printf("%.2f", total);
                }else{
                    double total = consumo*0.65;
                    System.out.printf("%.2f", total);
                }
            }else if(tipo == 'C'){
                if(consumo <= 1000){
                    double total = consumo*0.55;
                    System.out.printf("%.2f", total);
                }else{
                    double total = consumo*0.6;
                    System.out.printf("%.2f", total);
                }
            }else if(tipo == 'I'){
                if(consumo <= 5000){
                    double total = consumo*0.55;
                    System.out.printf("%.2f", total);
                }else{
                    double total = consumo*0.6;
                    System.out.printf("%.2f", total);
                }
            }else{
                System.out.print(-1.00);
            }
        }
    }
}
