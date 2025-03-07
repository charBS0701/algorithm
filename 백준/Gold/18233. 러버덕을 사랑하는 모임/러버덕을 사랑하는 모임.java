import java.io.*;
import java.util.*;

public class Main {
    
    static int N, P, E;
    
    static int[] src;
    static int[] mins;
    static int[] mores;
    static int[] tgt;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        src = new int[N];
        for (int n=0; n<N; n++) {
            src[n] = n;
        }
        mins = new int[N];
        mores = new int[N];
        tgt = new int[P];
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            mins[n] = Integer.parseInt(st.nextToken());
            mores[n] = Integer.parseInt(st.nextToken()) - mins[n];
        }
        
        comb(0,0);
        
        System.out.println(sb.length() == 0 ? -1 : sb.toString());
        
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        if (flag) return;
        if (tgtIdx == P) {
            if(check()) flag = true;
            return;
        }
        
        if (srcIdx == N) return;
        
        tgt[tgtIdx] = src[srcIdx];
        
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1, tgtIdx);
        
    }
    
    static boolean check() {
        int sum = 0;
        int moresSum = sum;
        
        for (int i=0; i<P; i++) {
            sum += mins[tgt[i]];            // 최소의 합
            moresSum += mores[tgt[i]];      // 더 줄 수 있는 합
        }
        
        if (E >= sum && E <= sum + moresSum) {      // 이 조합에서 줄 수 있음
            int idx = 0;
            for (int n=0; n<N; n++) {
                if (idx >= P ||  tgt[idx] != n) {
                    sb.append(0).append(" ");
                    continue;
                }
                
                int tmp = sum + mores[tgt[idx]]; 
                if (tmp <= E) {     // 얘는 최대로 다 줘야한다.
                    sum += mores[tgt[idx]];
                    sb.append(mins[tgt[idx]] + mores[tgt[idx]]);
                } else {            // 조절
                    int diff = tmp - E;
                    sum += mores[tgt[idx]] - diff;
                    sb.append(mins[tgt[idx]] + mores[tgt[idx]] - diff);
                }
                sb.append(" ");
                idx++;
            }
            
            return true;
        } else return false;
    }
}