import java.util.Scanner;

public class TimeFutebol {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int GolsTime1[] = new int[100];
        int GolsTime2[] = new int[100];

        int gols = scan.nextInt();
        int i = 0;
        int tamanho = 0;
        while(gols != -1){
            GolsTime1[i] = gols;
            i++;
            tamanho++;
            gols = scan.nextInt();
        }

        int j = 0;
        gols = scan.nextInt();
        while(gols != -1){
            GolsTime2[j] = gols;
            j++;
            gols = scan.nextInt();
        }
        scan.close();

        int vitorias = 0;
        int empates = 0;
        int derrotas = 0;
        for(int k = 0; k < tamanho; k++){
            if(GolsTime1[k] > GolsTime2[k]){
                vitorias++;
            }else if (GolsTime1[k] == GolsTime2[k]){
                empates++;
            }else{
                derrotas++;
            }
        }
        System.out.printf("%d %d %d", vitorias, empates, derrotas);
    }
}
