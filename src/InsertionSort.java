import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {                                        //die nächste Zahl zu sortieren wird mit der Wert links davon verglichen wenn kleiner getauscht und mit dem nächsten Wert links verglichen...
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int[] insertionSort = new int[11];
        for (int x = 0; x < insertionSort.length; x++) {
            insertionSort[x] = r.nextInt(1000);
            numbers.add(insertionSort[x]);
        }

        System.out.println((Arrays.toString(insertionSort)));

        long start = System.nanoTime();

            for (int i = 1; i < insertionSort.length; ++i) {
                int key = insertionSort[i];                                 //hier wird das aktuelle i auf key gespeichert
                int j = i - 1;                                              //j wird festgelegt mit i - 1 um eine postition davor zu sein
                while (j >= 0 && insertionSort[j] > key) {                  //&& wenn zu sortierender Wert > als key (also insertiion[i]
                    insertionSort[j + 1] = insertionSort[j];                //dann wir insertionSort[j] auf die nächste (j + 1) Stelle gespeichert
                    j--;
                }
                insertionSort[j + 1] = key;                                 //jz wird der zwischengespeicherte Wert key auf insertionSort[j + 1] geschrieben
            }


        System.out.println((Arrays.toString(insertionSort)));
        System.out.println(System.nanoTime() - start);
    }
}
