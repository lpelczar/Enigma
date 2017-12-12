//package enigma;

import java.util.*;

public class AtbashEnigma {

    public static String encipher(String text){
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
//    public static void main(String[] args){
//        for(String i : args){
//            System.out.println(i + ", " + encipher(i));
//        }
//    }

}
