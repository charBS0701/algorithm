import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, M;
    static boolean[][] mat, visit;
    static int[] dy = new int[]{0,1};
    static int[] dx = new int[]{1,0};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new boolean[M][N];
		
		for (int m=0; m<M; m++) {
		    st = new StringTokenizer(br.readLine());
		    for (int n=0; n<N; n++) {
		        mat[m][n] = st.nextToken().equals("1") ? true : false;
		    }
		}
		
		bfs();
		
	}
	
	static void bfs() {
	    Deque<int[]> que = new ArrayDeque<>();
	    visit = new boolean[M][N];
	    
	    que.offer(new int[]{0,0});
	    visit[0][0] = true;
	    
	    while (!que.isEmpty()) {
	        int[] now = que.poll();
	        if (now[0] == M-1 && now[1] == N-1) {
	            System.out.println("Yes");
	            return;
	        }
	        
	        for (int d=0; d<2; d++) {
	            int ny = now[0] + dy[d];
	            int nx = now[1] + dx[d];
	            
	            if (ny < 0 || nx < 0 || ny >= M || nx >= N || !mat[ny][nx] || visit[ny][nx]) continue;
	            
	            que.offer(new int[]{ny,nx});
	            visit[ny][nx] = true;
	        }
	    }
	    
	    System.out.println("No");
	    
	}
}