import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K, M;
    static int[] arr; 

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        for (int n=0; n<N; n++) {
            int len = Integer.parseInt(br.readLine());
            arr[n] = ( len == 2*K || len <= K ) ? 0 : (len / K == 1 ? len - K : len - 2*K);
        }
        
        Arrays.sort(arr);
        
        int P = -1;
        int left = 1;
        int right = arr[N-1];
        
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (check(mid)) {
                P = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        System.out.println(P);
        
    }
    
    static boolean check(int p) {
        int cnt = 0;
        
        for (int n=0; n<N; n++) {
            cnt += arr[n] / p;
        }
        
        if (cnt >= M) return true;
        else return false;
    }
    
}