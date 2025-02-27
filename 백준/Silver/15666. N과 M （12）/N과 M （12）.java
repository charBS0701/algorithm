import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;        // 1 <= <= 8
    static int[] src;
    static int[] tgt;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        tgt = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            src[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);
        
        comb(0,0);
        
        System.out.println(answer);
        
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == M) {
            sb.setLength(0);
            for (int i=0; i<M; i++) {
                sb.append(tgt[i]).append(" ");
            }
            if (!set.contains(sb.toString())) {
                answer.append(sb.toString().trim()).append("\n");
                set.add(sb.toString());
            }
            return;
        }
        
        for (int i=srcIdx; i<N; i++) {
            tgt[tgtIdx] = src[i];
            comb(i, tgtIdx+1);
        }
        
    }
}