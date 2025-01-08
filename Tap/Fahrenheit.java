import java.util.Scanner;

public class Fahrenheit{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double celcius = scan.nextDouble();
        double fahrenheit = ((9*celcius)/5)+32;
        System.out.println(fahrenheit);
        scan.close();
    }
}