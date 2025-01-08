import java.util.Scanner;

public class VolumeCombustivel {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int alturaTotal = scan.nextInt();
        int alturaComb = scan.nextInt();
        int raio = scan.nextInt();
        scan.close();
        double pi = Math.PI;

        if(alturaTotal < 0 || alturaComb < 0 || raio < 0){
            System.out.print(-1.000);
        }else{
            if(alturaComb <= raio){
                double volume = (pi/3)*alturaComb*alturaComb*(3*raio-alturaComb);
                System.out.printf("%.3f", volume);
            }else if(alturaComb > raio && alturaComb < alturaTotal - raio){
                double volume = (2.0/3)*pi*raio*raio*raio + pi*raio*raio*(alturaComb-raio);
                System.out.printf("%.3f", volume);
            }else{
                double volume = (4.0/3)*pi*raio*raio*raio + pi*raio*raio*(alturaTotal-2*raio)-((pi/3)*(alturaTotal-alturaComb)*(alturaTotal-alturaComb)*(3*raio-(alturaTotal-alturaComb)));
                System.out.printf("%.3f", volume);
            }
        }
    }
}
