public class CleanThisV1 {
    public static void main(String[] args) {
        int age = 27;
        boolean withAdult = false, VIP = true;
        if (age >= 18) {
            System.out.println("Grünes Band");
        } else if (age >= 16) {
            System.out.println("Gelbes Band");
        } else if (age >= 4 && withAdult) {
            System.out.println("Rotes Band");
        } else {
            System.out.println("Kein Zutritt");
        }
        if ((age >= 4 && withAdult || age >= 15) && VIP) {
            System.out.println("Goldenes Band dazu!");
        }
        else {
            System.out.println("Kein goldenes Band dazu!");
        }
    }
}
