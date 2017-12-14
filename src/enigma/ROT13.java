package enigma;

import services.EnigmaService;

public class ROT13 implements EnigmaService {

    public static final boolean KEY_REQUIRED = false; //publiczna statyczna zmienna ktorej wartosc sie nie zmieni
    private String name;        //deklaruje zmienna name

    public ROT13(String name){
        this.name = name;
    }

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
        return this.name;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {}


}
