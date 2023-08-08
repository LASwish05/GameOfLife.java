import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {                   //bubble sort vergleicht immer die zwei elemente neben einander also z.b. 3 und 55 bleibt, 55 und 6 tausch, 55 und 12 tausch ....
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int[] bubbleSort = new int[11];
        for (int x = 0; x < bubbleSort.length; x++) {
            bubbleSort[x] = r.nextInt(1000);
            numbers.add(bubbleSort[x]);
        }

        System.out.println((Arrays.toString(bubbleSort)));

        int temp;
        /*for(int k = 0; k< bubbleSort.length -1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations

            for(int i = 0; i < bubbleSort.length-k-1; i++) {
                if(bubbleSort[ i ] > bubbleSort[ i+1] ) {
                    // here swapping of positions is being done.
                    temp = bubbleSort[ i ];
                    bubbleSort[ i ] = bubbleSort[ i+1 ];
                    bubbleSort[ i + 1] = temp;
                }
            }
        }*/
        long start = System.nanoTime();

        for (int i = 0; i < bubbleSort.length; i++) {
            for (int j = 0; j < bubbleSort.length - (1 +i); j++) {             //+i, da diser Wert nicht mehr sortiert gehört. würde auch ohne gehen aber der PC muss mehr rechnen :)
                if (bubbleSort[j] > bubbleSort[j+1]) {
                    temp = bubbleSort[j+1];
                    bubbleSort[j+1] = bubbleSort[j];
                    bubbleSort[j] = temp;
                }
            }
        }



        System.out.println((Arrays.toString(bubbleSort)));
        System.out.println(System.nanoTime() - start);
    }
}
