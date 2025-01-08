import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pi = Math.PI;
        double r = scan.nextDouble();
        double x = scan.nextDouble();
        int op = scan.nextInt();
        double volume = (pi/3)*Math.pow(x, 2)*(3*r-x);

        if(op == 1){
            System.out.printf("%.4f\n", volume);
        }
        else if(op == 2){
            double volume_raio = (4.0/3.0)*pi*Math.pow(r, 3);
            volume = Math.abs(volume_raio - volume);
            System.out.printf("%.4f\n", volume);
        }


        scan.close();
    }    
}
