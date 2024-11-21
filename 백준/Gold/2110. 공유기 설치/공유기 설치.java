import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, C;
    static List<Long> list = new ArrayList<>();
    static Long answer = 0L;
    
	public static void main(String[] args) throws Exception {
	    
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   C = Integer.parseInt(st.nextToken());
	   
	   for (int n=0; n<N; n++) {
	       list.add(Long.parseLong(br.readLine()));
	   }
	   
	   Collections.sort(list);
	   
	   long s = 1;
	   long e = list.get(N-1) - list.get(0);
	   long mid;
	   
	   while (s<=e) {
	       mid = (s+e)/2;
	       //System.out.println("------------mid : " + mid);
	       if (solve(mid)) {
	           answer = Math.max(answer, mid);
	           s = mid+1;
	       } else {
	           e = mid-1;
	       }
	       
	   }
	   
	   System.out.println(answer);
	   
	}
	
	static boolean solve(long mid) {
	    
	    int remain = C-1;
	    long prev = list.get(0);
	    
	    for (int idx=1; idx<N; idx++) {
	        
	       // System.out.println("idx : " + idx + ", value : " + list.get(idx) + ", remain : " + remain);
	        
	        if (remain > N - idx) return false;
	        
	        if (list.get(idx) - prev < mid) {
	            continue;
	        } else {
	            prev = list.get(idx);
	            remain--;
	            if (remain == 0) {
	               // System.out.println(mid + "성공");
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
