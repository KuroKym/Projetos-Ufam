import java.util.Scanner;

public class AproximacaoSeno{
    static double fatorial(double numero){
        if(numero == 0){
            return 1;
        }else{
            return numero*fatorial(numero-1);
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int angulo = scan.nextInt();
        int termos = scan.nextInt();
        scan.close();

        double anguloRad = Math.toRadians(angulo);
        double seno = 0;
        double a = 1;
        for(int i = 0; i < termos; i++){
            if(i == 0){
                seno = anguloRad;
                System.out.printf("%.10f\n", seno);
                a = a + 2;
            }else if(i%2 != 0){
                seno = seno - Math.pow(anguloRad, a)/fatorial(a);
                a = a + 2;
                System.out.printf("%.10f\n", seno);
            }else{
                seno = seno + Math.pow(anguloRad, a)/fatorial(a);
                a = a + 2;
                System.out.printf("%.10f\n", seno);
            }
        }
    }
}