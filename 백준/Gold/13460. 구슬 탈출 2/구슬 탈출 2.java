import java.io.*;
import java.util.*;

public class Main {
    
    static class Dot {
        int y, x;
        public Dot(int y, int x) {
            this.y=y;
            this.x=x;
        }
    }
    
    static class State {
        Dot red, blue;
        int times;
        public State(Dot red, Dot blue, int times) {
            this.red = red;
            this.blue = blue;
            this.times = times;
        }
        @Override
        public int hashCode() {
            return Objects.hash(red.y,red.x,blue.y,blue.x);
        }
        @Override
        public boolean equals(Object o) {
            State s = (State) o;
            return red.y == s.red.y && red.x == s.red.x && blue.y == s.blue.y && blue.x == s.blue.x;
        }
        @Override
        public String toString() {
            return "red (" + red.y + "," + red.x + ") blue (" + blue.y + "," + blue.x +")";
        }
    }
    
    static int N, M;
    static char mat[][];
    static Dot RED, BLUE;
    static int dy[] = new int[]{-1,1,0,0};
    static int dx[] = new int[]{0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new char[N][M]; 
        for (int n=0; n<N; n++) {
            mat[n] = br.readLine().toCharArray();
            for (int m=0; m<M; m++) {
                char c = mat[n][m];
                if (c == 'R') {
                    RED = new Dot(n,m);
                } else if (c == 'B') {
                    BLUE = new Dot(n,m);
                }
            }
        }
        
        System.out.println(bfs());
        
    }
    
    static int bfs() {
        Deque<State> que = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();
        que.offer(new State(RED, BLUE, 0));
        visited.add(new State(RED, BLUE, 0));
        
        while (!que.isEmpty()) {
            State now = que.poll();
            if (now.times == 10) return -1;
            Dot red = now.red;
            Dot blue = now.blue;
            
            for (int d=0; d<4; d++) {   // 회전
                Dot nRed = move(red, dy[d], dx[d]);
                Dot nBlue = move(blue, dy[d], dx[d]);
                if (mat[nBlue.y][nBlue.x] == 'O') continue;     // 파란게 빠지면 실패
                
                if (nRed.y == nBlue.y && nRed.x == nBlue.x) {   // 겹칠 경우 더 많이온 것을 한 칸 뒤로
                    if ((Math.abs(red.y-nRed.y) + Math.abs(red.x-nRed.x))   // 빨간공이 더 많이옴
                    > ((Math.abs(blue.y-nBlue.y) + Math.abs(blue.x-nBlue.x)))) {
                        nRed.y -= dy[d];
                        nRed.x -= dx[d];
                    } else {
                        nBlue.y -= dy[d];
                        nBlue.x -= dx[d];
                    }
                }
                
                State next = new State(nRed,nBlue,now.times+1);
                
                if (mat[nRed.y][nRed.x] == 'O') return next.times;     // 빨간색 탈출
                
                if (visited.contains(next)) continue;
                que.offer(next);
                visited.add(next);
            }
        }
        
        return -1;
        
    }

    static Dot move(Dot dot, int dy, int dx) {
        int ny = dot.y;
        int nx = dot.x;
        while (mat[ny + dy][nx + dx] != '#') {
            ny += dy;
            nx += dx;
            
            if (mat[ny][nx] == 'O') {
                break;
            }            
        }
        return new Dot(ny,nx);
    }
    
}