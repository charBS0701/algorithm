import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int y, x;    // 말 위치
    static char[][] map;
    static Set<Character> set;    // 말이 지난 알파벳
    static int max=1;
    static int[] dy = {-1,1,0,0};    // 상하좌우
    static int[] dx = {0,0,-1,1};    // 상하좌우
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        dfs(y,x,1);
        System.out.println(max);
    }
    
    static void dfs(int y, int x, int depth) {
    	set.add(map[y][x]);
    	
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0 || ny>=R || nx<0 || nx>=C) continue;
            if (set.contains(map[ny][nx])) continue;    // 이미 지난 알파벳
            dfs(ny,nx,depth+1);
        }
        max = Math.max(max, depth);
        set.remove(map[y][x]);
    }

}