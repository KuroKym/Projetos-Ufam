import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int linha = scan.nextInt();

        for (int i = 1; i <= linha; i++) {
            for (int j = 0; j < linha; j++) {
                if (i % 2 == 0) {
                    System.out.print(" *");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        scan.close();
    }
}
