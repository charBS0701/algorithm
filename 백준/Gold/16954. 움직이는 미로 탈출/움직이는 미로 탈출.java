import java.io.*;
import java.util.*;

public class Main
{
    static char[][] mat = new char[8][8];    // y, x
    static int[] dy = new int[]{0,0,-1,0,1,-1,1,1,-1};    // 제자리,왼,위,오,밑,1시,5시,7시,11시
    static int[] dx = new int[]{0,-1,0,1,0,1,1,-1,-1};
    static int answer;
    static Set<String> visit = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int n=0; n<8; n++) {
		    mat[n] = br.readLine().toCharArray();
		}
		
		answer = bfs(7,0);       // 왼쪽 아래에서 시작
		
// 		System.out.println(Arrays.toString(mat[n]));
        System.out.println(answer);

	}
	
	static int bfs(int y, int x) {
	    Deque<int[]> que = new ArrayDeque<>();
	    int t = 0;
	    
	    que.offer(new int[]{y,x,t});       // 위치, 시간
	    visit.add(y + "," + x + "," + t);
	    
	    while (!que.isEmpty()) {
	        int[] now = que.poll();

	        
	        if (now[2] != t) {
	            t++;
	            down();
	        }
	        	        
	       // System.out.println(Arrays.toString(now));
	       // print();
	        
	        for (int d=0; d<9; d++) {
	            int ny = now[0] + dy[d];
	            int nx = now[1] + dx[d];
	            if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || mat[ny][nx] == '#') continue;
	            if (ny != 0 && mat[ny-1][nx] == '#') continue;
	            String log = ny + "," + nx + "," + (now[2]+1);
	            if (visit.contains(log)) continue;
	            
	            que.offer(new int[]{ny,nx,now[2]+1});
	            visit.add(log);
	            
	            if (ny == 0 && nx == 7) return 1;       // 도달
	        }
	    }
	    
	    return 0;
	    
	}
	
	static void down() {
	    for (int i=7; i>0; i--) {
	        mat[i] = Arrays.copyOf(mat[i-1], 8);
	    }
	    for (int j=0; j<8; j++) {
	        mat[0][j] = '.';
	    }
	}
	
	// debug
	static void print() {
	    for (int i=0; i<8; i++) {
	        System.out.println(Arrays.toString(mat[i]));
	    }
	}

}