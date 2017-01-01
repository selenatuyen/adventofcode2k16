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

	public static char[][] rotate(char[][] screen, String dim, int num, int val){
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
		com = parseCommand(input.get(1));

		return count;
	}

	public static char[] parseCommand(String command){
		char[] cmd = new char[3];
		char[] raw = command.toCharArray();
		if(command.contains("rect")){
			cmd[0] = 'r';
			String[] split = command.split(" ");
			String[] dim = split[1].split("x");
			cmd[1] = dim[0].charAt(0);
			cmd[2] = dim[1].charAt(0);
		}
		else if(command.contains("rotate")){
			String[] split = command.split(" ");
			String[] coord = split[2].split("=");
			cmd[0] = coord[0].charAt(0);
			cmd[1] = coord[1].charAt(0);
			cmd[2] = split[4].charAt(0);
			// System.out.println("rotate " + cmd[0] + " " + cmd[1] + " by " + cmd[2]);
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