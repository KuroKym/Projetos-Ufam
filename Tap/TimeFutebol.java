import java.util.Scanner;

public class TimeFutebol {
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
            int i = 0;
            int vitorias = 0;
            int derrotas = 0;
            int empates = 0;
            int[] time1 = new int[20];
            int[] time2 = new int[20];
            int num = scan.nextInt();
            int tam = 0;
            while(num != -1){
                time1[i] = num;
                num = scan.nextInt();
                i++;
                tam++;

            }
            i = 0;
            num = scan.nextInt();
            while(num != -1){
                time2[i] = num;
                num = scan.nextInt();
                i++;
            }

            for(i = 0; i < tam; i++){
                if(time1[i] > time2[i]){
                    vitorias++;
                }
                else if(time1[i] < time2[i]){
                    derrotas++;
                }
                else{
                    empates++;
                }
            }
            System.out.printf("%d %d %d\n", vitorias, empates, derrotas);
        }
        finally {
            if(scan != null){
                scan.close();
            }
        }
    }
}
