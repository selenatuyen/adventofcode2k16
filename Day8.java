import java.util.*;
import java.io.*;

public class Day8{
	public static char[][] rect(char[][] screen, int x, int y){ //creates rectangle  of x*y pixels from top left corner and returns new screen state
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '#';
			}
		}
		return screen;
	}

	public static char[][] rotate(char[][] screen, char dim, int num, int val, int x, int y){ //rotate num col or num row by val pixels
		char[][] copy = new char[y][x]; //creates copy of current screen state
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				copy[i][j] = screen[i][j];
			}
		}

		if(dim == 'y'){ //detect row rotation
			int thresh = (x % val) - 1; //threshold value of row to know which pixels need to wrap around
			for(int i = 0; i < y; i++){
				if(i == num){
					for(int j = 0; j < x; j++){
						if(j <= thresh){ //for pixels that don't need to wrap around
							int jval = j + val;	 //new index value, add val to current col index
							screen[i][jval] = copy[i][j]; //set  new index to value of old 
						}
						else if(j > thresh){  //for pixels that need to wrap around
							int jval = (j + val) % x; //new index value mod by total length of cols for wrap around
							screen[i][jval] = copy[i][j]; //set new index to value of old
						}
					}
					return screen;
				}
			}

		}
		else if(dim == 'x'){ //detect col rotation same logic as row but flipped
			int thresh = (y % val) - 1;
			for(int j = 0; j < x; j++){
				if(j == num){
					for(int i = 0; i < y; i++){
						if(i <= thresh){
							int ival = i + val;
							screen[ival][j] = copy[i][j];
						}
						else if(i > thresh){
							int ival = (i + val) % y;
							screen[ival][j] = copy[i][j];
						}

					}
					return screen;
				}
			}	
		}
		return copy;
	}

	public static int pixelCount(List<String> input){
		int x = 50;
		int y = 6;
		char[][] screen = new char[y][x]; //initialize screen to off pixels
		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				screen[i][j] = '.';
			}
		}
		// displayScreen(screen, x, y);
		for(String s : input){ //go through each command
			char[] com = parseCommand(s); //pasre command to get core values
			if(com[0] == 'r'){ //if the command is rect
				screen = rect(screen, Character.getNumericValue(com[1]), Character.getNumericValue(com[2])); //call rect with core values
			}
			else if(com[0] == 'x' || com[0] == 'y'){ //if the command is rotate
				screen = rotate(screen, com[0], Character.getNumericValue(com[1]), Character.getNumericValue(com[2]), x, y); //call rotate with core values
			}
			// System.out.println("");
			// displayScreen(screen, x, y);
		}
		displayScreen(screen, x, y);
		return countPixel(screen, x, y);
	}

	public static int countPixel(char[][] screen, int x, int y){ //counts number of on pixels
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
		char[] cmd = new char[3];	//array to hold core command values
		if(command.contains("rect")){ //if the command is rect
			cmd[0] = 'r';			//set first core value to r
			String[] split = command.split(" ");	//split by space
			String[] dim = split[1].split("x");		//split by x
			cmd[1] = dim[0].charAt(0);				//set second core value to  x value
			cmd[2] = dim[1].charAt(0);				//set third core value to  y value
		}
		else if(command.contains("rotate")){	//if the command is rotate
			String[] split = command.split(" ");	//split by space
			String[] coord = split[2].split("=");	//split by equal
			cmd[0] = coord[0].charAt(0);	//set first core value to dimension value
			cmd[1] = coord[1].charAt(0);	//set second core value to col/row number
			cmd[2] = split[4].charAt(0);	//set third core value to val = # to rotate by
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