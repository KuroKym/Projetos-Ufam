import java.util.Scanner;
public class RotaOrtodromica {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double r = 6371;
        double t1 = scan.nextDouble();
        double t1rad = Math.toRadians(t1);
        double g1 = scan.nextDouble();
        double g1rad = Math.toRadians(g1);
        double t2 = scan.nextDouble();
        double t2rad = Math.toRadians(t2);
        double g2 = scan.nextDouble();
        double g2rad = Math.toRadians(g2);
        double acos = Math.acos((Math.sin(t1rad)* Math.sin(t2rad)) + (Math.cos(t1rad)* Math.cos(t2rad) * Math.cos(g1rad - g2rad)));
        double d = r*acos;

        System.out.printf("A distancia entre os pontos (%.6f, %.6f) e (%.6f, %.6f) e de %.2f km", t1, g1, t2, g2, d);
        scan.close();

    }
}
