import services.EnigmaService;


public class PolybiusSquareEnigma implements EnigmaService {

    public static final boolean KEY_REQUIRED = false;
    public String name;

    public PolybiusSquareEnigma() {
        this.name = "PolybiusSquare";
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
