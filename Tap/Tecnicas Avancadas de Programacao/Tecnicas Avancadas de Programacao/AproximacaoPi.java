import java.util.Scanner;

public class AproximacaoPi{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        scan.close();

        double pi = 3;
        int a = 2;
        for(int i = 0; i < numero; i++){
            if(i == 0){
                System.out.printf("%.6f\n", pi);
            }else if(i%2 != 0){
                pi = pi + 4.0/(a*(a+1)*(a+2));
                System.out.printf("%.6f\n", pi);
                a = a + 2;
            }else{
                pi = pi - 4.0/(a*(a+1)*(a+2));
                System.out.printf("%.6f\n", pi);
                a = a + 2;
            }
        }
    }
}