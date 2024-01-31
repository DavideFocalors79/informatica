import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] Args) {
        int scelta,dim=0;
        boolean s1=false,s2=false,s3=false,s4=false,s5=false;
        int cont1=0,cont2,cont3,cont4,cont5;
        int sceltapuntata=0;
        int[] NumUtente=new int[5];
        Scanner tastiera = new Scanner(System.in);

        String[] opzioni = {"=== Gioco Lotto === ",
                "Su quante ruote vuoi giocare?",
                "[1] Una ruota",
                "[2] Dieci ruote",
                "[3] Esci",};
        scelta = Menu(opzioni, tastiera);
        
        switch(scelta){
            case 1:{
                dim=5;
                break;
            }
            case 2:{
                dim=50;
                break;
            }
        }
        int[] ruotaN=new int[dim];
                for(int i=0;i< ruotaN.length;i++) {
                    ruotaN[i] = numRand(1, 90);
                    System.out.println(ruotaN[i]);
                }

        System.out.println("Gioca i numeri");
        for(int i=0;i<5;i++){
            NumUtente[i]=tastiera.nextInt();
            System.out.println(NumUtente[i]);
        }
        do{
            System.out.println("----Scegli su cosa puntare----");
            System.out.println("[1]singolo");
            System.out.println("[2]Ambo");
            System.out.println("[3]terna");
            System.out.println("[4]quterna");
            System.out.println("[5]cinquina");
            System.out.println("[6]Continua");
            sceltapuntata=tastiera.nextInt();
                switch (sceltapuntata){
                    case 1:{
                        if(s1==false){
                            System.out.println("Hai scelto di puntare su singolo!");
                            s1=true;
                        }
                        else if(s1==true)
                        {
                            System.out.println("Hai Gia scelto singolo");
                        }
                        break;
                    }
                    case 2:{
                        if(s2==false){
                            System.out.println("Hai scelto di puntare su ambo!");
                            s2=true;
                        }
                        else if(s2==true)
                        {
                            System.out.println("Hai Gia scelto ambo");
                        }
                        break;
                    }
                    case 3:{
                        if(!s3){
                            System.out.println("Hai scelto di puntare su terna!");
                            s3=true;
                        }
                        else if(s3)
                        {
                            System.out.println("Hai Gia scelto terna");
                        }
                        break;
                    }
                    case 4:{
                        if(!s4){
                            System.out.println("Hai scelto di puntare su quaterna!");
                            s4=true;
                        }
                        else if(s4)
                        {
                            System.out.println("Hai Gia scelto quaterna");
                        }
                        break;
                    }
                    case 5:{
                        if(!s5){
                            System.out.println("Hai scelto di puntare su cinquina!");
                            s5=true;
                        }
                        else if(s5)
                        {
                            System.out.println("Hai Gia scelto cinquina");
                        }
                        break;
                    }
                }
        }while(sceltapuntata!=6);

        for (int i = 0; i < NumUtente.length; i++) {
            for (int k = 0; k < ruotaN.length; k++) {
                if (NumUtente[i] == ruotaN[k]) {
                    cont1++;
                }
            }
        }
        System.out.println("------------------"+cont1);

    }

    private static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {

            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");

            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }
    //METODO RANDOM 
    private static int numRand(int minValue, int maxValue) { 

        Random num = new Random();
        return num.nextInt(maxValue)+minValue;

    }

  

    private static int NumeroDiNumeriDaGiocare() {
        Scanner scanner = new Scanner(System.in);
        int quantità;
        int scelta;
        int importo=0;

        do {
            System.out.print("Inserisci quanti numeri vuoi giocare (da 1 a 5): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input non valido. Inserisci un numero da 1 a 5.");
                scanner.next();
            }
            quantità = scanner.nextInt();
        } while (quantità < 1 || quantità > 5);

        switch(quantità){
            case 1:{
                System.out.println("Vuoi puntare su Ambo?\n" +
                        "\n1)si" +
                        "\n2)no");
                scelta= scanner.nextInt();
                if(scelta==1){
                  System.out.println("\nQuanto vuoi puntare su Ambo?");
                  importo=scanner.nextInt();
                }else{
                    break;
                }
            }
        }

        return quantità;
    }

}

