/*
Author: Lucas Alim Roll Sanz
Lehrer: G.Jarz
Projekt: TicTacToe
 */
public class Spielbrett {
    private char[] felder = {'1','2','3','4','5','6','7','8','9'};

    public void ausgeben() {
        System.out.println(" " + felder[0] + " | " + felder[1] + " | " + felder[2]);
        System.out.println("---+---+---");
        System.out.println(" " + felder[3] + " | " + felder[4] + " | " + felder[5]);
        System.out.println("---+---+---");
        System.out.println(" " + felder[6] + " | " + felder[7] + " | " + felder[8]);
    }

    public void zug(int position, char symbol) {
        felder[position - 1] = symbol;
    }



    public boolean istFreiesFeld(int position) {
        if (position < 1 || position > 9) return false;
        char c = felder[position - 1];
        return c != 'X' && c != 'O';
    }

public char pruefeGewinner() {
    int[][] kombis = {
        {0,1,2}, {3,4,5}, {6,7,8}, // Zeilen
        {0,3,6}, {1,4,7}, {2,5,8}, // Spalten
        {0,4,8}, {2,4,6}           // Diagonalen
    };

    for (int[] k : kombis) {
        if (felder[k[0]] == felder[k[1]] && felder[k[1]] == felder[k[2]]) {
            if (felder[k[0]] == 'X' || felder[k[0]] == 'O') {
                return felder[k[0]];
            }
        }
    }
    return ' '; 
}

public boolean istVoll() {
    for (char c : felder) {
        if (c != 'X' && c != 'O') return false;
    }
    return true;
}

public void zuruecksetzen() {
    for (int i = 0; i < 9; i++) {
        felder[i] = (char) ('1' + i);
    }
}

}