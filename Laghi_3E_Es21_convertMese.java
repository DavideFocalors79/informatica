import java.util.Scanner;

public class Laghi_3E_Es21_convertMese {
    public static void main(String[] args) {

        String mese;
        Scanner Tastiera = new Scanner(System.in);

        System.out.println("Inserisci il mese");
        mese = Tastiera.next().toLowerCase();

        System.out.println("Il corrispondente numero e' "+intToStrMese(mese));
    }


    private static int intToStrMese(String mese)
    {

        int num = switch(mese)
        {
            case "gennaio" -> 1;
            case "febbraio" -> 2;
            case "marzo" -> 3;
            case "aprile" -> 4;
            case "maggio" -> 5;
            case "giugno" -> 6;
            case "luglio" -> 7;
            case "agosto" -> 8;
            case "settembre" -> 9;
            case "ottobre" -> 10;
            case "novembre" -> 11;
            case "dicembre" -> 12;
            default -> -1;
        };

        return num;
    }
}