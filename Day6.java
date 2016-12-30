import java.util.*;
import java.util.Collections;
import java.io.*;

public class Day6{
	public static String[] getMessage(List<String> input){
		char[] message = new char[8];
		char[] message2 = new char[8];
		for(int i = 0; i < input.get(0).length(); i++){
			int count = 0;
			Map<Character, Integer> freq = new HashMap<Character, Integer>();
			for(String s : input){
				char c = s.charAt(i);
				if(freq.containsKey(c)) {
					count = freq.get(c)+1;
					freq.put(c, count);
				}
				else{
					count = 1;
					freq.put(c, count);
				}
			}

		char mostCommon = 'a';
		char leastCommon = 'a';
		for(Map.Entry<Character, Integer> entry : freq.entrySet()){
			if(entry.getValue() > freq.get(mostCommon)){
				mostCommon = entry.getKey();
			}
			if(entry.getValue() < freq.get(leastCommon)){
				leastCommon = entry.getKey();
			}
		}
		message[i] = mostCommon;
		message2[i] = leastCommon;			
		}
		String m1 = new String(message);
		String m2 = new String(message2);
		String[] messages = {m1, m2};
		return messages;
	}

	public static void main(String[] args) throws IOException {
		String tok = "";
		Scanner reader = new Scanner(new File("input6.txt"));
		List<String> lines = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			lines.add(tok);
		}
		String [] answer = getMessage(lines);
	    System.out.println("most " + answer[0]);
	    System.out.println("least " + answer[1]);
	}
}