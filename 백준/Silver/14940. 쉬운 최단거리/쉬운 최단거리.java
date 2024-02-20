import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int map[][];
	static int visited[][];
	static int x,y;	// 시작지점
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0; i < n; i++) {		// 맵 입력
			st = new StringTokenizer(br.readLine());
			Arrays.fill(visited[i], -1);	// 도달할 수 없는 위치로 초기화
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x,y,0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) visited[i][j] = 0;
				sb.append(visited[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void bfs(int r, int c, int dist) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {r,c,dist});
		visited[r][c] = dist;
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny<0 || nx<0 || ny>=n || nx>=m) continue;	// 범위제한
				if (map[ny][nx]==0) visited[ny][nx] = 0;	// 원래갈 수 없는 땅은 0
				if (map[ny][nx]==1 && visited[ny][nx] == -1) {	// 갈 수있는 땅이고 방문하지 않았다면
					que.offer(new int[] {ny,nx,now[2]+1});
					visited[ny][nx] = now[2]+1;	// 시작지점에서부터의 거리 입력
				}
				
			}
		}
		
		
	}

}
