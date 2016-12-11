import java.util.*;
import java.math.*;
import java.io.*;

public class Day2{
	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input2.txt"));
		
		ArrayList<String> temps = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.next();
			temps.add(tok);
		} 
		reader.close();

		for(String s : temps){
			System.out.println(s);
		}
		// String[] tempArr;
		// for (int i = 0; i < temps.length; i++){
		// 	tempArr[i] = temps.toArray(new String[i]);
		// }
	}
}