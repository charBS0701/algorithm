import java.io.*;
import java.util.*;
public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean flag = s.matches("^(100+1+|01)+$");
        System.out.println(flag == true ? "SUBMARINE" : "NOISE");
	}
}