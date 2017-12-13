package enigma;

import services.EnigmaService;
import java.util.*;


public class VigenereEnigma implements EnigmaService {

    private static final boolean KEY_REQUIRED = true;
    private char[][] vigenereTable;
    private String name;
    private String key;
    private final int CAPITAL_LETTERS_IN_ASCII_POSITION = 65;
    private final int NUMBERS_OF_LETTERS_IN_ALPHABET = 26;

    public VigenereEnigma() {
        this.name = "VigenereEnigma";
        createVigenereTable();
    }

    private void createVigenereTable() {

        final int ROWS = 26;
		final int COLS = 26;
        int numberOfLetterInAscii = 0;
        vigenereTable = new char[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {

            for (int column = 0; column < COLS; column++) {

                numberOfLetterInAscii = row + column;

                if (numberOfLetterInAscii >= NUMBERS_OF_LETTERS_IN_ALPHABET) {
                    numberOfLetterInAscii -= NUMBERS_OF_LETTERS_IN_ALPHABET;
                }

                numberOfLetterInAscii += CAPITAL_LETTERS_IN_ASCII_POSITION;

                vigenereTable[row][column] = (char) numberOfLetterInAscii;
            }
        }
    }

    public String encipher(String text) {

        String result = "";
        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        String keyChain = "";
        char[] header = createHeader();
        int row = 0;
        int column = 0;

        while (keyChain.length() < message.length()) {keyChain += this.key;}

        for (int i = 0; i < message.length(); i++) {
            row = Arrays.binarySearch(header, keyChain.charAt(i));
            column = Arrays.binarySearch(header, Character.toUpperCase(message.charAt(i)));
            result += this.vigenereTable[column][row];
        }
        return result;
    }

    public String decipher(String text) {

        String result = "";
        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        String keyChain = "";
        char[] header = createHeader();
        int row = 0;
        int column = 0;

        while (keyChain.length() < message.length()) {keyChain += this.key;}

        for (int i = 0; i < message.length(); i++) {
            row = Arrays.binarySearch(header, keyChain.charAt(i));
            column = new String(this.vigenereTable[row]).indexOf(message.charAt(i));
            result += header[column];
        }

        return result;
    }

    private char[] createHeader() {

        int letter = CAPITAL_LETTERS_IN_ASCII_POSITION;
        char[] header = new char[NUMBERS_OF_LETTERS_IN_ALPHABET];

        for (int i = 0; i < header.length; i++) {
            header[i] = (char) letter;
            letter++;
        }
        return header;
    }

    public String getName() {
        return this.name;
    }

    public boolean isKeyRequired() {
        return KEY_REQUIRED;
    }

    public void setKey(String key) {
        if (key.chars().allMatch(Character::isLetter)) {
            this.key = key.toUpperCase();
        } else {
            this.key = null;
        }
    }

}
