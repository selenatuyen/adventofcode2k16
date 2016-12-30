import java.util.*;
import java.io.*;

public class Day7{	
	public static boolean checkAbba(String s){

	}

	public static int countIPs(List<String> input){

	}

	public static void main(String[] args) throws IOException {
		String tok = "";
		Scanner reader = new Scanner(new File("input7.txt"));
		List<String> lines = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			lines.add(tok);
		}
		
		System.out.println(countIPs(lines));
	}
}