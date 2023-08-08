import java.util.Random;

public class MuenzeWerfenV1 {

    public static void main(String[] args) {

        Random r = new Random();
        boolean head = r.nextBoolean();

        if (head == true) {
            System.out.println("Die Münze ist auf dem Kopf gelandet - ich gewinne.");
        }
        else if (head == false) {
            System.out.println("Die Münze ist auf Zahl gelandet - Stefan gewinnt.");
        }
    }
}
