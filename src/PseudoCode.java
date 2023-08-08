import java.util.Scanner;

public class PseudoCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib eine Zahl zur überprüfung ein.");
        int number = sc.nextInt();

        boolean primzahl = true;
        //int counter = 0;

        for (int a = 2; a < number && primzahl; a++) {
            if (number % a == 0)
                primzahl = false;
        }

        if (primzahl)
            System.out.println("Primzahl");
        else
            System.out.println("Keine Primzahl");
    }
}
