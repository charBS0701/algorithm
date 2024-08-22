import java.util.*;
class Solution {
    static int answer;
    static boolean[][] visit;
    static int Y, X;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public int solution(int[][] maps) {
        Y = maps.length;
        X = maps[0].length;
        visit = new boolean[Y][X];
        bfs(0,0,1,maps);
        return answer == 0 ? -1 : answer;
    }
    
    public static void bfs(int y, int x, int time, int[][] maps) {
        Deque<Dot> que = new ArrayDeque<>();
        que.offer(new Dot(y,x,time));
        visit[y][x] = true;
        
        while(!que.isEmpty()) {
            Dot now = que.poll();
            
            for (int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (!isValid(ny,nx) || visit[ny][nx] || maps[ny][nx] == 0) continue;
                
                if (ny == Y-1 && nx == X-1) {
                    answer = now.time+1;
                    return;
                }
                
                que.offer(new Dot(ny,nx,now.time+1));
                visit[ny][nx] = true;
            }
            
        }
    }
    
    public static class Dot {
        int y;
        int x;
        int time;
        public Dot(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    
    public static boolean isValid(int y, int x) {
        if (y<0 || x<0 || y>=Y || x>=X) return false;
        return true;
    }
}