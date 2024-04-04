import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int T, N;		
	static int result;
	static int[][] map, dis;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;		// 초기화
			N = Integer.parseInt(br.readLine());		// 지도의 크기는 최대 100 x 100이다.
			map = new int[N][N];
			dis = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dis[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}
			
			// 풀이
			bfs(0,0);
			
			// 출력
			sb.append("#").append(t).append(" ").append(dis[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int y, int x) {
		PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
		que.offer(new int[] {y,x,map[y][x]});	// 시작지 0,0,0 인큐
		
		while (! que.isEmpty() ) {
			int[] now = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
				int newDis = now[2] + map[ny][nx];
				if (newDis >= dis[ny][nx]) continue;
				dis[ny][nx] = newDis;
				que.offer(new int[] {ny,nx,newDis});
			}
		}
	}
}
