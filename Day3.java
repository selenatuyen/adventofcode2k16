import java.util.*;
import java.io.*;
import java.math.*;

public class Day3{
	public static int checkTriangle(ArrayList<String> inputArr){
		int count = 0;
		int [] intArr = new int[3];
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for(String s: inputArr){
			String[] splited = s.trim().split(" +");
			for(int i = 0; i < splited.length; i++){
				intArr[i] = Integer.parseInt(splited[i]);
				// System.out.println(intArr[i]);
			} 
			sum1 = intArr[0] + intArr[1];
			sum2 = intArr[0] + intArr[2];
			sum3 = intArr[1] + intArr[2];
			if((sum1 > intArr[2]) && (sum2 > intArr[1]) && (sum3 > intArr[0])){
				count++;
			}
		}
		System.out.println("Total samples:" + inputArr.size());
		return count;
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

		System.out.println("Total possible triangles: " + checkTriangle(temps));
		// for(String s : temps){
			// System.out.println(s);
		// }
	}
}