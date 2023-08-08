import java.util.Scanner;

public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c;
        int counter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie viele Runden?");
        counter = sc.nextInt();

        for (int d = 1; d <= counter; d++) {
            c = a+b;
            System.out.println(a + "+" + b + "=" + c);
            a = b;
            b = c;
        }
    }
}
