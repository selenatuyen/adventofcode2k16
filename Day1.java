import java.io.*;
import java.util.*;
import java.math.*;

public class Day1{
	public static int blocksAway(String[] inputArr){
		int[] currLoc = {0, 0};
		int[] chngLoc = {0, 0};
		char currDir = 'N';
		// System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
		for(String s: inputArr){
			// System.out.println("Direction: " + currDir);
			if(currDir == 'N'){
				if(s.startsWith("R")){
					// System.out.println("Moving right " + s.substring(1));
					currLoc[0] = currLoc[0] + Integer.parseInt(s.substring(1));
					currDir = 'E';
				}
				else if(s.startsWith("L")){
					// System.out.println("Moving left " + s.substring(1));
					currLoc[0] = currLoc[0] - Integer.parseInt(s.substring(1));
					currDir = 'W';
				}
				// System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
			}
			else if (currDir == 'E'){
				if(s.startsWith("R")){
					// System.out.println("Moving right " + s.substring(1));
					currLoc[1] = currLoc[1] - Integer.parseInt(s.substring(1));
					currDir = 'S';
				}
				else if(s.startsWith("L")){
					// System.out.println("Moving left " + s.substring(1));
					currLoc[1] = currLoc[1] + Integer.parseInt(s.substring(1));
					currDir = 'N';
				}
				// System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
			}
			else if (currDir == 'S'){
				if (s.startsWith("R")){
					// System.out.println("Moving right " + s.substring(1));
					currLoc[0] = currLoc[0] - Integer.parseInt(s.substring(1));
					currDir = 'W';
				}
				else if (s.startsWith("L")){
					// System.out.println("Moving left " + s.substring(1));
					currLoc[0] = currLoc[0] + Integer.parseInt(s.substring(1));
					currDir = 'E';
				}
				// System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
			}
			else if (currDir == 'W'){
				if (s.startsWith("R")){
					// System.out.println("Moving right " + s.substring(1));
					currLoc[1] = currLoc[1] + Integer.parseInt(s.substring(1));
					currDir = 'N';
				}
				if (s.startsWith("L")){
					// System.out.println("Moving left " + s.substring(1));
					currLoc[1] = currLoc[1] - Integer.parseInt(s.substring(1));
					currDir = 'S';
				}
				// System.out.println("(" + currLoc[0] + "," + currLoc[1] + ")");
			}
			
			// System.out.println("currloc " + currLoc[0] + "," + currLoc[1]);
			// System.out.println("chngLoc " + chngLoc[0] + "," + chngLoc[1]);
			// System.out.println("Taxi cab distance:" + taxicabDist); 	
		}
		int taxicabDist = Math.abs(currLoc[0] - chngLoc[0]) + Math.abs(currLoc[1] - chngLoc[1]);
		return taxicabDist;
	}

	public static void main(String []args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input.txt")).useDelimiter(",\\s*");

		List<String> temps = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.next();
			temps.add(tok);
		}
		reader.close();
		String[] tempArr = temps.toArray(new String[0]);

		System.out.println(blocksAway(tempArr));
	}
}