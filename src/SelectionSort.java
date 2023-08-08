import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {                                    //selection sort sucht das kleinste Element im Array und reiht es stelle für stelle nach vorne
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int[] selectionSort = new int[11];
        for (int x = 0; x < selectionSort.length; x++) {
            selectionSort[x] = r.nextInt(1000);
            numbers.add(selectionSort[x]);
        }

        System.out.println((Arrays.toString(selectionSort)));
        long start = System.nanoTime();

        for (int i = 0; i < selectionSort.length - 1; i++) {
            int minindex = i;

            for (int j = i + 1; j < selectionSort.length; j++) {                //+1 um den nächsten wert in array anzuwählen
                if (selectionSort[j] < selectionSort[minindex]) {
                    minindex = j;
                }
            }
            if (minindex != i) {
                int temp = selectionSort[i];
                selectionSort[i] = selectionSort[minindex];
                selectionSort[minindex] = temp;
            }
            System.out.println((Arrays.toString(selectionSort)));
            System.out.println(System.nanoTime() - start);
        }
    }
}
