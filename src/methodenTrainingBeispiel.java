public class methodenTrainingBeispiel {
    public static void main(String[] args) {
        /*Beispiel: ist ein Spiel bei dem wir den Endgegner mit einer Atacke treffen.
        Methode soll beim treffer ausgelöst werden und Lebenspunkte abziehen.
        Und die neuen Lebenspunkte dann zurück geben*/

        int gegnerLeben = 100;
        System.out.println("Der Boss hat noch: " + gegnerLeben + " LP");

        gegnerLeben = gegnerHit(gegnerLeben);
        System.out.println("Boss getroffen, hat noch: " + gegnerLeben + " LP");

        gegnerLeben = gegnerHit(gegnerLeben);
        System.out.println("Boss getroffen, hat noch: " + gegnerLeben + " LP");

        gegnerLeben = gegnerHit(gegnerLeben);
        System.out.println("Boss getroffen, hat noch: " + gegnerLeben + " LP");

    }
    public static int gegnerHit(int aktuellLeben){
        int neuGegenerLeben;
        neuGegenerLeben = aktuellLeben - 20;
        return neuGegenerLeben;
    }

}
