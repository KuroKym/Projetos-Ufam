import java.util.Scanner;

public class Desconto {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float valor = scan.nextFloat();
        scan.close();

        if(valor >= 200){
            System.out.printf("%.2f", valor*0.95);
        }else{
            System.out.print(valor);
        }
    }
}
