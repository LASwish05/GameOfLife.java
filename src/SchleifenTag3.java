import java.util.Random;
import java.util.Scanner;

public class SchleifenTag3 {
    public static void main(String[] args) {

        //OachkatzlSchwoaf
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("OachkatzlSchwoaf");
            } else if (i % 5 == 0) {
                System.out.println("Schwoaf");
            } else if (i % 3 == 0) {
                System.out.println("Oachkatzl");
            } else {
                System.out.println(i);
            }
        }

        //Das kleine Einmal-Eins
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.println(j + " * " + i + " = " + (j * i));
            }
        }

        //Caesar Chiffre
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib einen Text zum verschlüsseln ein.");
        String text = sc.nextLine();
        char[] textChar = text.toCharArray();
        System.out.println(textChar);

        Random r = new Random();
        int postpone = r.nextInt(26) + 1; //damit bei 1 startet
        System.out.println("Caesar Chiffre von: " + postpone);

        for (int i = 0; i < textChar.length; i++) {
            char textChar2 = textChar[i];
            if (!Character.isUpperCase(textChar2) && !Character.isLowerCase(textChar2))
            {
                System.out.print(textChar2);
                //if (Character.isWhitespace(textChar2)) {
                //   System.out.print(textChar2);
            } else {
                int base;
                if (Character.isUpperCase(textChar2)) {
                    base = 'A';
                } else {                                    //solange nur text eingegeben wird genügt hier ein else alleine
                    base = 'a';
                }
                int shifted = (textChar2 - base + postpone) % 26;
                char shiftedText = (char) (base + shifted);
                System.out.print(shiftedText);
            }
        }
    }
}
