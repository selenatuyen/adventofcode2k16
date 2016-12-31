import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class Day7{	
	public static boolean checkAbba(String s){
		// List<String> parsedInput = new ArrayList<String>();
		// for(String s : input){
		// 	List<Integer> bracketPos = new ArrayList<Integer>();
		// 	for(int i = 0; i < s.length(); i++){
		// 		char c = s.charAt(i);
		// 		if(c == '['){
		// 			int startBrack = i;
		// 			bracketPos.add(startBrack);
		// 		}
		// 		if(c == ']'){
		// 			int closeBrack = i;
		// 			bracketPos.add(closeBrack);
		// 		}
		// 	}
		// 	String newString  = s;
		// 	for(int i = 0; i < bracketPos.size(); i++){
		// 		if(i == 0){
		// 			int end = bracketPos.get(1);
		// 			newString = s.substring(0,end);
		// 			parsedInputs.add(newString);	
		// 		}
		// 		else{
		// 			int start = bracketPos.get(i-1);
		// 			int end = bracketPos.get(i);
		// 			newString=s.substring(start, end);
		// 			parsedInputs.add(newString);
		// 		}
		// 	}
		// }
		return false;
	}

	public static int countIPs(List<String> input){
		int count = 0;
		// for(String s : input){
		// 	if(checkBracket(s) && checkAbba(s)){
		// 		count++;
		// 	}
		// }
		return count;
	}

	public static boolean checkBracket(List<String> input){
		boolean open = false;

		for(String s : input){
			List<String> parsedInput = new ArrayList<String>();
			List<String> bracketContents = new ArrayList<String>();
			Matcher matcher = Pattern.compile("\\[([^\\]]+)").matcher(s);
			int pos = -1;
			while (matcher.find(pos+1)){
				pos = matcher.start();
				bracketContents.add(matcher.group(1));
			}
			for(String stuff : bracketContents){
				char[] letters = stuff.toCharArray();
				boolean flag = false;
				for(int i = 0; i < letters.length; i++){
					if(letters[i] == letters[i+2]){
						flag = true;
					}
				}
				System.out.println(stuff + " " + flag);
			}
		}	
		return open;
	}

	public static void main(String[] args) throws IOException {
		String tok = "";
		Scanner reader = new Scanner(new File("input7.txt"));
		List<String> lines = new ArrayList<String>();

		while(reader.hasNext()){
			tok = reader.nextLine();
			lines.add(tok);
		}
		
		System.out.println(checkBracket(lines));
	}
}