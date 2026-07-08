/*
Author: Lucas Alim Roll Sanz
Lehrer: G.Jarz
Projekt: TicTacToe
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean nochmalSpielen = true;

        while (nochmalSpielen) {
            Spielbrett brett = new Spielbrett();
            char aktuellerSpieler = 'X';
            char gewinner = ' ';

            for (int zug = 1; zug <= 9 && gewinner == ' '; zug++) {
                brett.ausgeben();
                int eingabe;
                do {
                    System.out.print("Spieler " + (aktuellerSpieler == 'X' ? "1" : "2") + ": Feld auswählen! ");
                    eingabe = sc.nextInt();
                    if (!brett.istFreiesFeld(eingabe)) {
                        System.out.println("Ungültig oder schon belegt, nochmal!");
                    }
                } while (!brett.istFreiesFeld(eingabe));

                brett.zug(eingabe, aktuellerSpieler);
                gewinner = brett.pruefeGewinner();

                if (gewinner == ' ') {
                    aktuellerSpieler = (aktuellerSpieler == 'X') ? 'O' : 'X';
                }
            }

            brett.ausgeben();
            if (gewinner != ' ') {
                System.out.println("Spieler " + (gewinner == 'X' ? "1" : "2") + " hat gewonnen!");
            } else if (brett.istVoll()) {
                System.out.println("Unentschieden!");
            }

            System.out.print("Nochmal spielen? (j/n): ");
            String antwort = sc.next();
            nochmalSpielen = antwort.equalsIgnoreCase("j");
        }
    }
}