import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static char[][] mat;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int[][][] visited;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new char[N+1][M+1];
        for (int n=1; n<=N; n++) {
            String s = br.readLine();
            for (int m=1; m<=M; m++) {
                mat[n][m] = s.charAt(m-1);
            }
        }
        
        visited = new int[N+1][M+1][2];
        for (int n=1; n<=N; n++) {
            for (int m=1; m<=M; m++) {
                Arrays.fill(visited[n][m], INF);
            }
        }        
        
        bfs();
        
        int result = Math.min(visited[N][M][0], visited[N][M][1]);
        System.out.println(result == INF ? -1 : result);
    }
    
    static void bfs() {
        Deque<Dot> que = new ArrayDeque<>();
        que.add(new Dot(1,1,0,1));
        visited[1][1][0] = 1;

        while (!que.isEmpty()) {
            Dot now = que.poll();
            if (now.y == N && now.x == M) continue;
            for (int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (ny <= 0 || nx <= 0 || ny > N || nx > M) continue;   // 지도 밖
                if (now.did == 1 && mat[ny][nx] == '1') continue;       // 부수기 썼는데 막힘
                else if (visited[ny][nx][now.did] <= now.depth+1) continue;     // 이미 더 짧게 온 곳
                
                if (now.did == 0 && mat[ny][nx] == '1' && now.depth + 1 < visited[ny][nx][1]) {  // 부수기 사용
                    visited[ny][nx][1] = now.depth + 1;
                    que.add(new Dot(ny,nx,1,now.depth+1));
                } else if (mat[ny][nx] == '0' && now.depth + 1 < visited[ny][nx][now.did]) {  // 갈 수 있음
                    visited[ny][nx][now.did] = now.depth + 1;
                    que.add(new Dot(ny,nx,now.did,now.depth+1));
                }
            }
        }
    }
    
    static class Dot {
        int y,x,depth;
        int did;
        public Dot(int y, int x, int did, int depth) {
            this.y=y;
            this.x=x;
            this.did=did;
            this.depth=depth;
        }
    }
}