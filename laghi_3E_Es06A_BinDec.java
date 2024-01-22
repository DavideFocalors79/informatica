import java.util.Scanner;
public class laghi_3E_Es06A_BinDec {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String num = "";

        boolean flagByte = true;

        int decimale = 0;
        char bit;
        int posizione;

        System.out.println("Inserisci un numero binario");
        num = keyboard.nextLine();

        for (int i = 0; i < num.length(); i++){
            if (!(num.charAt(i) == '1' || num.charAt(i) == '0')) {
                flagByte = false;
            }

            else {
                System.out.println(num.charAt(i));
                bit = num.charAt(i);
                posizione = bit - '0';
                decimale = decimale * 2 + posizione;

        }

        if (flagByte)
            System.out.println("Il numero binario inserito in decimale vale: " +decimale);

        else
            System.out.println("Non hai inserito un numrero binario.");

        System.out.println("Fine programma");

    }
}

