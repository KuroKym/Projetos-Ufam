import java.util.Scanner;
public class ValorExpoente {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = 0;
        int i = 1;
        while(n >= k){
            k += Math.pow(2, i);
            if(k>n){
                break;
            }
            else{
                i++;
            }

        }
        System.out.println(i);
        
        scan.close();

    }
}
