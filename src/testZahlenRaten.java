import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class testZahlenRaten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Welches Level willst du spielen? 1, 2 oder 3? (0 zum Abbrechen.)");
            int level = -1;
            try {
                level = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 0 und 3 ein.");
                sc.nextLine(); // leerer Puffer
                continue; // Schleife erneut durchlaufen
            }
            switch (level) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    boolean play = true;
                    while (play) {
                        int trysLeft = 9;
                        Random r = new Random();
                        int randomNumber = r.nextInt(101);
                        int tip = -1;
                        System.out.println("Gib einen Tipp ab! Du hast 9 Versuche um die Zahl zu erraten.");

                        do {
                            try {
                                tip = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 0 und 100 ein.");
                                sc.nextLine(); // leerer Puffer
                                continue; // Schleife erneut durchlaufen
                            }

                            if (tip == randomNumber) {
                                System.out.println("Du hast die Zahl " + randomNumber + " erraten.");
                            } else if (tip > 100 || tip < 0) {
                                System.out.println("Die Zahl muss >= 0 und <= 100 sein.");
                            } else if (tip < randomNumber) {
                                System.out.println("Die gesuchte Zahl ist größer.");
                            } else {
                                System.out.println("Die gesuchte Zahl ist kleiner.");
                            }
                            trysLeft--;
                            if (trysLeft == 0) {
                                System.out.println("Du hast verloren, da du bereits 9 Versuche hattest.");
                            }
                        } while (trysLeft > 0 && tip != randomNumber);

                        System.out.println("Möchtest du nochmal spielen? 1 für neue Runde, 0 zum Beenden.");
                        int newRound = -1;
                        try {
                            newRound = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ungültige Eingabe. Bitte geben Sie 0 oder 1 ein.");
                            sc.nextLine(); // leerer Puffer
                            continue; // Schleife erneut durchlaufen
                        }

                        if (newRound == 0) {
                            play = false;
                        } else if (newRound == 1) {
                            continue;
                        } else {
                            System.out.println("Falsche Eingabe.");
                        }
                    }
                    break;


                    //noch schauen warum bei 1 nicht von ober beginnt                                 //ende schleiffe play

                case 2:
                    Random r = new Random();
                    int randomNumber = r.nextInt(101);
                    ArrayList<Integer> tipsTried = new ArrayList<>();
                    boolean rightGuess = false;
                    do {
                        System.out.println(tipsTried);
                        System.out.println("Gib einen Tip ab!");
                        int tip = sc.nextInt();
                        if (tip > 100 || tip < 0) {
                            System.out.println("Diese Zahl ist nicht zwischen 0 und 100!");
                        } else if (tip == randomNumber) {
                            System.out.println("Du hast die Zahl " + randomNumber + " erraten.");
                            rightGuess = true;
                        } else if (tip >= randomNumber - 3 && tip <= randomNumber + 3) {
                            System.out.println("Fast da <= 3 daneben.");
                            tipsTried.add(tip);
                        } else if (tip >= randomNumber - 10 && tip <= randomNumber + 10) {
                            System.out.println("Relativ Nahe <= 10 daneben.");
                            tipsTried.add(tip);
                        } else if (tip >= randomNumber - 20 && tip <= randomNumber + 20) {
                            System.out.println("Nicht ganz so weit weg <= 20 daneben.");
                            tipsTried.add(tip);
                        } else {
                            System.out.println("Weit weg > 20 daneben.");
                            tipsTried.add(tip);
                        }
                    } while (!rightGuess);
                    break;
                case 3:
                    Random r3 = new Random();
                    int randomNumber3 = r3.nextInt(101);
                    ArrayList<Integer> tipsTried3 = new ArrayList<Integer>();
                    boolean rightGuess3 = false;
                    int upperLimit = 100;
                    int lowerLimit = 0;
                    int pcOrHuman = r3.nextInt(1);

                    do {
                        if (pcOrHuman == 0) {
                            do {
                                System.out.println(tipsTried3);
                                System.out.println("Nutzer: Gib einen Tip ab!");
                                int tipHuman = sc.nextInt();
                                if (tipHuman > 100 || tipHuman < 0) {
                                    System.out.println("Diese Zahl ist nicht zwischen 0 und 100!");
                                } else if (tipHuman == randomNumber3) {
                                    System.out.println("Gewonnen. Du hast die Zahl " + randomNumber3 + " erraten.");
                                    rightGuess3 = true;
                                    break;
                                } else if (tipHuman < randomNumber3) {
                                    System.out.println("Die gesuchte Zahl ist größer.");
                                    tipsTried3.add(tipHuman);
                                    lowerLimit = tipHuman;
                                    pcOrHuman = 1;
                                    break;
                                } else if (tipHuman > randomNumber3) {
                                    System.out.println("Die gesuchte Zahl ist kleiner.");
                                    tipsTried3.add(tipHuman);
                                    upperLimit = tipHuman;
                                    pcOrHuman = 1;
                                    break;
                                }
                            } while (pcOrHuman == 0 && !rightGuess3);
                        } else if (pcOrHuman == 1) {
                            do {
                                System.out.println(tipsTried3);
                                System.out.println("PC: Gib einen Tip ab!");
                                int tipPc = (upperLimit + lowerLimit) / 2;
                                System.out.println(tipPc);
                                if (tipPc == randomNumber3) {
                                    System.out.println("Gewonnen. Du hast die Zahl " + randomNumber3 + " erraten.");
                                    rightGuess3 = true;
                                    break;
                                } else if (tipPc < randomNumber3) {
                                    System.out.println("Die gesuchte Zahl ist größer.");
                                    tipsTried3.add(tipPc);
                                    lowerLimit = tipPc;
                                    pcOrHuman = 0;
                                    break;
                                } else if (tipPc > randomNumber3) {
                                    System.out.println("Die gesuchte Zahl ist kleiner.");
                                    tipsTried3.add(tipPc);
                                    upperLimit = tipPc;
                                    pcOrHuman = 0;
                                    break;
                                }
                            } while (pcOrHuman == 1);
                        }
                    } while (!rightGuess3);
                    break;
            }
        } while (!exit);
    }
}
