package enigma;

import java.util.*;
import java.io.*;
import services.EnigmaService;

public class KeywordEnigma implements EnigmaService {

    public static final boolean KEY_REQUIRED = true;
    private static final String NAME = "KeywordEnigma";
    private String key;


    public char[] encipherAlphabet(String key){
        int alphabetLength = 26;
		char[] keywordAlphabet = new char[alphabetLength];
		for (int i = 0; i < key.length(); i++) {
		    keywordAlphabet[i] = key.charAt(i);
		}
		char c = 'A' - 1;
		for (int i = key.length(); i < alphabetLength; i++) {
		    while (key.contains(String.valueOf(++c)));
		keywordAlphabet[i] = c;
		}
        //System.out.println(keywordAlphabet);
        return keywordAlphabet;
	}

    public String encipher(String text){
        int asciiValue = 65;
        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        String encText = "";
        char[] encAlphabet = encipherAlphabet(this.key);
        
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            if (letter >='A' && letter <='Z'){
                int pos = letter - asciiValue;
                encText += encAlphabet[pos];
            }
            else
            {
                encText += letter;
            }
        }
        return encText;
    }

	public String decipher(String text){
        int asciiValue = 65;
        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        char[] encAlphabet = encipherAlphabet(this.key);
        String decText = "";
        char [] plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            int pos = 0;
            if (letter >='A' && letter <='Z'){
                for(int j=0;j<encAlphabet.length;j++){
                    if(encAlphabet[j] == letter){
                        pos = j;
                        break;
                    }
                }
                decText += plainAlphabet[pos];
            }
            else
            {
                decText += letter;

            }
        }
        return decText;
}

    public String getName(){
        return this.NAME;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {
            this.key = key.toUpperCase();
        }
}
