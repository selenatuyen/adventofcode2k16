import java.util.*;
import java.math.*;
import java.io.*;

public class Day5{
	public static void main(String[] args) throws Exception{
		String tok = "";
		List<String> temps = new ArrayList<String>();

		Scanner reader = new Scanner(new File("input6.txt"));
		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();
	}
}