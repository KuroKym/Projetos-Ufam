import java.util.Scanner;

public class AproximacaoPi{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double pi = 3.0;
        double num = 1;
        double numj = 2;
        if(n == 1){
            System.out.printf("%.6f\n", pi);
        }
        else{
            System.out.printf("%.6f\n", pi);
            for (int i = 2; i <= n; i++) {
                
                num = 1;
                for(int j = 0; j < 3; j++) {
                    num = num * numj;
                    numj++;
                }
                numj--;
                if((i % 2) == 0){
                    pi += 4.0/num;
                }
                else{
                    pi -= 4.0/num;
                }   
                System.out.printf("%.6f\n", pi); 
            }
            
        }
        scan.close();
    }
}