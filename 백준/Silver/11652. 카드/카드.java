import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static Map<Long,Integer> map = new TreeMap<>();
    
	public static void main(String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    for (int n=0; n<N; n++) {
	        long num = Long.parseLong(br.readLine());
	        
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    
	    long maxNum = Long.MIN_VALUE;
	    int max = 0;
	    
	    Set<Long> keySet = map.keySet();
	    
	    for (Long key : keySet) {
	        if (map.get(key) > max) {
	            max = map.get(key);
	            maxNum = key;
	        }
	    }
	    
		System.out.println(maxNum);
	}
}
