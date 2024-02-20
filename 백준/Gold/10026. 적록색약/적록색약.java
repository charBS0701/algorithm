import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static int RGBcnt;
	static int RBcnt;
	
	static int[] dy = {-1,1,0,0};	// 상하좌우
	static int[] dx = {0,0,-1,1};	// 상하좌우
	static boolean RGBvisited[][];
	static boolean RBvisited[][];
	static boolean visited[][];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		RGBvisited = new boolean[N][N];
		RBvisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (RGBvisited[i][j]) continue;
				bfs(i,j,1);
				RGBcnt++;
			}
		}		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (RBvisited[i][j]) continue;
				bfs(i,j,2);
				RBcnt++;
			}
		}		
		
		sb.append(RGBcnt).append(" ").append(RBcnt);
		System.out.println(sb);
	}
	
	static void bfs(int r, int c, int type) {
		Queue<Dot> que = new ArrayDeque<>();
		que.offer(new Dot(r,c,map[r][c]));
		if (type==1) {
			visited = RGBvisited;
		} else if (type == 2) {
			visited = RBvisited;
		}
		visited[r][c] = true;
		
		while (!que.isEmpty()) {
			Dot now = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = now.r + dy[d];
				int nx = now.c + dx[d];
				if (ny < 0 || nx < 0 || ny>=N || nx >= N || visited[ny][nx]) continue;
				
				if (type==1) {	// 정상인일 때
					if (map[ny][nx] != now.color) continue;

				} else if (type==2) {	// 적록색약일 때
					if (now.color == 'R' || now.color == 'G') {	// 현재구역이 RG일 때
						if (map[ny][nx] == 'B') continue;
					} else if (now.color == 'B') {				// 현재구역이 B일 때
						if (map[ny][nx] != 'B') continue;
					}
				}
				
				// 어떤 경우에도 상관 없이
				que.offer(new Dot(ny,nx,map[ny][nx]));
				visited[ny][nx] = true;
			}
		}
	}
	
	static class Dot{
		int r,c;
		char color;
		
		public Dot(int r, int c, char color) {
			this.r=r;
			this.c=c;
			this.color=color;
		}
	}
}
