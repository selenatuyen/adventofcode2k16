import java.io.*;
import java.util.*;
import java.math.*;

public class Day1{
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

		// for (String s: tempArr){
		// 	System.out.println(s);
		// }
	}
}