import java.util.*;
import java.math.*;
import java.io.*;

public class Day2{
	public static String bathroomCode(ArrayList<String> inputArr){
		String code = "";
		int pos = 5;
		int chngPos = 0;

		for(String s : inputArr){
			for(int i = 0; i < s.length(); i ++){
				char c = s.charAt(i);
				// System.out.println(c);
				switch(c){
					case 'U':
						// System.out.println("Moving up");
						if((pos - 3) >= 1){
							pos = pos -3;
						}
						break;
					case 'D':
						// System.out.println("Moving down");
						if((pos + 3) <= 9){
							pos = pos + 3;
						}
						break;
					case 'L':
						// System.out.println("Moving left");
						chngPos = pos - 1;
						if(chngPos != 0 && chngPos != 3 && chngPos != 6){
							pos = pos - 1;
						}
						break;
					case 'R':
						// System.out.println("Moving right");
						chngPos = pos + 1;
						if(chngPos != 4 && chngPos != 7 && chngPos != 10){
							pos = pos + 1;
						}
						break;
					default:
						System.out.println("Invalid move");
				}
			// System.out.println("Current position:" + pos);

			}
			// System.out.println("Current position:" + pos);
			code = code + pos;
		}
		return code;
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input2.txt"));
		
		ArrayList<String> temps = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.next();
			temps.add(tok);
		} 
		reader.close();

		System.out.println(bathroomCode(temps));

		// for(String s : temps){
		// 	System.out.println(s);
		// }
		// String[] tempArr;
		// for (int i = 0; i < temps.length; i++){
		// 	tempArr[i] = temps.toArray(new String[i]);
		// }
	}
}