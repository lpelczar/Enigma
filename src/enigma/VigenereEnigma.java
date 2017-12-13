package enigma;

import services.EnigmaService;
import java.util.*;


public class VigenereEnigma implements EnigmaService {

    private static final boolean KEY_REQUIRED = true;
    private char[][] vigenereTable;
    private String name;

    public VigenereEnigma() {
        this.name = "VigenereEnigma";
    }

    private void createVigenereTable() {

        int NUMBERS_OF_LETTERS_IN_ALPHABET = 26;
        int CAPITAL_LETTERS_IN_ASCII = 65;
        int ROWS = 26;
		int COLS = 26;
        vigenereTable = new char[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {

            for (int column = 0; column < COLS; column++) {

                int numberOfLetterInAscii = row + column;

                if (numberOfLetterInAscii > NUMBERS_OF_LETTERS_IN_ALPHABET) {
                    numberOfLetterInAscii -= NUMBERS_OF_LETTERS_IN_ALPHABET;
                }

                numberOfLetterInAscii += CAPITAL_LETTERS_IN_ASCII;

                vigenereTable[row][column] = (char) numberOfLetterInAscii;
            }
        }
    }

    public String encipher(String text) {
        return text;
    }

    public String decipher(String text) {
        return text;
    }

    public String getName() {
        return this.name;
    }

    public boolean isKeyRequired() {
        return KEY_REQUIRED;
    }

    public void setKey(String key) {}

}
