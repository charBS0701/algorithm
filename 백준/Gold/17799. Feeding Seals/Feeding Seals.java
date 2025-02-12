import java.io.*;
import java.util.*;

public class Main
{   
    static int N, C;
    static int[] weights;
    static int answer;      // 필요한 최소한의 자원봉사자
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());       // bucketes <= 100_000
	    C = Integer.parseInt(st.nextToken());       // 한 번에 나를 수 있는 무게 
	    weights = new int[N];                       // 양동이 무게
	    st = new StringTokenizer(br.readLine());
	    for (int n=0; n<N; n++) {
	        weights[n] = Integer.parseInt(st.nextToken());
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