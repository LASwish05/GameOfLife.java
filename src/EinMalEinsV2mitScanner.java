import java.util.Scanner;

public class EinMalEinsV2mitScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Gib bitte eine Reihe ein.");
        int row = sc.nextInt();



        int number1 = 1;
        int number2 = row;

        while (number1<=10) {
            System.out.println(number1 + " x " + number2 + " = " + (number1*number2));
            number1++;
        }
    }
}
