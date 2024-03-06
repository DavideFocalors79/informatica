//Davide Laghi 3E

import java.util.Scanner;

public class DueSequenze {
    public static void main(String[] args) {
        //Davide Laghi 3E
        //dichiarazione varibaili
        Scanner FilippoGiatti = new Scanner(System.in);
        int[] primaSequenza = new int[5];
        int[] secondaSequenza = new int[5];
        boolean numeroUguale;

        System.out.println("Inserisci i 5 numeri della prima sequenza\n");

        //richiamo metodo per riempire gli array
        riempimentoArray(primaSequenza,FilippoGiatti);

        System.out.println("Inserisci i 5 numeri della seconda sequenza\n");

        //richiamo metodo per riempire gli array
        riempimentoArray(secondaSequenza,FilippoGiatti);

        //richiamo metodo per il controllo dei numeri uguali nei due array
        numeroUguale=controlloArray(primaSequenza,secondaSequenza);

        //stampa se ci sono numeri uguali
        if(numeroUguale==true) {
            System.out.println("OK\n");
        }else {
            System.out.println("NO\n");
        }
    }
    private static void riempimentoArray(int[] Array,Scanner FilippoBarchi){//metodo di riempimento dell'array

        for(int i=0;i<Array.length;i++){
            Array[i]=FilippoBarchi.nextInt();
        }
    }
    private static boolean controlloArray(int[] Array1,int[] Array2){//metodo per controllare se ci sono numeri uguali nei due array
        boolean numeroUguale=false;
        for(int i=0;i<Array1.length;i++){
            for(int k=0;k<Array2.length;k++){
                if(Array1[i] == Array2[k]){
                    numeroUguale=true;
                }
            }
        }
        return numeroUguale;
    }
}