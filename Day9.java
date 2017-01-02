import java.util.*;
import java.io.*;
import java.util.regex.*;
public class Day9{
	public static int compressedLength(List<String> input){
		String s = input.get(0);
		Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(s);
	    while(m.find()) {
	      System.out.println(m.group(1));    
	    }
	    return 0;
	}

	public static void main(String[] args) throws IOException{
		String tok = "";
		Scanner reader = new Scanner(new File("input9.txt"));
		List<String> lines = new ArrayList<String>();
		while(reader.hasNext()){
			tok = reader.nextLine();
			lines.add(tok);
		}
		compressedLength(lines);
	}
}