import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] mat;
    static boolean[][] visited;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int maxH;
    static Deque<int[]> que = new ArrayDeque<>();
    static int count, answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st = null;
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            
            for (int m=0; m<N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, mat[n][m]);
            }
        }
        
        for (int h=0; h<=maxH; h++) {
            count = 0;
            for (int n=0; n<N; n++)
                Arrays.fill(visited[n], false);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (visited[i][j] || mat[i][j] <= h) continue;    // 안 잠긴지역 bfss
                    bfs(i,j,h);
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        System.out.println(answer);
        
    }
    
    static void bfs(int i, int j, int h) {
        que.clear();
        que.offer(new int[]{i,j});
        visited[i][j] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || mat[ny][nx] <= h) continue;
                
                que.offer(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }
    }
}