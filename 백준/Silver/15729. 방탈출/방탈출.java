import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int[] list;
    static int answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    list = new int[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i=0; i<N; i++) {
	        list[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int prevIdx = 0;
	    if (list[0] == 1) {
	        push(0);
	        answer++;
	    }
	    
	    for (int i=1; i<N; i++) {
	        if (i > prevIdx+2) {
	            prevIdx = i;
	            if (list[prevIdx] == 1) {
	                push(i);
	                answer++;
	            }
	            
	        }
	        
	        if (list[i] != list[prevIdx]) {
	            push(i);
	            answer++;
	            prevIdx = i;
	        }
	    }
	    
	    System.out.println(answer);
	    
	}
	
	static void push(int idx) {
	    for (int i=0; i<3; i++) {
	        if (idx+i >= N) return;
	        list[idx+i] = list[idx+i] == 1 ? 0 : 1;
	    }
	}

}
