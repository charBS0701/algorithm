import java.io.*;
import java.util.*;

public class Main {
    
    static class Loc implements Comparable<Loc> {
        int y,x;
        int dis;
        public Loc(int y, int x, int dis) {
            this.y=y;
            this.x=x;
            this.dis=dis;
        }
        
        @Override
        public int compareTo(Loc o) {
            if (this.y != o.y) return this.y - o.y;
            return this.x - o.x;
        }
    }
    
    static int N;       // 2 <= 20
    static int[][] mat;
    static int answer;
    static Loc me;
    static int level = 2;
    static int exp;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
                if (mat[n][m] == 9) {
                    me = new Loc(n,m,0);
                    mat[n][m] = 0;
                }
            }
        }
        
        
        bfs();
        
        System.out.println(answer);
        
    }
    
    static void bfs() {
        
        Loc tgt = null;
        while (true) {     
            tgt = seek();   
            if (tgt == null) break;     // 먹이 없으면 종료
            
            answer += tgt.dis;  // 이동거리증가
            me.y = tgt.y;
            me.x = tgt.x;
            
            mat[tgt.y][tgt.x] = 0;  // 꺼ㅡ억
            exp++;                  // 경험치 증가
            if (exp == level) {     // 레벨업
                exp = 0;
                level++;
            }
        }
    }
    
    
    static Loc seek() {
        List<Loc> tgts = new ArrayList<>();     // 먹이 후보들
        int minDist = Integer.MAX_VALUE;
        
        Deque<int[]> que = new ArrayDeque<>();
        visited = new boolean[N][N];
        que.offer(new int[]{me.y,me.x,0});
        visited[me.y][me.x] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (now[2] > minDist) break;    // 더 먼 먹이는 볼 필요 없다
            
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || mat[ny][nx] > level) continue;    // 못지나감
                
                if (mat[ny][nx] != 0 && mat[ny][nx] < level && now[2]+1 <= minDist) {   // 먹이 도달
                    tgts.add(new Loc(ny,nx,now[2] + 1));     // 먹이 후보 추가
                    minDist = now[2] + 1;
                }
                
                que.offer(new int[]{ny,nx,now[2]+1});
                visited[ny][nx] = true;
            }
        }        
        
        if (tgts.isEmpty()) return null;
        
        Collections.sort(tgts);
        
        return tgts.get(0);
    }
}