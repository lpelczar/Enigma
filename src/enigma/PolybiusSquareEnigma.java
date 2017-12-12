package enigma;

import services.EnigmaService;


public class PolybiusSquareEnigma implements EnigmaService {

    private static final boolean KEY_REQUIRED = false;
    private String name;

    public PolybiusSquareEnigma() {
        this.name = "PolybiusSquare";
    }

    public String encipher(String text) {

        String result = "";
        char[] characters = text.toCharArray();
        for (char ch : characters) {
            if (Character.toString(ch).equals(" ")) {
                result += " ";
            } else {
                result += encryptCharacter(ch);
            }
        }

        return result;
    }

    public static String encryptCharacter(char ch) {
        String[] letters = {"A", "B", "C", "D", "E"};
        String[][] keySquare = {{"z", "e", "b", "r", "a"},
                                {"c", "d", "f", "g", "h"},
                                {"i", "k", "l", "m", "n"},
                                {"o", "p", "q", "s", "t"},
                                {"u", "v", "w", "x", "y"}};
        int rowNumber = 0;
        int columnNumber = 0;
        String result = "";

        for (int row = 0; row < keySquare.length; row++) {
            for (int column = 0; column < keySquare[0].length; column++) {
                if (keySquare[row][column].equals(Character.toString(ch))) {
                    columnNumber = column;
                    rowNumber = row;

                }
            }
        }

        for (int i = 0; i < letters.length; i++) {
            if (i == rowNumber) {
                result += letters[i];
            }
        }

        for (int i = 0; i < letters.length; i++) {
            if (i == columnNumber) {
                result += letters[i];
            }
        }
        return result;
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
