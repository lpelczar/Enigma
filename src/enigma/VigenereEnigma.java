import java.util.*;


public class VigenereEnigma {

    private char[][] vigenereEnigma;
    private String name;

    public VigenereEnigma() {
        this.name = "VigenereEnigma";
    }

    private void createVigenereEnigma() {

        int NUMBERS_OF_LETTERS_IN_ALPHABET = 26;
        int CAPITAL_LETTERS_IN_ASCII = 65;
        int ROWS = 26;
		int COLS = 26;
        vigenereEnigma = new char[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {

            for (int column = 0; column < COLS; column++) {

                int numberOfLetterInAscii = row + column;

                if (numberOfLetterInAscii > NUMBERS_OF_LETTERS_IN_ALPHABET) {
                    numberOfLetterInAscii -= NUMBERS_OF_LETTERS_IN_ALPHABET;
                }

                numberOfLetterInAscii += CAPITAL_LETTERS_IN_ASCII;

                vigenereEnigma[row][column] = (char) numberOfLetterInAscii;
            }
        }
    }

    public static void main(String[] args) {
        VigenereEnigma ve = new VigenereEnigma();
        ve.createVigenereEnigma();
        System.out.println(ve.vigenereEnigma[3][3]);
    }

}
