import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static Set<Character> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int n=0; n<N; n++) {
		    boolean flag = false;
		    String str = br.readLine();
		    String[] words = str.split(" ");
		    StringBuilder tmpSb = new StringBuilder();
		    
		    for (int i=0; i<words.length; i++) {
		        char c = Character.toUpperCase(words[i].charAt(0));
		        if (set.contains(c)) {
		            tmpSb.append(words[i]).append(" ");
		            continue;
		        }
		        
		        set.add(c);
		        sb.append(tmpSb).append("[").append(words[i].charAt(0)).append("]").append(words[i].substring(1));
		        for (int j=i+1; j<words.length; j++) {
		            sb.append(" ").append(words[j]);
		        }
		        sb.append("\n");
		        flag = true;
		        break;
		        
		    }
		    
		    if (flag) continue;
		    
		    for (int i=1; i<str.length(); i++) {
		        char c = Character.toUpperCase(str.charAt(i));
		        if (c == ' ' || set.contains(c)) {
		            if (i == str.length()-1) sb.append(str);
		            continue;
		        }
		        set.add(c);
		        sb.append(str.substring(0,i)).append("[").append(str.charAt(i)).append("]").append(str.substring(i+1));
		        break;
		    }
		    
		    sb.append("\n");
		    
		}

        System.out.println(sb);
        
	}
}