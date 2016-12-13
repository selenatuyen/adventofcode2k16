import java.util.*;
import java.math.*;
import java.io.*;
import java.util.regex.*;

public class test{
    public static void main(String[] args) {
    String line = "nzydfxpc-rclop-qwzhpc-qtylyntyr-769[oshgk]";

    Matcher matcher = Pattern.compile("\\[([^\\]]+)").matcher(line);

    List<String> tags = new ArrayList<>();

    int pos = -1;
    while (matcher.find(pos+1)){
        pos = matcher.start();
        tags.add(matcher.group(1));
    }

    System.out.println(tags);
    }
}
