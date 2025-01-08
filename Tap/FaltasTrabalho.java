import java.util.Scanner;

public class FaltasTrabalho {
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
            float[] dia = new float[7];
            int falta = scan.nextInt();
            int totalFaltas = 0;

            while (falta != -1) {
                dia[falta - 2]++;  // Ajuste do índice para começar em 0
                totalFaltas++;
                falta = scan.nextInt();
            }

            for (int i = 0; i < 6; i++) {
                float percentual = (dia[i] / totalFaltas) * 100;
                System.out.printf("%.1f ", percentual);
            }

            System.out.println();

        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }
}
