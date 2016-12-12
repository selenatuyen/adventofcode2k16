import java.util.*;
import java.math.*;
import java.io.*;

public class Day2{
	public static String bathroomCode(ArrayList<String> inputArr){
		String code = "hello";
		int pos = 5;

		for(String s : inputArr){
			for(int i = 0; i < s.length(); i ++){
				char c = s.charAt(i);
				// System.out.println(c);
				switch(c){
					case 'U':
						System.out.println("Moving up");
						break;
					case 'D':
						System.out.println("Moving down");
						break;
					case 'L':
						System.out.println("Moving left");
						break;
					case 'R':
						System.out.println("Moving right");
						break;
					default:
						System.out.println("Invalid move");
				}
			}
		}
		return code;
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input2.txt"));
		
		ArrayList<String> temps = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.next();
			temps.add(tok);
		} 
		reader.close();

		System.out.println(bathroomCode(temps));

		// for(String s : temps){
		// 	System.out.println(s);
		// }
		// String[] tempArr;
		// for (int i = 0; i < temps.length; i++){
		// 	tempArr[i] = temps.toArray(new String[i]);
		// }
	}
}