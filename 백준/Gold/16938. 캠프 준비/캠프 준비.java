import java.io.*;
import java.util.*;

public class Main {
    
    static int N, L, R, X;
    static int[] arr;
    static int[] tgt;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        tgt = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        if (N < 2) {
            System.out.println(0);
            return;
        }
        
        comb(0,0);
        
        System.out.println(answer);
        
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        if(check(tgtIdx)) answer++;
        if (tgtIdx == N) {
            return;
        }
        
        for (int i=srcIdx; i<N; i++) {
            tgt[tgtIdx] = arr[i];
            comb(i+1, tgtIdx+1);
        }
        
    }
    
    static boolean check(int len) {
        if (len < 2 || tgt[len-1] - tgt[0] < X) return false;
        int sum = 0;
        for (int i=0; i<len; i++) {     // 난이도 합
            sum += tgt[i];  
        }
        if (sum < L || sum > R) return false;
        return true;
    }
    
}