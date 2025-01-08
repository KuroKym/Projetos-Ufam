import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int soma = 0;
        while (num != 0) {
            soma += num % 10;
            num /= 10;
        }

        System.err.println(soma);

        scan.close();
    }    
}
