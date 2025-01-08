import java.util.Scanner;

public class MediaColecoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        float soma = 0;
        int qnt = 0;
        while(num != -1){
            soma = 0;
            qnt = 0;
            while(num != -1){
                soma += num;
                qnt++;
                num = scan.nextInt();
            }
            soma = soma/qnt;
            System.out.printf("%.2f\n",soma);
            num = scan.nextInt();
        }
        scan.close();

    }    
}
