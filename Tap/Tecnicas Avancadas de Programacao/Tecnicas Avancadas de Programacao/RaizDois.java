import java.util.Scanner;

public class RaizDois {
    static double FracoesContinuas(int contador){
        if(contador == 0){
            return 1;
        }else{
            return 1/(2+FracoesContinuas(contador-1));
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();

        for(int i = 1; i <= num; i++){
            System.out.printf("%.14f\n", 1+FracoesContinuas(i));
        }
    }
}
