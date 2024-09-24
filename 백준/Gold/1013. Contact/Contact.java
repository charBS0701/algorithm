import java.io.*;
import java.util.*;
public class Main
{
    
        
    static int T;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    for (int t=0; t<T; t++) {
	        String s = br.readLine();
	        boolean flag = true;
	        flag = s.matches("^(100+1+|01)+$");
	        sb.append(flag == true ? "YES" : "NO").append("\n");
	    }
	    
	    System.out.println(sb);
	    
	}
}
        