package enigma;

import services.EnigmaService;

public class ROT13 implements EnigmaService {

    private static final boolean KEY_REQUIRED = false; //publiczna statyczna zmienna ktorej wartosc sie nie zmieni
    private static final String NAME = "ROT13Enigma";        //deklaruje zmienna name

    public String encipher(String text){
        StringBuilder enc_text = new StringBuilder(""); // String en_text = ''
        int shift = 13;
        int len = text.length();
        for (int x = 0; x < len; x++){
            char letter = text.charAt(x);
            if (letter >= 'a' && letter <= 'z') {    //na pewno da się skrócić if ((Character.isLowerCase) ||
                if (letter > 'm') {                     //(Character.isUpperCase
                    letter -= shift;
                } else {
                    letter += shift;
                }
            } else if (letter >= 'A' && letter <= 'Z'){
                if (letter > 'M') {
                    letter -= shift;
                } else {
                    letter += shift;
                }
            }
            enc_text.append(letter);
        }
        return enc_text.toString();
    }

    public String decipher(String text){
    return this.encipher(text);
}

    public String getName(){
        return NAME;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {}


}
