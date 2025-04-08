import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, X, answer;
    static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
		    arr[n] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
        int l=0, r=N-1;
        while (l<r) {
            int sum = arr[l] + arr[r];
            if (sum == X) {
                answer++;
                l++;
            } else if (sum < X) {
                l++;
            } else {
                r--;
            }
        }
        
        System.out.println(answer);
	    
	}
}