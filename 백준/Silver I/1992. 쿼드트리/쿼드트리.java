import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		solve(0, 0, N);
		
		System.out.println(sb);
	}

	static void solve(int x, int y, int n) {
		boolean is1 = true;
		boolean is0 = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[y+i][x+j] == '1')
					is0 = false;
				if (map[y+i][x+j] == '0')
					is1 = false;
			}
		}
		if (is1) {
			sb.append(1);
			return;
		}
		else if (is0) {
			sb.append(0);
			return;
		}
		else if (is1 == false && is0 == false) {
			sb.append("(");
			solve(x, y, n / 2);						// 왼쪽위
			solve(x + n / 2, y, n / 2);				// 오른쪽위
			solve(x, y + n / 2, n / 2);				// 왼쪽아래
			solve(x + n / 2, y + n / 2, n / 2);		// 오른쪽아래
			sb.append(")");
		}
	}

}
