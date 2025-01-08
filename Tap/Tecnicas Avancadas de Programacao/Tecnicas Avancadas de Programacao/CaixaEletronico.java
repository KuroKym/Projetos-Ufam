import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.close();

        if (num < 0 || num%2 != 0){
            System.out.println("Valor invalido");
        }else{
            int notasCinquenta = num/50;
            int notasDez = (num%50)/10;
            int notasDois = ((num%50)%10)/2;
            System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2", notasCinquenta, notasDez, notasDois);
        }
        
    }
}