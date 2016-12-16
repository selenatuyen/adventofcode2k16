import java.util.*;
import java.security.MessageDigest;

//message digest documentation 
//http://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html

public class Day5{
    static String md5BytesToString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    static boolean isFilled(char[] c) {
        for (int i = 0; i < 8; i++) {
            if (c[i] == '-') return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        String input = "ojvtpuvg";
        int index = 0;

        String password = "";

        for (int i = 0; i < 8; i++) {
            while(true) {
                String temp = input + index++;
                md.update(temp.getBytes());
                String hash = md5BytesToString(md.digest());
                if (hash.startsWith("00000")) {
                    password += hash.substring(5, 6);
                    //System.out.println(hash);
                    break;
                }

            }
        }

        System.out.println(password);

        //part 2

        char[] password2 = new char[8];
        Arrays.fill(password2, '-');
        index = 0;

        while (!isFilled(password2)) {
            while(true) {
                String temp = input + index++;
                md.update(temp.getBytes());
                String hash = md5BytesToString(md.digest());
                if (hash.startsWith("00000")) {
                    int loc = Integer.parseInt(hash.substring(5, 6), 16);
                    if (loc < 0 || loc > 7) break;
                    if (password2[loc] == '-') {
                        password2[loc] = hash.charAt(6);
                    }
                    //System.out.println(hash);
                    break;
                }
            }
        }
        System.out.println(new String(password2));
    }
}