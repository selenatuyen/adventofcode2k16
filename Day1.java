import java.io.*;
import java.util.*;
import java.math.*;

public class Day1{
	public static int blocksAway(String[] inputArr){
		int[] currLoc = {0, 0};
		System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
		for(String s: inputArr){
			if(s.startsWith("R")){
				System.out.println("Moving right " + s.substring(1));
				
			}
			else if (s.startsWith("L")){
				System.out.println("Moving left " + s.substring(1));
			}
			else{
				System.out.println("Invalid move");
			}
		}
		return 0;
	}


	public static void main(String []args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input.txt")).useDelimiter(",\\s*");

		List<String> temps = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.next();
			temps.add(tok);
		}
		reader.close();
		String[] tempArr = temps.toArray(new String[0]);

		System.out.println(blocksAway(tempArr));
		// for (String s: tempArr){
		// 	System.out.println(s);
		// }
	}
}