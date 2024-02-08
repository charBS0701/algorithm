import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(st.nextToken());	// (1 ≤ K ≤ 100 000)
		int N = Integer.parseInt(st.nextToken());	// (1 ≤ N ≤ 100 000)
		
		String[][] dic = new String[26][100000];
		for (int i = 0; i < dic.length; i++) {
			for (int j = 0; j < dic[i].length; j++) {
				dic[i][j] = "zzzzzzzzzzzzzzzzzzzzzzz"; // 정렬을 위해 올 수 있는 단어보다 큰 문자열로 채움
			}
		}
		int[] wordCnt = new int[26];
		
		for (int k = 0; k < K; k++) {	// 사전입력
			String s = br.readLine();
			char c = s.charAt(0);
			dic[c-'a'][wordCnt[c-'a']++] = s;
		}
		
		for (int i = 0; i < 26; i++) {
			Arrays.sort(dic[i], (a, b) -> {
				return a.compareTo(b);
			});
		}
		
		int[] callCnt = new int[26];	// 돌아가면서 불러야하는거 카운트
		
		for (int n = 0; n < N; n++) {
			char c = br.readLine().charAt(0);	// 찾을 알파벳
			
			sb.append(dic[c-'a'][callCnt[c-'a']++]).append("\n");
			if (callCnt[c-'a'] == wordCnt[c-'a']) callCnt[c-'a'] = 0;
			
		}
		
		System.out.println(sb);
	}
}
