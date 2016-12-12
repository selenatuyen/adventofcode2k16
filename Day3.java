import java.util.*;
import java.io.*;
import java.math.*;

public class Day3{
	public static int checkTriangle(ArrayList<String> inputArr){
		int count = 0;
		int [] intArr = new int[3];
		for(String s: inputArr){
			String[] splited = s.split("\\s+");
			for(int i = 0; i < splited.length; i++){
				intArr[i] = Integer.parseInt(splited[i]);
			}
			if(intArr[0]+intArr[1] < intArr[2] || intArr[1] + intArr[2] < intArr[0] || intArr[0] + intArr[2] < intArr[1]){
				count++;
			}
		}

		return (inputArr.size() - count);
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		ArrayList<String> temps = new ArrayList<String>();

		Scanner reader = new Scanner(new File("input3.txt"));
		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();

		System.out.println(checkTriangle(temps));
		// for(String s : temps){
			// System.out.println(s);
		// }
	}
}