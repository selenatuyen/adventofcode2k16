import java.util.*;
import java.math.*;
import java.io.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Day4{
	public static int realRooms(List<String> inputArr){
		int sum = 0;
		List<String> list = new ArrayList<String>();
		for(String s: inputArr){
			Map<Character, Integer> freq = new HashMap<Character, Integer>();
			for(int i = 0; i < s.length()-1; i++){
				s.chars().filter(x -> x != '-').forEach(x -> freq.put((char) x, freq.getOrDefault((char)x, 0)+1));
			}

			String top5 = freq.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(5)
				.map(Map.Entry::getKey)
				.map(x -> Character.toString(x))
				.collect(Collectors.joining(""));

			//Splits orignal string input by dashes
			list = new ArrayList<String>(Arrays.asList(s.split("-")));

			//Splits number in brackets and appends to end of list
     		Matcher m = Pattern.compile("\\[([^)\\]]+)").matcher(s);
     		int pos = -1;
			while(m.find(pos+1)){
				pos = m.start();
				list.add(m.group(1));
			}
			
			//Replace string where bracket number was
			String str = list.get(list.size()-2);
			list.set(list.size()-2, str.substring(0, str.indexOf("[")));

			//check if match checksum
			String checkSum = list.get(list.size()-1);
			System.out.print("Checksum: " + checkSum + "  Top 5: " + top5);
			if(top5.equals(checkSum)){
				System.out.print("-----MATCH " + list.get(list.size()-2));
				sum += Integer.parseInt(list.get(list.size()-2));
			}
			System.out.println("");
		}
		return sum;
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input4.txt"));
		List<String> temps = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			temps.add(tok);
		}
		reader.close();
		System.out.println(realRooms(temps));
	}
}