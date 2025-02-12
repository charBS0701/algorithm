import java.io.*;
import java.util.*;

public class Main {
    
    static int T, N;        // 2 <= n <= 100_000
    static int[] wants;
    static int[] inDegrees;
    static boolean[] isAlone;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            wants = new int[N+1];
            inDegrees = new int[N+1];
            isAlone = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for (int n=1; n<=N; n++) {
                int to = Integer.parseInt(st.nextToken());
                wants[n] = to;
                inDegrees[to]++;
            }
            
            bfs();
        }
        
        System.out.println(sb);
    }
    
    static void bfs() {
        Deque<Integer> que = new ArrayDeque<>();
        for (int n=1; n<=N; n++) {
            if (inDegrees[n] == 0) {
                que.add(n);
            }
        }
        
        while (!que.isEmpty()) {
            int now = que.poll();
            isAlone[now] = true;
            int next = wants[now];
            inDegrees[next]--;
            if (inDegrees[next] == 0) que.add(next);
        }
        
        int count = 0;
        for (int n=1; n<=N; n++) {
            if (isAlone[n]) count++;
        }
        
        sb.append(count).append("\n");
        
    }
}