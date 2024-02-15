import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int H, W;
	static char[][] map;
	static int N;
	static char[] command;
	static int loc[] = new int[2]; // 탱크 위치
	static char dir; // 탱크 방향
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			N = Integer.parseInt(br.readLine());
			command = br.readLine().toCharArray();
			// 입력 끝
			// 초기상태 파악
			for (int i = 0; i < H; i++) {
				boolean flag = false; // 탱크 찾음
				for (int j = 0; j < W; j++) {
					char now = map[i][j];
					if (now == '^' || now == 'v' || now == '<' || now == '>') {
						loc[0] = i;
						loc[1] = j;
						switch (now) {
						case '^':
							dir = 'u';
							break;
						case 'v':
							dir = 'd';
							break;
						case '<':
							dir = 'l';
							break;
						case '>':
							dir = 'r';
							break;
						}
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			for (int i = 0; i < N; i++) {
				char c = command[i];
				if (c == 'U') {
					dir = 'u';
					map[loc[0]][loc[1]] = '^';
					int ny = loc[0] - 1;
					if (ny >= 0 && map[ny][loc[1]] == '.') { // 한칸위 평지면
						map[ny][loc[1]] = '^'; // map 업데이트
						map[loc[0]][loc[1]] = '.';
						loc[0] = ny;
					}
				} else if (c == 'D') {
					dir = 'd';
					map[loc[0]][loc[1]] = 'v';
					int ny = loc[0] + 1;
					if (ny < H && map[ny][loc[1]] == '.') { // 아래가 평지면
						map[ny][loc[1]] = 'v'; // map 업데이트
						map[loc[0]][loc[1]] = '.';
						loc[0] = ny;
					}
				} else if (c == 'L') {
					dir = 'l';
					map[loc[0]][loc[1]] = '<';
					int nx = loc[1] - 1;
					if (nx >= 0 && map[loc[0]][nx] == '.') { // 왼쪽이 평지면
						map[loc[0]][nx] = '<'; // map 업데이트
						map[loc[0]][loc[1]] = '.';
						loc[1] = nx;
					}
				} else if (c == 'R') {
					dir = 'r';
					map[loc[0]][loc[1]] = '>';
					int nx = loc[1] + 1;
					if (nx < W && map[loc[0]][nx] == '.') { //
						map[loc[0]][nx] = '>'; // map 업데이트
						map[loc[0]][loc[1]] = '.';
						loc[1] = nx;
					}
				} else if (c == 'S') { // 포탄발사
					int px = loc[1], py = loc[0]; // 포탄의 위치
					int[] dp = new int[2]; // 포탄의 방향
					switch (dir) {
					case 'u':
						dp[0] = -1;
						dp[1] = 0;
						break;
					case 'd':
						dp[0] = 1;
						dp[1] = 0;
						break;
					case 'l':
						dp[0] = 0;
						dp[1] = -1;
						break;
					case 'r':
						dp[0] = 0;
						dp[1] = 1;
						break;
					}
					
					int npx = px + dp[1];	// 다음 포탄 위치
					int npy = py + dp[0];	// 다음 포탄 위치
					while (true) { // 포탄이 나아간다
						// 맵밖으로 나가면 break;
						if (npx < 0 || npy < 0 || npx >= W || npy >= H) break;	// 맵나갈 때
						if (map[npy][npx] == '#') break;	// 강철벽에 닿을 때
						if (map[npy][npx] == '*') {
							map[npy][npx] = '.';
							break;
						}
						npx += dp[1];
						npy += dp[0];
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}