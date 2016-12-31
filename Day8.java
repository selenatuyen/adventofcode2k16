import java.util.*;
import java.io.*;

public class Day8{
	public static void rect(int x, int y){

	}

	public static void rotate(String row, String col, int x, int y, int val){

	}

	public static int pixelCount(List<String> input){
		int count = 0;
		int x = 7;
		int y = 3;
		char[][] screen = new char[x][y];
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				screen[i][j] = '.';
			}
		}
		displayScreen(screen, x, y);
		return count;
	}

	public static void displayScreen(char[][] screen, int x, int y){
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				if(screen[j][i] == '.'){
					System.out.print(screen[j][i]);
				}
				else if(screen[j][i] == '#'){
					System.out.print(screen[j][i]);
				}
			}
			System.out.println("");
		}
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