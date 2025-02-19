import java.io.*;
import java.util.*;

public class Main {
    
    static int N;       // N <= 5000
    static long[] arr;
    static long[] answer = new long[3];
    static long min = 3_000_000_000L;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        
        for (int n=0; n<N-2; n++) {
            long a = arr[n];
            int idx1 = n+1;
            int idx2 = N-1;
            while (idx1 < idx2) {
                long sum = a + arr[idx1] + arr[idx2];
                long sumAbs = Math.abs(sum);
                if (sumAbs < min) {
                    min = sumAbs;
                    answer[0] = a;
                    answer[1] = arr[idx1];
                    answer[2] = arr[idx2];
                }
                
                if (sum == 0) break;
                else if (sum < 0) {
                    idx1++;
                } else if (sum > 0) {
                    idx2--;
                }
            }
        }

        Arrays.sort(answer);
        for (int i=0; i<3; i++) {
            sb.append(answer[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}