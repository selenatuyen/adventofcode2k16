import java.util.*;
import java.io.*;

public class Day8{
	public static char[][] rect(char[][] screen, int x, int y){
		// System.out.println(y + "," + x);
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '#';
			}
		}
		return screen;
	}

	public static char[][] rotate(char[][] screen, String row, String col, int x, int y, int val){
		return screen;
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
		char[] com = parseCommand(input.get(0));
		if(com[0] == 'r'){
			screen = rect(screen, Character.getNumericValue(com[1]), Character.getNumericValue(com[2]));
		}
		displayScreen(screen, x, y);
		return count;
	}

	public static char[] parseCommand(String command){
		char[] cmd = new char[3];
		char[] raw = command.toCharArray();
		if(command.contains("rect")){
			cmd[0] = 'r';
			String[] split = command.split(" ");
			// for(String s : split){
			// 	System.out.println("split : " + s);
			// }
			String[] dim = split[1].split("x");
			// for(String s: dim){
			// 	System.out.println("dim : " + s);
			// }
			cmd[1] = dim[0].charAt(0);
			cmd[2] = dim[1].charAt(0);
			// for(char c: cmd){
			// 	System.out.println("cmd : " + c);
			// }
		}
		return cmd;
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