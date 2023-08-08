import java.util.Random;
import java.util.Arrays;

public class mergeSortMethodenPlus {
    public static void main(String[] args) {

        int[] numbers = generateNumbers(10,1000);
        System.out.println("unsortiert: ");
        printArray(numbers);

        long start = System.nanoTime();
        mergeSort(numbers);
        System.out.println();
        System.out.println(System.nanoTime() - start);

        System.out.println("sortiert: ");
        printArray(numbers);
    }

    public static void printArray(int[] numbers) {
        Arrays.stream(numbers).forEach(number -> System.out.print(" " + number));
    }

    public static void mergeSort (int[]arrayMain) {
        if (arrayMain.length < 2){
            return;
        }
        int mid = arrayMain.length / 2;                             //Aufteilung auf 2 Arrays könnte man auch so machen:
        int[] left = Arrays.copyOfRange(arrayMain, 0, mid);                                 //Arrays.copyOfRange(arrayMain, 0, mid);
        int[] right = Arrays.copyOfRange(arrayMain, mid, arrayMain.length);              //Arrays.copyOfRange(arrayMain, mid, arrayMain.length);

        mergeSort(left);
        mergeSort(right);
        merge(arrayMain, left, right);                        //hier wieder zusammenfügen mit neuer Methode
    }

    public static void merge (int[]arrayMain, int[]left, int[]right) {
        int l = 0, r = 0, m = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arrayMain[m] = left[l];
                l++;
            } else {
                arrayMain[m] = right[r];
                r++;
            }
            m++;
        }
        while (l < left.length) {
            arrayMain[m] = left[l];
            m++;
            l++;
        }
        while (r < right.length) {
            arrayMain[m] = right[r];
            m++;
            r++;
        }
    }

    public static int[] generateNumbers(int length, int max) {
        Random r = new Random();
        int[] numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(max);
        }
        return numbers;
    }


}
