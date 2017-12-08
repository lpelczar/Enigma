package enigma;

import services.EnigmaService;

public class FakeEnigma implements EnigmaService {

	public static final boolean KEY_REQUIRED = false;
	private String name;

	public FakeEnigma(String name){
		this.name = name;
	}

	public String encipher(String text){
		return text;
	}

	public String decipher(String text){
	return text;
}

	public String getName(){
		return this.name;
	}

	public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

	public void setKey(String key) {}


}
