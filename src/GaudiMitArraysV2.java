public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] s2 = s1.toCharArray();

        int howmuch = 3%26; // modulo ist dazu da, falls ein nutzer eine zahl über 26 eingibt, um alles über 26 nicht zu berüksichtigen.

        for (int x = 0; x < s2.length; x++) {
            int x2 = x + howmuch;
            if (x2 >= 26) {
                x2 = x + howmuch - 26;
            } else if (x2 < 0) {
                x2 = x + howmuch + 26;
            }
            System.out.print(s2[x2]);
        }
    }
}


