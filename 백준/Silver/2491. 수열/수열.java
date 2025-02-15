import java.io.*;
import java.util.*;

public class Main
{   
    
    static int N;
    static int[] arr;
    static int d = 0;
    static int answer = 1;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        
        int num = arr[0];
        int count = 1;
        int sameCnt = 1;
        for (int n=1; n<N; n++) {
            int next = arr[n];

            if (num == next) {      // 같을 때
                answer = Math.max(answer, ++count);
                sameCnt++;
            } else {
                if (d==0) {
                    if (next > num) {
                        d = 1;  // 커지는 방향
                    } else if (next < num) {
                        d = -1; // 작아지는 방향
                    }
                    answer = Math.max(answer, ++count);
                } else if (d==1) {      // 커지는 중일 때
                    if (next > num) {
                        answer = Math.max(answer, ++count);
                    } else if (next < num) {
                        d = -1;
                        count = sameCnt+1;
                    }
                } else {                // 작아지는 중일 때 
                    if (next < num) {
                        answer = Math.max(answer, ++count);
                    } else if (next > num) {
                        d = 1;
                        count = sameCnt+1;
                    }
                }
                sameCnt = 1;
            }
            num = next;
        }
        
        System.out.println(answer);
        
	}
}