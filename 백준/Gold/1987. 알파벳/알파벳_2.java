package boj;
// 방문처리 Set 말고 boolean 배열 이용 -> 메모리 1/20, 시간 1/2 됨
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳_1987_2 {
    static int R, C;
    static int y, x;    // 말 위치
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int max=1;
    static int[] dy = {-1,1,0,0};    // 상하좌우
    static int[] dx = {0,0,-1,1};    // 상하좌우
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        dfs(y,x,1);
        System.out.println(max);
    }
    
    static void dfs(int y, int x, int depth) {
    	visited[(int)map[y][x]-'A'] = true;
    	
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0 || ny>=R || nx<0 || nx>=C) continue;
            if (visited[(int)map[ny][nx]-'A']) continue;    // 이미 지난 알파벳
            dfs(ny,nx,depth+1);
        }
        max = Math.max(max, depth);
        visited[(int)map[y][x]-'A'] = false;
    }

}
