import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;                                               //Hauptschleife läuft solange exit false ist
        do {                                                                //Levelauswahl
            System.out.println("Welches Level willst du spielen? 1,2 oder 3? (0 zum abbrechen.)");
            int level = -1;
            try {
                level = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Gib eine Zahl von 0 - 3 ein.");
                sc.nextLine();
                continue;
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
                        System.out.println("Gib einen Tip ab! Du hast 9 Versuche um die Zahl zu errraten");

                        do {
                            try {
                                tip = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Ungültige Eingabe. Gib eine Zahl zwischen 0 und 100 ein.");
                                sc.nextLine();
                                continue;
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
                        System.out.println("Möchtest du nochmal spielen? 1 für neue Runde, 0 zum beenden.");
                        int newRound = -1;
                        try {
                            newRound = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ungültige Eingabe. 1 um nochmal zu spielen, 0 um zu beenden");
                            sc.nextLine();
                            continue;
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
                case 2:
                    Random r = new Random();
                    int randomNumber = r.nextInt(101);
                    ArrayList<Integer> tipsTried = new ArrayList<Integer>();            //zum speichern der abgegebenen Tips
                    boolean rightGuess = false;
                    do {
                        System.out.println(tipsTried);
                        System.out.println("Gib einen Tip ab!");
                        int tip;
                        try {
                            tip = sc.nextInt();
                            if (tip > 100 || tip < 0) {
                                throw new InputMismatchException("Diese Zahl ist nicht zwischen 0 und 100!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                            continue;
                        }
                        if (tip == randomNumber) {
                            System.out.println("Du hast die Zahl " + randomNumber + " erraten.");
                            rightGuess = true;
                            break;
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
                    ArrayList<Integer> tipsTried3 = new ArrayList<Integer>();       //speichern abgegebener tips
                    boolean rightGuess3 = false;
                    int upperLimit = 100;                       //upper- lowerLimit wird verwendet um die neuen Rategrenzen für die AI festzulegen
                    int lowerLimit = 0;
                    int pcOrHuman = r3.nextInt(2);              //Entscheidung zufällig wer anfängt
                    int tipHuman;
                    int tipPc;

                    do {                                    //in dieser Schleife wird abwechselnd geraten bis einer gewonnen hat
                        if (pcOrHuman == 0) {
                            do {
                                System.out.println(tipsTried3);
                                System.out.println("Nutzer: Gib einen Tip ab!");
                                try {
                                    tipHuman = sc.nextInt();
                                    if (tipHuman > 100 || tipHuman < 0) {
                                        System.out.println("Diese Zahl ist nicht zwischen 0 und 100!");
                                    } else if (tipHuman == randomNumber3) {
                                        System.out.println("Gewonnen. Du hast die Zahl " + randomNumber3 + " erraten.");
                                        rightGuess3 = true;
                                        break;
                                    } else if (tipHuman < randomNumber3) {
                                        System.out.println("Die gesuchte Zahl ist größer.");
                                        tipsTried3.add(tipHuman);
                                        if (tipHuman > lowerLimit) {
                                        lowerLimit = tipHuman + 1;}
                                        pcOrHuman = 1;
                                        break;
                                    } else if (tipHuman > randomNumber3) {
                                        System.out.println("Die gesuchte Zahl ist kleiner.");
                                        tipsTried3.add(tipHuman);
                                        if (tipHuman < upperLimit) {
                                        upperLimit = tipHuman;}
                                        pcOrHuman = 1;
                                        break;
                                    }
                                }catch (InputMismatchException e) {
                                    System.out.println("Gib eine Zahl zwischen 0 und 100 ein.");
                                    sc.nextLine();
                                }
                            } while (pcOrHuman == 0 && !rightGuess3);
                        } else if (pcOrHuman == 1) {
                            do {
                                System.out.println(tipsTried3);
                                System.out.println("PC: Gib einen Tip ab!");
                                tipPc = (upperLimit + lowerLimit) / 2;
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
                            } while (pcOrHuman == 1 && !rightGuess3);
                        }
                    } while (!rightGuess3);                 //Ende Schleife Level 3
                    break;
            }                           //Ende Switch
        } while (!exit);                //Ende Hauptschleife
    }
}
