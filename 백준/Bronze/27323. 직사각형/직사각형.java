import java.io.*;
import java.util.*;

public class Main
{
    
    static int A,B;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
	    B = Integer.parseInt(br.readLine());
		
		System.out.println(A*B);
		
	}
}