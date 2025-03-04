import java.io.*;
import java.util.*;

public class Main {
    
    static int F, S, G, U, D;
    static boolean[] visited;
    static int answer = -1;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        visited = new boolean[F+1];
        bfs();
        
        System.out.println(answer == -1 ? "use the stairs" : answer);
        
    }
    
    static void bfs() {
        if (S == G) {
            answer = 0;
            return;
        }
        
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{S,0});
        visited[S] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nextU = now[0] + U;
            int nextD = now[0] - D;
            int cnt = now[1];
            
            if (nextU == G || nextD == G) {
                answer = cnt + 1;
                    return;
            }
            if (nextU <= F && !visited[nextU]) {
                que.offer(new int[]{nextU, cnt + 1});
                visited[nextU] = true;
            }
            if (nextD >= 1 && !visited[nextD]) {
                que.offer(new int[]{nextD, cnt + 1});
                visited[nextD] = true;
            }
            
        }
    }
    
}