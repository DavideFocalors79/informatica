public class laghi_3E_Es10A_Cronometro {
    public static void main(String[] args) {

        int sec = 0;
        int min = 0;
        int mil = 0;

        do {
            Timer();
            mil++;

            while (mil > 99) {
                mil = 0;
                sec++;
            }
            while (sec > 59) {
                sec = 0;
                min++;
            }

            ClrScr();
            System.out.println(min +":" +sec +":" +mil);
        } while (min < 60);

    }

    private static void Timer() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
