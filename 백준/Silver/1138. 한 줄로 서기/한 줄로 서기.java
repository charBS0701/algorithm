import java.io.*;
import java.util.*;

public class Main
{
    
    static int N;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n=1; n<=N; n++) {
		    int num = Integer.parseInt(st.nextToken());
		    
		    int cnt = 0;
		    for (int i=0; i<N; i++) {
		        if (cnt == num && answer[i] == 0) {
		            answer[i] = n;
		            break;
		        }
		        if (answer[i] == 0) cnt++;
		    }
		    
		}
		
		for (int n=0; n<N; n++) {
		    sb.append(answer[n]).append(" ");
		}
        
        System.out.println(sb);		
		
	}
}