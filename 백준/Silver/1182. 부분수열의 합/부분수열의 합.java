import java.io.*;
import java.util.*;

public class Main {
    
    static int N, S;
    static int[] arr;
    static boolean[] select;
    static int answer;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        select = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        
        subset(0, 0);
        
        System.out.println(S == 0 ? answer-1 : answer);

    }
    
    static void subset(int srcIdx, int sum) {
        if (srcIdx == N) {
            if (sum == S) answer++;
            return;
        }
        
        select[srcIdx] = true;
        subset(srcIdx+1, sum+arr[srcIdx]);
        select[srcIdx] = false;
        subset(srcIdx+1, sum);
    }
}