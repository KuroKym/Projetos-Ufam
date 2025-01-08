import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int vetRespostas[] = new int[100];
        int vetGabarito[] = new int[100];

        int resposta = scan.nextInt();
        int a = 0;
        double tamanho = 0;
        while(resposta != -1){
            vetRespostas[a] = resposta;
            a++;
            resposta = scan.nextInt();
            tamanho++;
        }
        int b = 0;
        int gabarito = scan.nextInt();
        while(gabarito != -1){
            vetGabarito[b] = gabarito;
            b++;
            gabarito = scan.nextInt();
        }
        scan.close();

        double acertos = 0;
        for(int i = 0; i < tamanho; i++){
            if (vetRespostas[i] == vetGabarito[i]){
                acertos++;
            }
        }
        double media = (acertos/tamanho)*100;
        System.out.printf("%.2f", media);
    }
}             