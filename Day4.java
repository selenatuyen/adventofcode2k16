import java.util.*;
import java.math.*;
import java.io.*;

public class Day4{
	

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input4.txt"));
		ArrayList<String> temps = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();

		for(String s: temps){
			System.out.println(s);
		}

	}
}