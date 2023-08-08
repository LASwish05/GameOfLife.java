public class GaudiMitStatistikV1 {
    public static void main(String[] args) {
        String s1 = "Unter #Handy finden sich 6 645   ** 23 HH große Anbieter, 2 davon sind aber die besten!";
        char[] s2 = s1.toCharArray();

        int bigLetters = 0;
        int smallLetters = 0;
        int numbers = 0;
        int rest = 0;

        for (int x = 0; x < s2.length; x++) {
            if (s2[x] >= 'A' &&  s2[x] <= 'Z') {
                bigLetters++;
            } else if (s2[x] >= 'a' && s2[x] <= 'z') {
                smallLetters++;
            } else if (s2[x] >= '0' && s2[x] <= '9') {
                numbers++;
            } else {
                rest++;
            }
        }
        System.out.println("Großbuchstaben " + bigLetters);
        System.out.println("Kleinbuchstaben " + smallLetters);
        System.out.println("Zahlen " + numbers);
        System.out.println("Sonstige Zeichen " + rest);
    }
}
