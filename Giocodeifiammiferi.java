import java.util.Scanner;
import java.util.Random;

public class Giocodeifiammiferi {

    public static void main(String[] Args){
        Scanner scanner=new Scanner(System.in);
        int giocatoreUno=0, giocatoreDue=0, fiammiferi=21;
        int gUno=0, gDue=0;
        int scelta;
        String [] opzioni = {"=== Gioco Fiammiferi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Il computer vince sempre ", "[4] Exit "};
        String [] sFiamm={"|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|","|",};
        String [] tFiamm={"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"};
        String errore="errore!!! il numero supera 3\n";

        System.out.println(Menu(opzioni, scanner));
        scelta = Menu(opzioni,scanner);
        switch(scelta) {
            case 1: {
                System.out.println("Inizia il giocatore 1\n");
                Wait(200);
                ClrScr();
                System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
                System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
                System.out.println("\n");
                do {
                    System.out.println("Inserisce i fammiferi il Giocatore 1\n");
                    fiammiferi = sceltaFiammiferi(scanner, giocatoreUno, fiammiferi, 1);
                    if (fiammiferi >= 0) {
                        System.out.println("Fiammiferi rimanenti:" + fiammiferi + "\n");
                        System.out.println("Inserisce i fammiferi il Giocatore 2\n");
                        fiammiferi = sceltaFiammiferi(scanner, giocatoreDue, fiammiferi, 2);
                        System.out.println("Fiammiferi rimanenti:" + fiammiferi + "\n");
                    }
                } while (fiammiferi >= 0);
                break;
            }
            case 2:
                System.out.println("Inizia il giocatore 1\n");
                Wait(200);
                ClrScr();
                System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
                System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
                System.out.println("\n");
                do{
                    System.out.println("Inserisce i fammiferi il Giocatore 1\n");
                    fiammiferi=sceltaFiammiferi(scanner,giocatoreUno,fiammiferi,1);
                    if(fiammiferi>=0){
                        System.out.println("Fiammiferi rimanenti:"+fiammiferi+"\n");
                        System.out.println("Inserisce i fammiferi il computer\n");
                        fiammiferi=numRand();
                        System.out.println("Fiammiferi rimanenti:"+fiammiferi+"\n");
                    }
                }while(fiammiferi>=0);
                break;
            case 3:
                break;

        }


    }
    public static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
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
            ClrScr();
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
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));

        return scelta;
    }

    private static int sceltaFiammiferi(Scanner scanner,int giocatore,int fiammiferi,int giocatori){
        giocatore = scanner.nextInt();
        try {
            if (giocatore > 3)
                System.out.println("errore");
        } catch (Exception x) {
            giocatore = 3;
        }
        fiammiferi = fiammiferi-giocatore;
        if (fiammiferi<=0){
            System.out.println("il giocatore "+giocatori+" ha vinto\n");
        }


        return fiammiferi;
    }
    private static int numRand() {

        Random num = new Random();
        System.out.println(num);
        return num.nextInt(1,3);

    }
    private static void stampaFiammiferi(int fiammiferi){

    }

}