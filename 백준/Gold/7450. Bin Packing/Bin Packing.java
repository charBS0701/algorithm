import java.io.*;
import java.util.*;

public class Main
{   
    static int N, C;
    static int[] weights;
    static int answer;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    C = Integer.parseInt(br.readLine());
	    weights = new int[N];                
	    for (int n=0; n<N; n++) {
	        weights[n] = Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(weights);
	    
	    int bigIdx = N-1;
	    int smallIdx = 0;
        while(smallIdx <= bigIdx) {
            if (smallIdx == bigIdx) {
                answer++;
                break;
            }
            if (weights[bigIdx] + weights[smallIdx] <= C) {
                answer++;
                smallIdx++;
                bigIdx--;
            } else {
                answer++;
                bigIdx--;
            }
        }
        
        System.out.println(answer);
	}
}