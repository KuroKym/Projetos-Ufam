import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        if(Math.abs(y-z)< x && x < (y + z)){
            if(x == y && y == z){
                System.out.println("equilatero");
            }
            else if(x == y || y == z || x == z){
                System.out.println("isosceles");
            }
            else{
                System.out.println("escaleno");
            }
        }
        else{
            System.out.println("invalido");
        }
        
        
        scan.close();
    }    
}