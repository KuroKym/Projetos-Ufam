import java.util.Scanner;

public class DataExtenso {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        int dia = Integer.parseInt(data.substring(0, 2));
        String mes = data.substring(2, 4);
        String mex = "null";
        switch (mes) {
            case "01":
                mex = "janeiro";
                break;
            case "02":
                mex = "fevereiro";
                break;
            case "03":
                mex = "marco";
                break;
            case "04":
                mex = "abril";
                break;
            case "05":
                mex = "maio";
                break;
            case "06":
                mex = "junho";
                break;
            case "07":
                mex = "julho";
                break;
            case "08":
                mex = "agosto";
                break;
            case "09":
                mex = "setembro";
                break;
            case "10":
                mex = "outubro";
                break;
            case "11":
                mex = "novembro";
                break;
            case "12":
                mex = "dezembro";
                break;
            default:
                break;
        }

        int ano = Integer.parseInt(data.substring(4, 8));
        System.out.printf("%d de %s de %d", dia, mex, ano);


        scan.close();
    }
}
