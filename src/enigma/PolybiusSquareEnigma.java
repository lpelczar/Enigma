package enigma;

import services.EnigmaService;
import java.util.*;

public class PolybiusSquareEnigma implements EnigmaService {

    private static final boolean KEY_REQUIRED = false;
    private String name;
    private HashMap<Integer, String> letters = new HashMap<Integer, String>();
    private String[][] keySquare = {{"z", "e", "b", "r", "a"},
                                    {"c", "d", "f", "g", "h"},
                                    {"i", "k", "l", "m", "n"},
                                    {"o", "p", "q", "s", "t"},
                                    {"u", "v", "w", "x", "y"}};

    public PolybiusSquareEnigma() {
        this.name = "PolybiusSquare";
        this.letters.put(0, "A");
        this.letters.put(1, "B");
        this.letters.put(2, "C");
        this.letters.put(3, "D");
        this.letters.put(4, "E");
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

    public String encryptCharacter(char ch) {

        String result = "";

        for (int row = 0; row < this.keySquare.length; row++) {
            for (int column = 0; column < this.keySquare[0].length; column++) {
                if (this.keySquare[row][column].equals(Character.toString(ch).toLowerCase())) {
                    result += this.letters.get(row);
                    result += this.letters.get(column);
                }
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
