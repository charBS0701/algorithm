import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K;    // 2 <= <= 200_000
    static int T = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        
        int l = 1;
        int r = N;
        
        while (l<=r) {
            int mid = l + (r-l)/2;
            
            if (bfs(mid)) {
                r = mid-1;
                T = mid;
            } else {
                l = mid+1;
            }
        }
        
        System.out.println(T);

    }
    
    static boolean bfs(int t) {
        Arrays.fill(visited, false);
        Deque<int[]> que = new ArrayDeque<>();
        
        que.offer(new int[]{N,0});
        visited[N] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int next = now[0] - t;

            if (next <= 1 && now[1] < K) return true;
            else if (now[1] == K) return false;
            
            for (int i=next; i<now[0]; i++) {
                if (arr[i] == 1 && !visited[i]) {
                    que.offer(new int[]{i, now[1]+1});
                    visited[i] = true;
                    break;
                }
            }
            
        }
        
        return false;
        
    }
}