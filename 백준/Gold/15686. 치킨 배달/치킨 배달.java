import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int ckdis = Integer.MAX_VALUE; // 치킨거리
	static List<int[]> homes = new ArrayList<>(); // 집 리스트
	static List<int[]> cks = new ArrayList<>(); // 치킨집 리스트
	static List<int[]> ckCombs = new ArrayList<>(); // M 개 원소의 치킨집 조합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 줄 수
		M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 최대 치킨집 수
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) { // 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					homes.add(new int[] { i, j });
				else if (map[i][j] == 2)
					cks.add(new int[] { i, j });
			}
		}

		// 조합을 만들며 최소치킨거리 구하기
		combs(0, 0);

		System.out.println(ckdis);

	}

	// 마을의 치킨거리구하기
	static int getCkDist() {
		int distSum = 0;
		for (int[] tmpHome : homes) {
			int dist = Integer.MAX_VALUE;
			for (int[] tmpCk : ckCombs) {
				// 한 집 씩 치킨거리의 최소를 구한다
				dist = Math.min(dist, Math.abs(tmpHome[0] - tmpCk[0]) + Math.abs(tmpHome[1] - tmpCk[1]));
			}
			distSum += dist;
		}

		return distSum;
	}

	// 폐업시키지 않을 치킨집 조합
	static void combs(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			int res = getCkDist();
			ckdis = Math.min(ckdis, res);
			return;
		}

		if (srcIdx == cks.size())
			return;

		ckCombs.add(cks.get(srcIdx));

		combs(srcIdx + 1, tgtIdx + 1);
		ckCombs.remove(ckCombs.size()-1);	// 배열이 아니므로 삭제(비선택)처리를 해야함
		combs(srcIdx + 1, tgtIdx);

	}

}
