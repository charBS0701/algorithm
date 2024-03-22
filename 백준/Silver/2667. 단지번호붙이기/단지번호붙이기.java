import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N;
	static int map[][];
	static boolean visit[][];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int count;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String r = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(r.charAt(j));
			}
		}

		// 풀이
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 0;
				if (visit[i][j] || map[i][j] == 0)
					continue;
				dfs(i, j);
				list.add(count);
			}
		}

		list.sort((o1, o2) -> o1 - o2);

		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		count++;

		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (!isValid(ny, nx) || visit[ny][nx] || map[ny][nx] == 0)
				continue;
			dfs(ny, nx);
		}

	}

	static boolean isValid(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= N)
			return false;
		return true;
	}

}
