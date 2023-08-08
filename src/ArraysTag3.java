import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArraysTag3 {
    public static void main(String[] args) {

        //Berechnugn der Maximums
        ArrayList numbers = new ArrayList();
        boolean input = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Gib eine Zahl ein.");
            int newNumber = sc.nextInt();
            numbers.add(newNumber);
            sc.nextLine();
            System.out.println("Möchtest du noch weitere Zahlen eingeben? Zum beenden 'q'.");
            String quit =sc.nextLine();
            if (quit.equals("q")) {
                input = false;
            }
        } while (input);
        System.out.println(numbers);

        System.out.println("Größtes Element in der Liste ist " + Collections.max(numbers));

    }
}
