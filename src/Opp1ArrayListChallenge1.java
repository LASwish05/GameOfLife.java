import java.util.ArrayList;
import java.util.Scanner;

public class Opp1ArrayListChallenge1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int highestNumber = 0;

        while (true) {
            System.out.println("Gib eine Zahl ein (Q zum abbrechen).");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
                if (number > highestNumber) {
                    highestNumber = number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Keine gültige Eingabe. Bitte eine Zahl oder Q zum beenden eingeben.");
            }
        }               //while schleife beendet
        for (int n : numbers) {
            if (n == highestNumber) {
                System.out.println(n + " <== highest number");
            } else {
                System.out.println(n);
            }
        }
    }
}
