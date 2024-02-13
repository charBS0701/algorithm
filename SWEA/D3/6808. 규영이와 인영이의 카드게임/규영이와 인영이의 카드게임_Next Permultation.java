package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 규영이의 카드는 fix
// 인영이의 카드를 다양한 순열로 완탐.
// Next Permultation 
public class 규영이와인영이의카드게임_eg3 {

	static int T, win, lose, N = 9;
	static int[] input = new int[19]; // 0 dummy, 규영이의 카드 입력을 여기에 표시, => 인영이의 카드 구성
	static int[] guCard = new int[9]; // 0 dummy <= 고정
	static int[] inCard = new int[9]; // 0 dummy <= 다양한 순열 src
//	static int[] tgt = new int[9]; // inCard => tgt 순열 완탐 결과 저장
//	static boolean[] select = new boolean[N];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 변수 초기화
			win = lose = 0;
			Arrays.fill(input, 0);

			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 규영이 카드 처리
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				input[num] = 1;
				guCard[i] = num;
			}
			// 인영이 카드 처리 <= 인영이 카드는 input 배열에 0 으로 남은 index
			num = 0;
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0) {
					inCard[num++] = i;
				}
			}
			
			// 가장 작은 수로 정렬 <= 경우의 하나 (이미 정렬되어 있다.)
			while (true) {
				check();
				if ( ! np(inCard) ) break;	// 가장 큰수임
				
			}

			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	// np(), swap()
	static boolean np(int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;

		// 맨 앞, 중간
		if (i == 0)
			return false; // 현재가 가장 큰 수, 더 이상 새로운 더 큰 수를 만들 수 없다.

		// 더 큰 수를 만들 수 있다.
		int j = array.length - 1;
		while (array[i - 1] >= array[j])
			j--;
		swap(array, i - 1, j);

		// 뒤쪽 정리
		int k = array.length - 1;
		while (i < k)
			swap(array, i++, k--);

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void check() {
		int guSum = 0;
		int inSum = 0;

		for (int i = 0; i < guCard.length; i++) {
			if (guCard[i] > inCard[i])
				guSum += guCard[i] + inCard[i];
			else
				inSum += guCard[i] + inCard[i];
		}
		if (guSum > inSum)
			win++;
		else if (guSum < inSum)
			lose++;

	}
}
