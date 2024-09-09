import java.util.*;
import java.io.*;

class Main {
    static int N, M, r, c, d;
    static int[][] mat;
    static boolean[][] isClean;
    static int[] dr = new int[] {-1,1,0,0};
    static int[] dc = new int[] {0,0,-1,1};
    static int answer;
    static boolean done;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        mat = new int[N][M];
        isClean = new boolean[N][M];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        simul();
        
        System.out.println(answer);
        
    }
    
    static void simul() {
        int cnt = 0;
        while (true) {
            cnt++;
            // 1-1
            if (!isClean[r][c]) {
                clean(r,c);
            }
            // 1-2
            if (noDirtyAround(r,c)) {   // 청소되지않은 빈칸이 없을 때
                // 2-1, 2-2
                backup();
                if (done) {
                    return;
                }
            } else {    // 사방에 청소되지않은 빈칸이 있을 때 2-3
                // 3-1 : 반시계 회전
                turn();
                // 앞 칸이 더러우면 전진
                int nr = r;
                int nc = c;
                if (d == 0) {   // 북쪽 보고 있으면
                    nr += -1;
                } else if (d==1) {
                    nc += 1;
                } else if (d==2) {
                    nr += 1;
                } else if (d==3) {
                    nc += -1;
                }
                
                if (canGo(nr,nc) && !isClean[nr][nc]) {  // 앞 칸이 더러우면 전진
                    r = nr;
                    c = nc;
                }                
                
            }
        }
        
    }
    
    static void clean(int r, int c) {
        isClean[r][c] = true;
        answer++;
    }
    
    static boolean noDirtyAround(int r, int c) {
        for (int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && mat[nr][nc]==0 && !isClean[nr][nc]) { 
                // 청소되지 않은 빈 칸일 때 
                return false;
            }
        }
        return true;
    }
    
    static void backup() {
        switch (d) {
            case 0:     // 북쪽 보고 있을 떄
                if (canGo(r+dr[1], c+dc[1])) {  // 후진가능
                    r += dr[1];
                    c += dc[1];
                } else {
                    done = true;
                }
                break;
            case 1:     // 동쪽 보고 있을 때
                if (canGo(r+dr[2], c+dc[2])) {
                    r += dr[2];
                    c += dc[2];
                } else {
                    done = true;
                }
                break;
            case 2:     // 남쪽 보고 있을 때
                if (canGo(r+dr[0], c+dc[0])) {
                    r += dr[0];
                    c += dc[0];
                } else {
                    done = true;
                }
                break;
            case 3:     // 서쪽 보고 있을 때
                if (canGo(r+dr[3], c+dc[3])) {
                    r += dr[3];
                    c += dc[3];
                } else {
                    done = true;
                }
                break;       
        }
    }
    
    static boolean canGo(int r, int c) {
        if (r < 0 || c < 0 | r >= N || c >= M) return false;
        if (mat[r][c] == 1) return false;
        return true;
    }
    
    static void turn() {
        d--;
        if (d==-1) d=3;
    }

}