import java.util.*;
import java.io.*;

public class Day8{
	public static void rect(int x, int y){

	}

	public static void rotate(String row, String col, int x, int y, int val){

	}

	public static int pixelCount(List<String> input){

	}
	
	public static void main(String[] args) throws IOException {
		String tok = "";
		Scanner reader = new Scanner(new File("input8.txt"));
		List<String> lines = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			lines.add(tok);
		}
		System.out.println(pixelCount(lines));
	}
}