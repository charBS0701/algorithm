import java.util.*;
class Solution {
    static int ry, rx;
    static int Y, X;
    static char[][] mat;
    static boolean[][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;
    public int solution(String[] board) {
        Y = board.length;
        X = board[0].length();
        visit = new boolean[Y][X];
        
        mat = new char[Y][X];
        for (int i=0; i<Y; i++) {        // 좌표 입력
            for (int j=0; j<X; j++) {
                char c = board[i].charAt(j);
                mat[i][j] = c;
                if (c == 'R') {
                    ry = i;
                    rx = j;
                }
            }
        }
        
        bfs(ry,rx,0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
        
    }
    
    static void bfs(int y, int x, int time) {
        Deque<Dot> que = new ArrayDeque<>();
        que.offer(new Dot(y,x,time));
        visit[y][x] = true;
        
        while (!que.isEmpty()) {
            Dot now = que.poll();
            if (mat[now.y][now.x] == 'G') {
                answer = Math.min(answer, now.time);
                return;
            }            
            
            for (int d=0; d<4; d++) {
                int ny = now.y;
                int nx = now.x;
                
                while(true) {   // 각 방향 끝으로 직진
                    ny += dy[d];
                    nx += dx[d];
                    if (canGo(ny,nx)) continue;
                    // 못가는 곳 도달, 직전 곳에서 bfs
                    ny -= dy[d];
                    nx -= dx[d];
                    break;
                }
                
                if (visit[ny][nx]) continue;
                
                que.offer(new Dot(ny,nx,now.time+1));
                visit[ny][nx] = true;                    
                
            }
        }
        

    }
    
    static class Dot {
        int y;
        int x;
        int time;
        public Dot(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
        
    
    static boolean canGo(int ny, int nx) {
        if (ny<0 || nx<0 || nx>=X || ny>=Y || mat[ny][nx] == 'D')
            return false;
        return true;
    }
    
}