import java.util.HashMap;
import java.util.Scanner;

public class ExercicesTag4 {
    public static void main(String[] args) {
        HashMap<Character, Character> letsSpeak = new HashMap<Character, Character>();
        letsSpeak.put('A', '@');
        letsSpeak.put('B', '8');
        letsSpeak.put('C', '(');
        letsSpeak.put('D', 'D'); //wenn sich wert nicht ändet kann ich es auch rauslöschöen
        letsSpeak.put('E', '3');
        letsSpeak.put('F', 'F');
        letsSpeak.put('G', '6');
        letsSpeak.put('H', '#');
        letsSpeak.put('I', '!');
        letsSpeak.put('J', 'J');
        letsSpeak.put('K', 'K');
        letsSpeak.put('L', '1');
        letsSpeak.put('M', 'M');
        letsSpeak.put('N', 'N');
        letsSpeak.put('O', '0');
        letsSpeak.put('P', 'P');
        letsSpeak.put('Q', 'Q');
        letsSpeak.put('R', 'R');
        letsSpeak.put('S', '$');
        letsSpeak.put('T', '7');
        letsSpeak.put('U', 'U');
        letsSpeak.put('V', 'V');
        letsSpeak.put('W', 'W');
        letsSpeak.put('X', 'X');
        letsSpeak.put('Y', 'Y');
        letsSpeak.put('Z', '2');

        Scanner sc = new Scanner(System.in);
        System.out.println("Gib einen Text zum übersetzten ein.");
        String text = sc.nextLine();
        char[] toTranslate = text.toUpperCase().toCharArray();

        for (int i = 0; i < toTranslate.length; i++) {
            char currentChar = toTranslate[i];
            if (letsSpeak.containsKey(currentChar)) {
                System.out.print(letsSpeak.get(currentChar));
            } else {
                System.out.print(currentChar);
            }
        }
    }
}
