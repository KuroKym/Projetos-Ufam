import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int raio = scan.nextInt();
        int altura = scan.nextInt();
        int opcao = scan.nextInt();
        scan.close();

        double esfera = (4.0/3)*Math.PI*raio*raio*raio;
        double calota = (Math.PI/3)*altura*altura*(3*raio-altura); 

        if(opcao == 1){
            System.out.printf("%.4f", calota);
        }else{
            System.out.printf("%.4f", esfera-calota);
        }
    }
}