import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class BubbleSortArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int howManyNumbers = 10;
        for (int x = 0; x < howManyNumbers; x++) {
            numbers.add(r.nextInt(1000));
        }

        System.out.println("unsortiert:" + numbers);


        long start = System.nanoTime();
        for (int i = 0; i < howManyNumbers; i++) {
            for (int j = 0; j < howManyNumbers - (1 +i); j++) {             //+i, da diser Wert nicht mehr sortiert gehört. würde auch ohne gehen aber der PC muss mehr rechnen :)
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        System.out.println("sortiert:" + numbers);
        System.out.println(System.nanoTime() - start);
    }
}
