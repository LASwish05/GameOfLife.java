import java.util.Scanner;

public class TaschenrechnerV3 {
    public static void main(String[] args) {

        char operator = 'k';

        while (operator != 'X') {
            Scanner sc = new Scanner(System.in);

            System.out.println("Gib den Operator (+, -, *, /, %) ein: X zum beenden");
            operator = sc.nextLine().charAt(0);

            if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
                System.out.println("Gib die erste Zahl ein");
                int number1 = sc.nextInt();
                System.out.println("Gib die zweite Zahl ein");
                int number2 = sc.nextInt();

                //else
                //  System.out.println("Gib den Operator (+, -, *, /, %) ein: X zum beenden");

                switch (operator) {
                    case '+':
                        System.out.println(number1 + "+" + number2 + " = " + (number1 + number2));
                        break;
                    case '-':
                        System.out.println(number1 + "-" + number2 + " = " + (number1 - number2));
                        break;
                    case '*':
                        System.out.println(number1 + "*" + number2 + " = " + (number1 * number2));
                        break;
                    case '/':
                        System.out.println(number1 + "/" + number2 + " = " + (double) number1 / number2);
                    case '%':
                        System.out.println(number1 + "%" + number2 + " = " + (number1 % number2));
                        break;
                    default:
                        System.out.println("Falscher Operator");
                }
            }
        }
    }
}





