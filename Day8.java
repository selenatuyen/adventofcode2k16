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

	public static char[][] rotate(char[][] screen, char dim, int num, int val, int x, int y){
		char[][] copy = new char[y][x];
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				copy[i][j] = screen[i][j];
			}
		}

		if(dim == 'y'){
			int thresh = (x % val) - 1;
			// System.out.println("thresh :" + thresh);
			for(int i = 0; i < y; i++){
				if(i == num){
					for(int j = 0; j < x; j++){
						// System.out.println("j val: " + j);	
						if(j <= thresh){
							int jval = j + val;	
							// System.out.println("new coordinate:" + i + "," + jval + " current data: " + copy[i][j]);
							screen[i][jval] = copy[i][j];
						}
						else if(j > thresh){
							int jval = (j + val) % x;
							// System.out.println("new coordinate:" + i + "," + jval + " current data: " + copy[i][j]);
							screen[i][jval] = copy[i][j];
						}
					}
					return screen;
				}
			}

		}
		else if(dim == 'x'){
			int thresh = (y % val) - 1;
			for(int j = 0; j < x; j++){
				if(j == num){
					for(int i = 0; i < y; i++){
						if(j <= thresh){
							int ival = i + val;
							screen[ival][j] = copy[i][j];
						}
						else if(j > thresh){
							int ival = (i + val) % y;
							screen[ival][j] = copy[i][j];
						}

					}
					return screen;
				}
			}	
		}
		return screen;
	}

	public static int pixelCount(List<String> input){
		int x = 7;
		int y = 3;
		char[][] screen = new char[y][x]; //initialize screen to off pixels
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '.';
			}
		}
		// displayScreen(screen, x, y);
		for(String s : input){
			char[] com = parseCommand(s);
			if(com[0] == 'r'){
				screen = rect(screen, Character.getNumericValue(com[1]), Character.getNumericValue(com[2]));
			}
			else if(com[0] == 'x' || com[0] == 'y'){
				screen = rotate(screen, com[0], Character.getNumericValue(com[1]), Character.getNumericValue(com[2]), x, y);
			}
			// displayScreen(screen, x, y);
		}
		return countPixel(screen, x, y);
	}

	public static int countPixel(char[][] screen, int x, int y){
		int count = 0;
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				if(screen[i][j] == '#'){
					count++;
				}
			}
		}
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