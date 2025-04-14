import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, M, right, answer;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int n=0; n<N; n++) {
		    arr[n] = Integer.parseInt(st.nextToken());
		    right = Math.max(right,arr[n]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		int left = 1;
		
		while (left <= right) {
		    
		    int mid = (right - left) / 2 + left;
		    
		    if (check(mid)) {
		        answer = mid;
		        left = mid+1;
		    } else {
		        right = mid-1;
		    }
		}
		
		System.out.println(answer);
		
	}
	
	static boolean check(int mid) {
        int budget = M;
        
        for (int v : arr) {
            if (v < mid) {
                budget -= v;
            } else {
                budget -= mid;
            }
            if (budget < 0) return false;
        }
        
        return true;
        
	}
}   