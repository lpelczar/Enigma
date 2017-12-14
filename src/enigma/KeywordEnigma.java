package enigma;

import java.util.*;
import java.io.*;
import services.EnigmaService;

public class KeywordEnigma implements EnigmaService {

    public static final boolean KEY_REQUIRED = true; //publiczna statyczna zmienna ktorej wartosc sie nie zmieni
    private String name;        //deklaruje zmienna name
    private String key;

    public KeywordEnigma(String name){
        this.name = name;
        this.key = key;
    }

    public char[] encipher_alphabet(String key){
		char[] keyword_alphabet = new char[26];
		for (int i = 0; i < key.length(); i++) {
		    keyword_alphabet[i] = key.charAt(i);
		}
		char c = 'A' - 1; // zmiana upper lower jak potrzeba
		for (int i = key.length(); i < 26; i++) { //wchodzimy na indeks o dlugosci slowa +1 i dajemy tam
		                                                                          //char c +1 czyli kolejne litery alfabetu
		    while (key.contains(String.valueOf(++c)));   // loop dopoki nie znajdziemy char w word
		keyword_alphabet[i] = c; //indent czy nie
		}
        return keyword_alphabet;
	}

    public String encipher(String text){
        String enc_text = "";
        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        char[] enc_alphabet = encipher_alphabet(this.key);
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            if (letter >='A' && letter <='Z'){
                int pos = letter - 65;
                enc_text += enc_alphabet[pos];
            }
            else
            {
                enc_text += letter;
            }
        }
        return enc_text;
    }

	public String decipher(String text){

        String message = text.toUpperCase().replaceAll("[^a-zA-Z ]", "");
        char[] enc_alphabet = encipher_alphabet(this.key);
        String dec_text = "";
        char [] plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String enc_text = encipher(message);

        for (int i = 0; i < message.length(); i++){
            char enc_let = enc_text.charAt(i);
            char letter = message.charAt(i);
            if (letter >='A' && letter <='Z'){
                int pos = letter - enc_let;
                dec_text += plainAlphabet[pos];
            }
            else
            {
                dec_text += letter;

            }
        }
        return dec_text;
}

    public String getName(){
        return this.name;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {
            this.key = key.toUpperCase();
        }
}
