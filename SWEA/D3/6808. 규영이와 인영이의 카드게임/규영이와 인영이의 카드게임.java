import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	static int[] cards = new int[9];
	static int[] oppos = new int[9]; // 상대 카드
	static int myScore;
	static int yourScore;
	static boolean[] select = new boolean[9];
	static int[] tgt = new int[9];

	static int win, lose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			win = lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}
			int[] copy = new int[9];
			System.arraycopy(cards, 0, copy, 0, 9);
			Arrays.sort(copy);

			int num = 1;
			for (int i = 0; i < 9; i++) {
				if (Arrays.binarySearch(copy, num) < 0) { // 해당 값이 없으면
					oppos[i] = num++;
				} else {
					num++;
					i--;
				}
			}

			perm(0);

			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}

		System.out.println(sb);

	}

	static void perm(int tgtIdx) {
		if (tgtIdx == 9) { // 순열 완성
			myScore = 0;
			yourScore = 0;

			for (int i = 0; i < 9; i++) { // 승패계산
				int me = cards[i];
				int you = tgt[i];
				if (me > you)
					myScore += me + you;
				else if (me < you)
					yourScore += me + you;
			}
			if (myScore > yourScore)
				win++;
			else if (yourScore > myScore)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			// 현재 src 중 이미 이전에 사용된 수는 제외
			if (select[i])
				continue;
			// src 의 i 번째 항목은 아직 tgt 에 사용되지 X

			tgt[tgtIdx] = oppos[i]; // 선택 !
			select[i] = true;
			perm(tgtIdx + 1); // 현재 i 번째 선택을 이어서 다음 자리를 채우러 재귀호출
			select[i] = false;

		}
	}
}
