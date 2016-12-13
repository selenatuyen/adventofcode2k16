import java.util.*;
import java.math.*;
import java.io.*;
import java.util.regex.*;

public class Day4{
	public static int realRooms(ArrayList<String> inputArr){
		int sum = 0;
		ArrayList<String> list = new ArrayList<String>();
		for(String s: inputArr){
			list = new ArrayList<String>(Arrays.asList(s.split("-")));

     		Matcher m = Pattern.compile("\\[([^)\\]]+)").matcher(s);
     		int pos = -1;
			while(m.find(pos+1)){
				pos = m.start();
				list.add(m.group(1));
			}
			String str = list.get(list.size()-2);
			list.set(list.size()-2, str.substring(0, str.indexOf("[")));
		}
		return sum;
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input4.txt"));
		ArrayList<String> temps = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();
		System.out.println(realRooms(temps));
	}
}