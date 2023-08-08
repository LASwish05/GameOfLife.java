import java.util.Random;
public class test {
    public static void main(String[] args) {
        char[] possibleSigns = {'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!'};

        /*Random r = new Random();
        char[] a = new char[4];
        for (int x = 0; x < 4; x++) {
            a[x] = r.next(possibleSigns);
            System.out.println(a[x]);
        }*/
        int passwordLength = 4;
        char[] password = new char[passwordLength];
        Random r = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = r.nextInt(possibleSigns.length);
            password[i] = possibleSigns[randomIndex];
        }

        System.out.println("Das generierte Passwort lautet: " + new String(password));
    }
}
