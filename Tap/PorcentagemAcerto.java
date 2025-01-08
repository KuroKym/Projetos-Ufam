import java.util.Scanner;
public class PorcentagemAcerto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int res[]= new int[50];
        int gab[]= new int[50];
        int n = scan.nextInt();
        int i = 0;
        while(n != -1) {
            res[i] = n;
            n = scan.nextInt();
            i++;
        }
        n = scan.nextInt();
        i = 0;
        while(n != -1) {
            gab[i] = n;
            n = scan.nextInt();
            i++;
        }
        double acertos = 0;
        for(int k = 0; k < i; k++) {
            if(res[k] == gab[k]) {
                acertos++;
            }
        }
        double porc = acertos / i *100;
        System.out.printf("%.2f", porc);
        scan.close();
    }
}
