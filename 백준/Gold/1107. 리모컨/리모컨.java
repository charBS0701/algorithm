import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // N (0 ≤ N ≤ 500,000)
	static int now = 100;
	static boolean button[] = new boolean[10];
	static int count, pCount, mCount; // 카운트, ++로 이동했을때/--로 이동했을 때 카운트
	static int candidateCnt1, candidateCnt2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				button[Integer.parseInt(st.nextToken())] = true; // 고장난 버튼 표시
			}
		}

		// 풀이
		if (N == now) {
			System.out.println(0);
			return;
		}

		// ++ 또는 --로 걸리는 시간 구하기
		if (N > 100) {
			pCount = N - 100;
		} else if (N < 100) {
			mCount = 100 - N;
		}

		candidateCnt1 = pCount == 0 ? mCount : pCount;

		if (M == 10) {
			System.out.println(candidateCnt1);
			return;
		}
		
		// 누를 수 있느 수 중, N 과 가장 가까운 숫자 구하기
		int underN = N;
		int overN = N;
		while (true) {
			if (underN >= 0 && ispossible(underN) != 0) {
				count = ispossible(underN);
				break;
			} else if (ispossible(overN) != 0) {
				count = ispossible(overN);
				break;
			}
			underN--;
			overN++;
		}

		candidateCnt2 = Math.min(Math.abs(N - underN), Math.abs(N - overN)) + count;
		System.out.println(Math.min(candidateCnt1, candidateCnt2));

	}

	static int ispossible(int n) {
		int count = 0; // 자리수
		if (n == 0 && count == 0 && button[0] == false)
			return 1;
		while (n != 0) {
			if (button[n % 10] == true)
				return 0;
			else {
				n /= 10;
				count++;
			}
		}
		return count;
	}
}
