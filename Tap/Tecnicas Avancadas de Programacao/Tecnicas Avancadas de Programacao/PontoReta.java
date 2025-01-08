import java.util.Scanner;

public class PontoReta {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        String[] values = input.split(" ");
        float x = Float.parseFloat(values[0]);
        float y = Float.parseFloat(values[1]);

        if (2 * x + y == 3) {
            System.out.printf("Ponto (%.1f, %.1f) pertence a reta 2x + y = 3.", x, y);
        } else {
            System.out.printf("Ponto (%.1f, %.1f) nao pertence a reta 2x + y = 3.", x, y);
        }
    }
}
