import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static List<Integer> que = new ArrayList<>();
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int idx=1; idx<=N; idx++) {
            que.add(idx);
        }
        
        st = new StringTokenizer(br.readLine());
        
        int nowIdx = 0;
        for (int m=0; m<M; m++) {
            int tgtIdx = Integer.parseInt(st.nextToken());
            int tgtPos = que.indexOf(tgtIdx);
            
            int toLeft = (nowIdx - tgtPos + que.size()) % que.size();
            int toRight = (tgtPos - nowIdx + que.size()) % que.size();
            
            answer += Math.min(toLeft, toRight);
            nowIdx = tgtPos;
            que.remove(nowIdx);
            
            if (nowIdx == que.size()) nowIdx = 0;
            
        }
        
        System.out.println(answer);
    }
}