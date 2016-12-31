import java.util.*;
import java.io.*;

public class Day8{
	public static char[][] rect(char[][] screen, int x, int y){
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '#';
			}
		}
		return screen;
	}

	public static void rotate(String row, String col, int x, int y, int val){

	}

	public static int pixelCount(List<String> input){
		int count = 0;
		int x = 7;
		int y = 3;
		char[][] screen = new char[y][x];
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '.';
			}
		}
		displayScreen(screen, x, y);
		screen = rect(screen, 3, 2);
		displayScreen(screen, x, y);
		return count;
	}

	public static void displayScreen(char[][] screen, int x, int y){
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				if(screen[i][j] == '.'){
					System.out.print(screen[i][j]);
				}
				else if(screen[i][j] == '#'){
					System.out.print(screen[i][j]);
				}
			}
			System.out.println("");
		}
		System.out.println("");
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