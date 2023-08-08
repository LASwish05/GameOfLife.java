public class methodenTraining {
    public static void main(String[] args) {

        ausgabe();
        summe();

        for (int i = 1; i <= 5; i++) {
            erstelleGegner();
        }

        erstelleGegner2("Peter", 100);
        erstelleGegner2("Olaf", 80);

        int summe = taschenrechner(7, 3, '+');
        System.out.println(summe);


    }

    public static void ausgabe(){
        System.out.println("ich bin eine Methode");
    }

    public static void summe(){
        int a, b, summe;
        a = 3;
        b = 7;
        summe = a + b;
        System.out.println(summe);
    }

    public static void erstelleGegner(){
        String gegnerName = "Olaf";
        int gegnerLeben = 100;
        System.out.println("Gegner wurde erstellt.");
    }

    public static void erstelleGegner2(String name, int lebenspunkte){
        String gegnerName = name;
        int gegnerLeben = lebenspunkte;
        System.out.println("Gegner wurde erstellt " + gegnerName + " LP. " + lebenspunkte);
    }

    public static int taschenrechner(int zahl1, int zahl2, char operator){
        int summe;                  //lokale Variable
        if (operator == '+'){
            summe = zahl1 + zahl2;
        } else {                //wenn wir nur +  und -  nehmen genügt hier das else
            summe = zahl1 - zahl2;
        }
        return summe;
    }

}


//void = leer
//return = zurück