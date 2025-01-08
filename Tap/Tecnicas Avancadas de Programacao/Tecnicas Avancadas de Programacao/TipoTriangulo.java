import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        if(Math.abs(b-c) < a && a < b + c && Math.abs(a-c) < b && b < a + c && Math.abs(a-b) < c && c < a + b){
            if(a == b && b == c){
                System.out.print("equilatero");
            }else if(a == b || a == c || b == c){
                System.out.print("isosceles");
            }else{
                System.out.print("escaleno");
            }
        }else{
            System.out.print("invalido");
        }
    }
}
