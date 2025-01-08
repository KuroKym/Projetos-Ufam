import java.util.Scanner;

public class DistanciaAviao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            int[][] tempos = {
                {0, 2, 11, 6, 15, 11, 1},
                {2, 0, 7, 12, 4, 2, 15},
                {11, 7, 0, 11, 8, 3, 13},
                {6, 12, 11, 0, 10, 2, 1},
                {15, 4, 8, 10, 0, 5, 13},
                {11, 2, 3, 2, 5, 0, 14},
                {1, 15, 13, 1, 13, 14, 0}
            };
            int sum = 0;
            int ant =scan.nextInt();
            ant = (ant %10) -1;
            int entrada = scan.nextInt();
            entrada = (entrada % 10) - 1;
            while (entrada > -1){
                sum += tempos[entrada][ant];
                ant = entrada;
                entrada = scan.nextInt();
                entrada = (entrada % 10) - 1;
            }
            System.out.println(sum);
        }

        finally{
            if(scan!= null){
                scan.close();
            }
        }

    }
}
