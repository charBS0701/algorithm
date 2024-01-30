import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[][] mat = new char[100][100];
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine()); // 테스트케이스 번호
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					mat[r][c] = st.nextToken().charAt(0);
				}

			}
			findWinner();
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void findWinner() {
		// 마지막 줄에서 2 찾기
		int start = 0;
		for (int i = 0; i < 100; i++) {
			if (mat[99][i] == '2') {
				start = i;
				break;
			}
		}

		// 위로 올라가다가 왼쪽에 1 있으면 꺾기 반복
		int r = 99;
		int c = start;
		while (true) {
			if (r == 0) { // 끝까지 올라갔으면 그 c 가 result
				result = c;
				return;
			} else if (c - 1 >= 0 && mat[r][c - 1] == '1') { // 왼쪽 사다리로 이동
				while (c - 1 >= 0 && mat[r][c - 1] == '1') {
					c--;
				}
			} else if (c + 1 < 100 && mat[r][c + 1] == '1') { // 오른쪽 사다리로 이동
				while (c + 1 < 100 && mat[r][c + 1] == '1') {
					c++;
				}
			}
			if (r - 1 >= 0 && mat[r - 1][c] == '1') { // 위로 이동
				r--;
			}
		}
	}

}
