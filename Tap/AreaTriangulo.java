import java.util.Scanner;
public class AreaTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        float s = (a + b + c)/2;
        if(a + b > c && a + c > b && b + c > a) {
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.err.printf("%.2f", area);
        }
        else{
            System.err.println("Triangulo invalido");
        }
        
        scan.close();
    }
}
