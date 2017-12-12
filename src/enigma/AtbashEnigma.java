package enigma;

import java.util.*;
import services.EnigmaService;

public class AtbashEnigma implements EnigmaService {

	public static final boolean KEY_REQUIRED = false;
	private String name;

	public AtbashEnigma(String name){
		this.name = name;
	}

	public String encipher(String text){
        char[] chars = text.toCharArray();
        List<Character> enciped = new ArrayList<Character>();
        for(char j : chars){
            int ascii = (int) j;
            ascii = 219 - ascii;                
            enciped.add((char) ascii);
        }
        StringBuilder output = new StringBuilder(enciped.size());
        for(char j : enciped){
            output.append(j);
        }
        return output.toString();
	}

	public String decipher(String text){
        return encipher(text);
}

	public String getName(){
		return this.name;
	}

	public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

	public void setKey(String key) {}


}
