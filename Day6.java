import java.util.*;
import java.math.*;
import java.io.*;

public class Day6{
	public static void unjamComm(List<String> data){
		HashMap<Character, Integer> frequency1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> frequency2 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> frequency3 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> frequency4 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> frequency5 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> frequency6 = new HashMap<Character, Integer>();
		for(String s : data){
			for(int i = 0; i < s.length(); i++){
				if(i == 1){
					Integer count = frequency1.get(s.charAt(i));
					frequency1.put(s.charAt(i), count++);
				}
				else if(i == 2){
					Integer count = frequency2.get(s.charAt(i));
					frequency2.put(s.charAt(i), count++);
				}
			}	
		}

	}

	public static void main(String[] args) throws Exception{
		String tok = "";
		List<String> temps = new ArrayList<String>();

		Scanner reader = new Scanner(new File("input6.txt"));
		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();
		unjamComm(temps);
	}
}