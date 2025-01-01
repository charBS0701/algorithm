import java.io.*;
import java.util.*;

public class Main
{
    
    static int K;
    static int a = 1, b;
    
	public static void main(String[] args) throws Exception {
	    
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   K = Integer.parseInt(br.readLine());
	   
	   for (int k=0; k<K; k++) {
	       int tmpA = 0;
	       int tmpB = 0;
	       
	       // A -> B
	       tmpB = a;
	       
	       // B -> BA
	       tmpA = b;
	       
	       a = tmpA;
	       b += tmpB;
	       
	   }
	   
	   
	   System.out.println(a + " " + b);
	   
	}
	   
}
