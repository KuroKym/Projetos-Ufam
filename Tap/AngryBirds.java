import java.util.Scanner;

public class AngryBirds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v0 = Math.abs(scan.nextInt());
        double ang = Math.toRadians(scan.nextInt());
        double d = scan.nextDouble();
        double g = 9.8;
        double r = (Math.pow(v0, 2) * Math.sin(2*ang))/g;
        if(Math.abs(r-d) < 0.1){
            System.err.println("1");
        }
        else{
            System.out.println("0");
        }

        scan.close();
    }
}
