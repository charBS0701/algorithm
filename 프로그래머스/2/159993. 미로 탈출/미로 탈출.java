import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static char[][] mat;
    static int R, C;
    static int sR, sC;
    static boolean[][] visit;
    static boolean isL;
    static int[] dy = new int[] {-1,1,0,0};
    static int[] dx = new int[] {0,0,-1,1};    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        mat = new char[R][C];
        visit = new boolean[R][C];
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                mat[i][j] = maps[i].charAt(j);
                if (mat[i][j] == 'S') {
                    sR = i;
                    sC = j;
                }
            }
        }
        
        bfs(sR, sC);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    static void bfs(int r, int c) {
        Deque<Dot> que = new ArrayDeque<>();
        que.add(new Dot(r,c,0));
        visit[r][c] = true;
        
        while (!que.isEmpty()) {
            Dot now = que.poll();
            
            for (int d=0; d<4; d++) {
                int ny = now.r + dy[d];
                int nx = now.c + dx[d];
                if (!isValid(ny,nx)) continue;
                if (!isL) {     // 출구 안 열렸을 때
                    if (mat[ny][nx] == 'L') {   // 레버 당김
                        isL = true;
                        for (int i=0; i<R; i++) {   // 방문 초기화
                            Arrays.fill(visit[i], false);
                        }
                        que.clear();
                        que.add(new Dot(ny,nx,now.d+1));
                        visit[ny][nx] = true;                        
                        break;
                    }
                } else {        // 출구 열렸을 때
                    if (mat[ny][nx] == 'E') {
                        answer = now.d + 1;
                        return;
                    }
                }
                que.add(new Dot(ny,nx,now.d+1));
                visit[ny][nx] = true;
            }
        }
        
    }
    
    static class Dot{
        int r;
        int c;
        int d;
        public Dot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    static boolean isValid(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c] || mat[r][c] == 'X')
            return false;
        return true;
    }
}