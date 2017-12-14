package enigma;

import java.util.*;
import java.io.*;
import services.EnigmaService;

public class Keyword implements EnigmaService {

    public static final boolean KEY_REQUIRED = true; //publiczna statyczna zmienna ktorej wartosc sie nie zmieni
    private static final String NAME = "KeywordEnigma";        //deklaruje zmienna name
    private String key;

    public String encipher_alphabet(String key){
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
        return Arrays.toString(keyword_alphabet);
	}

    public String encipher(String text){
		System.out.println(encipher_alphabet(this.key));
	       return text;
       }

	public String decipher(String text){
	return "dec("+text+")";
}

    public String getName(){
        return NAME;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {
        if (key.chars().allMatch(Character::isLetter)){
            this.key = key.toUpperCase();
        }else{
            this.key = null;
        }
    }
}
