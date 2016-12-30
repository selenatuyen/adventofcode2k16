import java.util.*;
import java.io.*;

public class Day6{
	public static String[] getMessage(List<String> input){
		char[] message = new char[8];
		char[] message2 = new char[8];
		for(int i = 0; i < input.get(0).length(); i++){ //for length of input string (8 chars a line)
			int count = 0;
			Map<Character, Integer> freq = new HashMap<Character, Integer>(); //map to hold char and freq
			for(String s : input){  //for each string in input
				char c = s.charAt(i);  //get character in ith position
				if(freq.containsKey(c)) {  //if character is already in map
					count = freq.get(c)+1; //increase count
					freq.put(c, count);    //update hash
				}
				else{
					count = 1;			//char is not in map
					freq.put(c, count);
				}
			}

		char mostCommon = 'a';		//init comparator arbritrary
		char leastCommon = 'a';		//init comparator arbritrary
		for(Map.Entry<Character, Integer> entry : freq.entrySet()){ //for each entry in freq
			if(entry.getValue() > freq.get(mostCommon)){ //if current entry's count is larger than mostCommon's count
				mostCommon = entry.getKey();	//set as most common
			}
			if(entry.getValue() < freq.get(leastCommon)){ //if current entry's count is less than least common's count
				leastCommon = entry.getKey();	//set as least common
			}
		}
		message[i] = mostCommon;	//update letter for the ith position
		message2[i] = leastCommon;	//update letter for the ith positon
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