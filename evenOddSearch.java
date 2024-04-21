import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int dim;

        Scanner scanner = new Scanner(System.in);

        System.out.println("quanti numeri vuoi inserire?");
        dim=scanner.nextInt();

        int[] array = new int[dim];
        int[] arrayOrdinato = new int[dim];

        for(int i=0;i < array.length;i++){
            array[i]=scanner.nextInt();
        }

        array=evenOddSearch(array);

        for(int i=0;i < array.length;i++){
            System.out.print(array[i]);
        }


    }
    private static int[] evenOddSearch(int[] array){

        int iDisp=0,iPari=0,iPariDisp=0;
        int[] arrayDisp= new int[array.length];
        int[] arrayPari= new int[array.length];

        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                arrayDisp[iDisp]=array[i];
                iDisp++;
            }else{
                arrayPari[iPari]=array[i];
                iPari++;
            }
        }

        arrayDisp=ordinaNumeri(arrayDisp);
        arrayPari=ordinaNumeri(arrayPari);

        for(int i=0;i< array.length;i++){
            array[i]=arrayPari[i];
            iPariDisp++;
        }
        for(int i=arrayDisp.length;i>iPariDisp ;i--){
            array[i]=arrayDisp[i];
        }


        return array;
    }

    private static int[] ordinaNumeri(int[] array){

        int temp;
        for(int i=0;i<array.length-1;i++){
            for(int k=i+1; k< array.length;k++){
                if(array[k]<array[i]){
                    temp=array[i];
                    array[i]=array[k];
                    array[k]=temp;
                }
            }
        }
        return array;
    }
}