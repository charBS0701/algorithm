import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, K=1;
    static char[][] mat;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static boolean[][][] visited;
    
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
        
        visited = new boolean[N+1][M+1][K+1];
        
        if (!bfs()) System.out.println(-1);
    }
    
    static boolean bfs() {
        Deque<Dot> que = new ArrayDeque<>();
        que.add(new Dot(1,1,0,1));
        visited[1][1][0] = true;

        while (!que.isEmpty()) {
            Dot now = que.poll();
            if (now.y == N && now.x == M) {
                System.out.println(now.depth);
                return true;
            }
            
            for (int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (ny <= 0 || nx <= 0 || ny > N || nx > M) continue;   // 지도 밖
                if (visited[ny][nx][now.did]) continue;               // 이미 방문
                
                if (mat[ny][nx] == '0') {                               // 갈 수 있음
                    visited[ny][nx][now.did] = true;
                    que.add(new Dot(ny,nx,now.did,now.depth+1));
                } else {                                                // 벽 느낌
                    if (now.did == K) continue;                         // 부수기 다 썼음
                    else {                                              // 부수기 사용
                        visited[ny][nx][now.did+1] = true;
                        que.add(new Dot(ny,nx,now.did+1,now.depth+1));
                    }
                }
            }
        }
        
        return false;
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