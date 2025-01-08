import java.util.Scanner;

public class NumeroNeperiano {
    static int fatorial(int num){
        if(num == 0){
            return 1;
        }else{
            return num*fatorial(num-1);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();

        double e = 0;
        for(int i = 0; i < num; i++){
            e = e + 1.0/fatorial(i);
        }
        System.out.printf("%.6f", e);
    }
}
