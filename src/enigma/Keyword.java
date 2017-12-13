package enigma;

import java.util.*;
import java.io.*;
import services.EnigmaService;

public class Keyword implements EnigmaService {

    public static final boolean KEY_REQUIRED = true; //publiczna statyczna zmienna ktorej wartosc sie nie zmieni
    private String name;        //deklaruje zmienna name

    public Keyword(String name){
        this.name = name;
        this.key = key;
    }

    public String encipher(String text){
		return "enc("+text+")";
	}

	public String decipher(String text){
	return "dec("+text+")";
}

    public String getName(){
        return this.name;
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key) {
        if (key.chars().allMatch(Character::isLetter)){
            this.key = key.toUpperCase();
        }else{
            this.key = null
        }

}
