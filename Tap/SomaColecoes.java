import java.util.Scanner;

public class SomaColecoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int soma = 0;
        while(num != -1){
            soma = 0;
            while(num != -1){
                soma += num;
                num = scan.nextInt();
            }
            System.out.println(soma);
            num = scan.nextInt();
        }
        scan.close();

    }    
}
