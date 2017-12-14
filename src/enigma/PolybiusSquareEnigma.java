package enigma;

import services.EnigmaService;
import java.util.*;

public class PolybiusSquareEnigma implements EnigmaService {

    private static final boolean KEY_REQUIRED = false;
    private String name;
    private HashMap<Integer, String> letters = new HashMap<Integer, String>();
    {{
        letters.put(0, "A");
        letters.put(1, "B");
        letters.put(2, "C");
        letters.put(3, "D");
        letters.put(4, "E");
    }};
    private String[][] keySquare = {{"z", "e", "b", "r", "a"},
                                    {"c", "d", "f", "g", "h"},
                                    {"i", "k", "l", "m", "n"},
                                    {"o", "p", "q", "s", "t"},
                                    {"u", "v", "w", "x", "y"}};

    public PolybiusSquareEnigma() {
        this.name = "PolybiusSquareEnigma";
    }

    public String encipher(String text) {

        StringBuilder result = new StringBuilder();
        String message = text.replaceAll("[^a-zA-Z ]", "");

        char[] characters = message.toCharArray();
        for (char ch : characters) {
            if (!Character.isLetter(ch)) {
                result.append(ch);
            } else {
                result.append(encryptCharacter(ch));
            }
        }

        return result.toString();
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

        StringBuilder result = new StringBuilder();
        String message = text.replaceAll("[^a-zA-Z ]", "");
        String[] letters = {"A", "B", "C", "D", "E"};
        char[] characters = message.toCharArray();

        int row = 0;
        int column = 0;
        int i = 0;
        try {
            for (char ch : characters) {
                if (Character.toString(ch).equals(" ")) {
                    if (i % 2 != 0) {
                        throw new Exception();
                    }
                    result.append(ch);
                    continue;
                } else if (!Arrays.asList(letters).contains(Character.toString(ch).toUpperCase())){
                    throw new Exception();
                } else {
                    if (i % 2 == 0) {
                        row = (int) getKeyFromValue(this.letters, Character.toString(ch).toUpperCase());
                    } else {
                        column = (int) getKeyFromValue(this.letters, Character.toString(ch).toUpperCase());
                    }
                    i++;
                }
                if (i > 0 && i % 2 == 0) {
                    result.append(this.keySquare[row][column]);
                }
            }
        } catch (Exception e) {
            System.out.println("Your cipher message is incorrect!");
        }
        return result.toString();
    }

    @SuppressWarnings("rawtypes")
    public Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) if (hm.get(o).equals(value)) return o;
        return null;
    }

    public String getName() {
        return this.name;
    }

    public boolean isKeyRequired() {
        return KEY_REQUIRED;
    }

    public void setKey(String key) {}

}
