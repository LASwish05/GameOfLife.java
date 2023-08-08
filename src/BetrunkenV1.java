import java.util.Scanner;

public class BetrunkenV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Wie viel Bier hast du getrunken?");
        int beer = sc.nextInt();
        System.out.println("Wieviel Schnaps hast du getrunken");
        int shots = sc.nextInt();

        if (beer + shots == 0) {
            System.out.println("gar nicht betrunken");
        } else if (beer + shots <= 2) {
            System.out.println("Leicht betrunken");
        } else if (beer <= 6 && shots == 0) {
            System.out.println("Betrunken");
        } else {
            System.out.println("Hoffnungslos betrunken");
        }
    }
}
