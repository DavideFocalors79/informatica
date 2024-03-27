import java.util.Scanner;
import java.util.Random;

public class Giocodeifiammiferi {

    public static void main(String[] Args){
        Scanner scanner=new Scanner(System.in);
        int giocatoreUno=0, giocatoreDue=0, fiammiferi=21;
        int scelta,temp=0;
        String [] opzioni = {"=== Gioco Fiammiferi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Il computer vince sempre ", "[4] Exit "};
        String [] sFiamm={"|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|",};
        String [] tFiamm={"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"};

        System.out.println(Menu(opzioni, scanner));
        scelta = Menu(opzioni,scanner);
        switch(scelta) {
            case 1: {
                System.out.println("Inizia il giocatore 1\n");
                Wait(200);

                System.out.println(tFiamm);
                System.out.println(sFiamm+"\n");

                do {

                    fiammiferi = sceltaFiammiferi(scanner, giocatoreUno, fiammiferi, 1);
                    if (fiammiferi > 0) {

                        stampaFiammiferi(fiammiferi,sFiamm,tFiamm);

                        fiammiferi = sceltaFiammiferi(scanner, giocatoreDue, fiammiferi, 2);

                        if(fiammiferi>0){
                            stampaFiammiferi(fiammiferi,sFiamm,tFiamm);
                        }

                    }
                } while (fiammiferi > 0);
                break;
            }
            case 2:
                System.out.println("Inizia il giocatore 1\n");
                Wait(200);

                System.out.println(tFiamm);
                System.out.println(sFiamm+"\n");

                do{

                    fiammiferi=sceltaFiammiferi(scanner,giocatoreUno,fiammiferi,1);

                    if(fiammiferi>0){

                        stampaFiammiferi(fiammiferi,sFiamm,tFiamm);

                        System.out.println("\nInserisce i fammiferi il computer\n");

                        temp=numRand();

                        System.out.println("\nnumero inserito dal computer: "+temp);

                        fiammiferi=fiammiferi-temp;

                        if(fiammiferi>0){

                            stampaFiammiferi(fiammiferi,sFiamm,tFiamm);

                        }else{

                            System.out.println("Il PC ha vinto\n");

                        }
                    }
                }while(fiammiferi>0);
                break;
            case 3:

                System.out.println("Inizia il giocatore 1\n");
                Wait(200);

                System.out.println(tFiamm);
                System.out.println(sFiamm+"\n");


                do{

                    fiammiferi=sceltaFiammiferi(scanner,giocatoreUno,fiammiferi,1);

                    stampaFiammiferi(fiammiferi,sFiamm,tFiamm);

                    System.out.println("\nInserisce il computer\n");

                    fiammiferi=fiammiferi-fiammiferiPcAlwaysWin(fiammiferi);

                    stampaFiammiferi(fiammiferi,sFiamm,tFiamm);

                }while(fiammiferi>0);
                break;

            case 4:
                System.out.println("Uscita in corso...");
                Wait(1000);
                break;
        }

    }
    public static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int Menu (String opzioni[], Scanner scanner)
    {
        int scelta;

        do {

            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = scanner.nextInt();

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while (scelta < 1  || scelta > opzioni.length -1 );

        return scelta;
    }

    private static int sceltaFiammiferi(Scanner scanner,int giocatore,int fiammiferi,int giocatori){

        do{
            System.out.println("\nInserisce i fammiferi il Giocatore "+giocatori);

            giocatore = scanner.nextInt();

            if (giocatore<1||giocatore>3){
                System.out.println("errore inserisci un valore valido");
            }
        }while(giocatore<1||giocatore>3);

        fiammiferi = fiammiferi-giocatore;
        if (fiammiferi<=0){
            System.out.println("il giocatore "+giocatori+" ha vinto\n");
        }


        return fiammiferi;
    }
    private static int numRand() {

        Random num = new Random();
        return num.nextInt(1,4);

    }

    private static int fiammiferiPcAlwaysWin(int fiammiferiRimanenti) {
        //controlla se il numero di fiammiferi rimasti -1 o -5 o -9 è divisibile per 4, per vincere sempre non lasciando all'altro l'opportunita di prendere gli ultimi 3
        if ((fiammiferiRimanenti - 1) % 4 == 0 || (fiammiferiRimanenti - 5) % 4 == 0 || (fiammiferiRimanenti - 9) % 4 == 0) {
            return 1;
        }
        //controlla se il numero di fiammiferi rimasti -2 o -6 o -10 è divisibile per 4, per vincere sempre non lasciando all'altro l'opportunita di prendere gli ultimi 3
        else if ((fiammiferiRimanenti - 2) % 4 == 0 || (fiammiferiRimanenti - 6) % 4 == 0 || (fiammiferiRimanenti - 10) % 4 == 0) {
            return 2;
        }
        //in qualsiasi altro caso prenderne 3
        else {
            if(fiammiferiRimanenti<=0){
                System.out.println("il PC ha vinto\n");
            }
            return 3;
        }

    }
    private static void stampaFiammiferi(int fiammiferi,String [] sFiamm,String [] tFiamm){
        System.out.println("Fiammiferi rimanenti:"+fiammiferi+"\n");
        for(int i=0;i<fiammiferi;i++){
            System.out.printf(tFiamm[i]);
        }
        System.out.printf("\n");
        for(int i=0;i<fiammiferi;i++){
            System.out.printf(sFiamm[i]);
        }
    }

}