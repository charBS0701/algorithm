import java.io.*;
import java.util.*;
public class Main
{
    
    static int count[] = new int[26];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i=0; i<s.length(); i++) {
            int num = s.charAt(i)-'a';
            count[num]++;
        }
        
        for (int i=0; i<26; i++) {
            sb.append(count[i]).append(" ");
        }        
        
        System.out.println(sb);
        
	}
}
        