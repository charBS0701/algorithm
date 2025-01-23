import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static char[][] mat;
    static int W, B;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        mat = new char[N][M];
        
        for (int n=0; n<N; n++) {
            mat[n] = br.readLine().toCharArray();
        }
        
        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                if (mat[n][m] == '-') continue;     // 방문한 곳 pass
                bfs(n,m,mat[n][m]);
            }
        }
        
        System.out.println(W + " " + B);
        
    }
    
    static void bfs(int n, int m, int team) {
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{n,m});
        mat[n][m] = '-';    // 방문처리
        int power = 1;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || mat[ny][nx] != team)
                    continue;
                
                power++;
                mat[ny][nx] = '-';
                que.add(new int[]{ny,nx});
                
            }
        }
        
        power *= power;
        if (team == 'W') W += power;
        else B += power;
        
    }
}