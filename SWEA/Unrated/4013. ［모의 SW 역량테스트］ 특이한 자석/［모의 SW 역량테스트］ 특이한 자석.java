import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, K, result;
	static int[][] magnets, newMagnets;
	static int[][] rotates; // 타겟자석, 방향
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			result = 0;
			magnets = new int[4][8];

			K = Integer.parseInt(br.readLine());
			rotates = new int[K][2];
			for (int i = 0; i < 4; i++) { // 자석 정보
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) { // 회전 정보
				st = new StringTokenizer(br.readLine());
				int target = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				rotates[i][0] = target;
				rotates[i][1] = dir;
			}

			// 풀이
			for (int k = 0; k < K; k++) {
				proceed(k);
			}

			// 점수 산출
			for (int i = 0; i < 4; i++) {
				result += magnets[i][0] == 0 ? 0 : (1 << i);
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}

	static void proceed(int k) {
		newMagnets = new int[4][8]; // 초기화
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				newMagnets[i][j] = magnets[i][j];
			}
		}

		// 타겟 회전
		int target = rotates[k][0];
		int dir = rotates[k][1];
		rotate(target, dir);

		// 양 옆 회전하는지 확인
		int tmpDir = dir;
		int comp = target;

		while (comp < 3) {
			if (alsoRotate(comp, comp + 1)) { // 오른쪽 자석 확인 // 다른 극이 닿아있는지
				rotate(comp + 1, tmpDir == -1 ? 1 : -1);
				comp++;
				tmpDir = tmpDir == -1 ? 1 : -1;
			} else
				break;
		}

		comp = target;
		tmpDir = dir;

		while (comp > 0) {
			if (alsoRotate(comp - 1, comp)) { // 왼쪽 자석 확인
				rotate(comp - 1, tmpDir == -1 ? 1 : -1);
				comp--;
				tmpDir = tmpDir == -1 ? 1 : -1;
			} else
				break;
		}

		// 회전 결과 업데이트
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				magnets[i][j] = newMagnets[i][j];
			}
		}
	}

	static boolean alsoRotate(int target, int targetRight) {
		if (magnets[target][2] != magnets[targetRight][6])
			return true;
		else
			return false;
	}

	static void rotate(int target, int dir) {
		if (dir == 1) { // 시계방향회전
			newMagnets[target][0] = magnets[target][7];
			for (int i = 1; i < 8; i++) {
				newMagnets[target][i] = magnets[target][i - 1];
			}
		} else if (dir == -1) { // 시계반대회전
			newMagnets[target][7] = magnets[target][0];
			for (int i = 0; i < 7; i++) {
				newMagnets[target][i] = magnets[target][i + 1];
			}
		}
	}

}
