import java.util.*;
import java.io.*;
import java.math.*;

public class Day3{
	public static void main(String[] args) throws IOException{
		String tok = "";
		ArrayList<String> temps = new ArrayList<String>();

		Scanner reader = new Scanner(new File("input3.txt"));
		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();

		for(String s : temps){
			System.out.println(s);
		}
	}
}