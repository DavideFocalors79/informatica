import java.util.Scanner;

public class Laghi_3E_Es22_PrendiParola {
    public static void main(String[] args) {
        String input;
        String[] parole = new String[0];
        Scanner keyboard = new Scanner(System.in);


        System.out.println("Inserisci una stringa di parole: ");
        input = keyboard.nextLine();

        parole=dividiParole(parole, input);

        printParole(parole);
    }

    private static String[] aggiungiPosArray(String[] vettore1) {

        String[] vettore2 = new String[vettore1.length + 1];

        for(int i=0;i<vettore1.length;i++)
        {
            vettore2[i] = vettore1[i];
        }

        return vettore2;
    }


    private static String[] dividiParole(String[] vettore1, String input) {

        int iStart = 0, iEnd;

        do {

            if (input.charAt(iStart) != ' ') {
                iEnd = iStart;
                while (input.charAt(iEnd) != ' ' && iEnd<input.length()-1)
                    iEnd++;
                vettore1=aggiungiPosArray(vettore1);
                vettore1[vettore1.length - 1] = input.substring(iStart, iEnd+1);


                iStart = iEnd + 1;
            } else
                iStart++;
        } while (iStart < input.length());

        return vettore1;
    }


    private static void printParole(String[] vettore1) {
        for (int i = 0; i < vettore1.length; i++) {
            System.out.println("parola "+(i + 1) + ":" + vettore1[i]);
        }
    }
}