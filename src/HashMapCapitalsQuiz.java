import javax.swing.text.AbstractDocument;
import java.util.*;

public class HashMapCapitalsQuiz {
    public static void main(String[] args) {

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Frankreich", "Paris");
        capitals.put("Österreich", "Wien");
        capitals.put("Portugal", "Lisabon");
        capitals.put("Amerika", "Washington");
        capitals.put("Russland", "Moskau");
        capitals.put("Japan", "Tokio");
        capitals.put("Kroatien", "Zagreb");

        List<String> countries = new ArrayList<>();
        countries.addAll(capitals.keySet());

        Random r = new Random();
        Scanner scan = new Scanner(System.in);

        while(true) {
            int index = r.nextInt(countries.size());
            String country = countries.get(index);
            System.out.println("Was ist die Hauptstadt von " + country + "? ");
            if (scan.next().equals(capitals.get(country))) {
                System.out.println("Richtig");
            } else {
                System.out.println("Leider Falsch");
                System.out.println("Richtig wäre: " + capitals.get(country));
            }
        }

    }
}
