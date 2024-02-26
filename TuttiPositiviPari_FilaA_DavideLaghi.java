import java.util.Scanner;
@SuppressWarnings("ALL")
public class TuttiPositiviPari {
    public static void main(String[] args) {
        // Dichiarazione di scanner e variabili
        Scanner tastiera = new Scanner(System.in);
        boolean k = true;

        System.out.println("Quanti numeri interi vuoi inserire?");
        int quantNumeri = tastiera.nextInt();

        int[] numeri = new int[quantNumeri];

        System.out.println("Inserisci i numeri interi:");

        // riempie il vettore ed esegue il controllo
        k = inserimentoControllo(numeri,tastiera);

        if (k) { // se k è vera
            System.out.println("Tutti positivi e pari");// quindi se tutte le posizioni
        }// soddisfano la richiesta, allora stampa "Tutti positivi e pari"

        else {
            System.out.println("NO");
        }
    }
    private static boolean inserimentoControllo(int[] Array,Scanner tastiera){

        boolean k=true;
        for (int i = 0; i < Array.length; i++) {

            Array[i] = tastiera.nextInt();

            if (Array[i] % 2 == 1 && Array[i] < 0) {
                k = false; // k diventa falsa
            }
        }

        return k;
    }
}