import java.io.*;
import java.util.*;

public class Main
{
    
    static int n, m, gcd;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(":");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
	
	    gcd = getGcd(n,m);
	    
	    System.out.println(n/gcd + ":" + m/gcd);
	    
	}
	
	static int getGcd(int n, int m) {
	    if (m == 0) return n;
	    return getGcd(m, n%m);
	}
}