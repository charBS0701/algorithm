import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;		// (5 ≤ N, M ≤ 100)
	static int map[][];
	static boolean visit[][];
	static int cheeseCnt[][];
	static int hour;
	static boolean check;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; 
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이
		while(true) {
			check = false;
			cheeseCnt = new int[N][M];
			visit = new boolean[N][M];
			bfs(0,0);			
			if (!check) {
				break;
			}
			hour++;
			
		}
		
		System.out.println(hour);

	}
	static void bfs(int y, int x) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {y,x});
		visit[y][x] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			y = now[0];
			x = now[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (isValid(ny,nx) && !visit[ny][nx] && map[ny][nx] == 0) {	// 처음방문하는 빈공간
					visit[ny][nx] = true;
					que.offer(new int[] {ny,nx});
				} else if (isValid(ny,nx) && map[ny][nx] == 1) { 	// 겉 치즈 방문
					cheeseCnt[ny][nx]++;	// 치즈 방문 카운트 증가
				}
			}
		}
		
		// 2번 이상 방문 치즈 없어짐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheeseCnt[i][j] >= 2) {
					map[i][j] = 0;
					check = true;
				}
			}
		}
		
	}
	
	static boolean isValid(int y, int x) {
		if (y>=0 && y<N && x>=0 && x<M) return true;
		else return false;
	}
}
