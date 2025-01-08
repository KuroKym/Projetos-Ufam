import java.util.Scanner;

public class VolumeCombustivel {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      try{
        double ha = scan.nextDouble();
        double hc = scan.nextDouble();
        double r = scan.nextDouble();
        double pi = Math.PI;
        double v = -1.000;

        if(ha < hc){
            System.err.printf("%.3f", v);
        }
        else if(hc < r){
            double x = hc;
            v = (pi/3.0)*Math.pow(x, 2)*(3*r - x);
            System.out.printf("%.3f\n", v);
        }
        else if(hc == r){
            v = (4.0/3.0)* pi*Math.pow(r, 3);
            v = v/2.0;
            System.out.printf("%.3f\n", v);
        }
        else if(hc > r){
            hc = hc - r;
            v = ((4.0/3.0)* pi)*Math.pow(r, 3);
            v = v/2.0;
            double vcilindro = pi*Math.pow(r, 2)*hc;
            v = v + vcilindro;
            System.out.printf("%.3f\n", v);
        }
        

      }

      finally {
        if(scan != null){
            scan.close();
            }
        }
    }
}
