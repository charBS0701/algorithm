import java.io.*;
import java.util.*;

public class Main {
    
    static class Rot {
        int t;
        char c;
        public Rot(int t, char c) {
            this.t=t;
            this.c=c;
        }
    }
    
    static int N, K, L;
    static int[][] mat;
    static Deque<Rot> que = new ArrayDeque<>();
    static Deque<int[]> bodyQ = new ArrayDeque<>();
    static int[] dy = new int[]{-1,0,1,0};      // 상좌하우 (반시계방향)
    static int[] dx = new int[]{0,-1,0,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());   // 사과의 개수
        mat = new int[N+1][N+1];
        
        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            mat[y][x] = -1;     // 사과는 -1로 표시
        }
        L = Integer.parseInt(br.readLine());
        for (int l=0; l<L; l++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // x 초 뒤 
            char c = st.nextToken().charAt(0);           // c 방향으로 회전
            que.add(new Rot(x,c));
        }
        
        int time = 0;
        int y=1, x=1;
        int dir = 3;
        mat[1][1] = 1;      // 몸이 있는 곳은 1로 표시
        bodyQ.add(new int[]{1,1});   // 몸이 있는 곳의 큐
        Rot rot = null;
        if (L != 0) {       // 다음 회전 준비
            rot = que.poll();
        }
        while (true) {
            time++;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny <= 0 || nx <= 0 || ny > N || nx > N || mat[ny][nx] == 1) {   // 벽, 몸에 부딪힘
                break;
            }
            
            if (mat[ny][nx] == 0) {  // 사과 없음
                int[] cut = bodyQ.poll();
                mat[cut[0]][cut[1]] = 0;
            }
            
            mat[ny][nx] = 1;    // 머리 이동 (몸과 부딪힐 때 처리를 위해 기록)
            bodyQ.add(new int[]{ny,nx});   // 사과먹고 늘어날 때를 위해 기록                    
            
            if (rot != null && time == rot.t) {     // 회전할 시간
                if (rot.c == 'L') {         // 왼쪽 (시계반대방향)
                    dir = (4+dir+1)%4;
                } else if (rot.c == 'D') {  // 오른쪽 (시계방향)
                    dir = (4+dir-1)%4;
                }
                if (!que.isEmpty()) rot = que.poll();   // 다음 회전 준비
                else rot = null;
            }
            y = ny;
            x = nx;
        }
        
        
        System.out.println(time);

    }
    
}   