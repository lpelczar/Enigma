package enigma;

import java.util.*;
import services.EnigmaService;

public class AtbashEnigma implements EnigmaService {

	public static final boolean KEY_REQUIRED = false;
	private static final String NAME = "AtbashEnigma";

	public String encipher(String text){
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        char[] chars = text.toCharArray();
        List<Character> enciped = new ArrayList<Character>();
        for(char j : chars){
            int ascii = (int) j;
            if(ascii != 32) ascii = 219 - ascii;
            enciped.add((char) ascii);
        }
        StringBuilder output = new StringBuilder(enciped.size());
        for(char j : enciped) output.append(j);
        return output.toString().toUpperCase();
	}

	public String decipher(String text){
        return encipher(text);
}

	public String getName(){
		return NAME;
	}

	public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

	public void setKey(String key) {}

}
