import java.util.Scanner;
public class ParImpar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num != -1){
            if (num % 2 == 0) {
                System.out.println("Par");
            } else {
                System.out.println("Impar");
            }
            num = scan.nextInt();
        }
        scan.close();
    }
}
