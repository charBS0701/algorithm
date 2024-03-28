import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visit; // 3번재 취득한 key 상태
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<Node> que = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M][1 << 6]; // 001[000000] 0 6개를 각각 abcdef 취득 여부

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if (ch == '0') {
					// Que 에 담고 시작
					visit[i][j][0] = true;
					que.offer(new Node(i, j, 0, 0));
				}
			}
		}
		// 풀이
		bfs();
		System.out.println(ans);

	}

	static void bfs() {
		while( ! que.isEmpty() ) {
			Node node = que.poll();
			
			// 탈출좌표
			if (map[node.y][node.x]== '1') {
				ans = node.d;
				return;
			}
			
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if (ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx] == '#') continue;
				
				int key = node.key; 	// 현재 Node 의 취득 key	( bitmasking )
				
				// key 취득 경우
				if ( 'a' <= map[ny][nx] && map[ny][nx] <= 'f') { 
					// 000000 | 1 << 0 => 000000 | 000001 => 000001 <= 'a' key 취득
					// 000000 | 1 << 1 => 000000 | 000010 => 000010 <= 'b' key 취득
					// 000011 | 1 << 4 => 000011 | 010000 => 010011 <= 'a', 'b' key 에서 'e' 취득
					key |= ( 1 << (map[ny][nx] - 'a' ) );
				}
				
				// 문을 만나는 경우
				if ( 'A' <= map[ny][nx] && map[ny][nx] <= 'F') {
					if ( (key & ( 1 << (map[ny][nx] - 'A'))) == 0) continue;
				}
				
				if ( visit[ny][nx][key] ) continue;
				
				visit[ny][nx][key] = true;
				
				que.offer(new Node(ny, nx, key, node.d + 1));
				
			}
		}
		
		ans = -1;	// 출구를 못 찾은 경우
	}

	static class Node {
		int y, x, key, d;

		public Node(int y, int x, int key, int d) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = d;
		}

	}
}
