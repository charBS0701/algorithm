import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int cnt;
	static int[] pi;
	static String T, P;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();

		kmp();
		System.out.println(cnt);
		System.out.println(sb);
	}

	// 텍스트 에서 pattern 찾기
	static void kmp() {
		getPI();

		int tLength = T.length();
		int pLength = P.length();

		char[] tArray = T.toCharArray();
		char[] pArray = P.toCharArray();

		int j = 0;
		for (int i = 0; i < tLength; i++) { // j와 i모두 맨 처음부터 비교
			while (j > 0 && pArray[j] != tArray[i])
				j = pi[j - 1];
			if (pArray[j] == tArray[i]) {
				// 전체 검색어가 일치하는 상황 => 답 구성
				// 전체가 일치하지 않은 부분 일치 상황 => 계속 진행 (j 증가, i는 for 문에서 증가)
				if (j == pLength - 1) {
					cnt++;
					sb.append(i - j + 1).append(" ");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	static void getPI() {
		// PI 생성
		pi = new int[P.length()]; // pattern p 배열과 동일한 길이
		char[] pArray = P.toCharArray(); // pattern p 를 이용한 char 배열

		int j = 0;
		for (int i = 1; i < pArray.length; i++) {
			while (j > 0 && pArray[j] != pArray[i])
				j = pi[j - 1]; // 불일치하면 이전 일치한 상태로 복귀(접두사 위치)
			if (pArray[i] == pArray[j])
				pi[i] = ++j; // 접두사 == 접미사 일치
		}
	}
}
