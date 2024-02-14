import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프를 동시에 놓아햐 한다. (이전에 놓은 파이프가 다음 파이프에 영향을 미친다. 이미 파이프가 있는 자리에 놓을 수 없다.
// 왼쪽 --> 오른쪽 이동의 우선순위 우상 -> 우 -> 우하 <= 위에서 아래로 행을 옮기면서 파이프를 놓아 볼 것이므로
// visit <- 동일 좌표 재 방문 금지를 위해 사용, 이 문제의 경우는 필요 X
public class Main {
	static int R, C, ans;
	static char map[][];

	// dx 필요 x
	static int[] dy = { -1, 0, 1 }; // 우선순위

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 위에서 아래로 각 행별로 따진다.
		for (int i = 0; i < R; i++) {
			// dfs() 로 파이프를 놓아가는데 마지막(c-1)까지 도달하면 성공 return, 실패 false 리턴
			if (dfs(i, 0)) ans++;
		}

		System.out.println(ans);
	}

	static boolean dfs(int y, int x) {
		// 다음 좌표
		int nx = x + 1;	// 오른쪽 이동
		if (nx == C - 1) return true;
		
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			if (ny < 0 || ny >= R || map[ny][nx] == 'x')
				continue; // 범위 보호
			
			// 다음 방문에서 다시 방문하지 않도록
			map[ny][nx] = 'x';	// 성공해도 실패해도 방문 x
			if ( dfs(ny,nx) ) return true;
		}
		
		return false;
	}
}
