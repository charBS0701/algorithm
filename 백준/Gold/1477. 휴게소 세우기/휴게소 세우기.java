import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, L;
    static int[] rests;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 휴게소 개수
        M = Integer.parseInt(st.nextToken());       // 더 지으려는 개수 
        L = Integer.parseInt(st.nextToken());       // 고속도로 길이
        
        rests = new int[N+2];
        rests[0] = 0;
        rests[N+1] = L;
        
        if (N != 0) {
            st = new StringTokenizer(br.readLine());
            for (int n=1; n<=N; n++) {
                rests[n] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(rests);
        
        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isValid(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
        
    }
    
    static boolean isValid(int a) {
        int restCnt = 0;
        for (int i=1; i<N+2; i++) {
            int dist = rests[i] - rests[i-1];
            int needRest = dist / a;    // 해당 구간을 거리 a 이하로 하기위한 휴게소 개수
            if (dist % a == 0) needRest--;
            restCnt += needRest;
            
            if (restCnt > M) return false;
        }
        return true;
    }
    
}