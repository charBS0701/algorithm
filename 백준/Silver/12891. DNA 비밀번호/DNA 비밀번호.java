import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S;	// 임의 문자열 길이	(1 ≤ |P| ≤ |S| ≤ 1,000,000)
	static int P;	// 부분문자열 길이
	static char[] dna;
	static int[] req = new int[4];
	static int result=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna = br.readLine().toCharArray();	//	dna 입력
		
		st = new StringTokenizer(br.readLine());	// 최소요건 입력
		req[0]=Integer.parseInt(st.nextToken());	// A
		req[1]=Integer.parseInt(st.nextToken());	// C
		req[2]=Integer.parseInt(st.nextToken());	// G
		req[3]=Integer.parseInt(st.nextToken());	// T
		
		for (int i = 0; i < P; i++) {		//  첫 부분 문자열 검사
			if (dna[i] == 'A') req[0]--;
			else if (dna[i] == 'C') req[1]--;
			else if (dna[i] == 'G') req[2]--;
			else if (dna[i] == 'T') req[3]--;
		}
				
		check();	// 비밀번호 가능 체크
		for (int i = 1; i+P-1 < S; i++) {
			if (dna[i-1] == 'A') req[0]++;
			else if (dna[i-1] == 'C') req[1]++;
			else if (dna[i-1] == 'G') req[2]++;
			else if (dna[i-1] == 'T') req[3]++;
			if (dna[i+P-1] == 'A') req[0]--;
			else if (dna[i+P-1] == 'C') req[1]--;
			else if (dna[i+P-1] == 'G') req[2]--;
			else if (dna[i+P-1] == 'T') req[3]--;
			check();
		}
		// // P 이후 한 개씩 처리
		// // 이전 P개 중 맨 앞 문자는 제거, 새문자가 맨 뒤에 추가
		// for (int i = P; i < S; i++) {	// 이렇게도 가능
		// 	cnt[dna[i - P] - 'A']--;
		// 	cnt[dna[i] - 'A']++;
		// 	check();
		// }
				
		System.out.println(result);
	}
	public static void check() {
		for (int n : req) {
			if (n>0) return;
		}
		result++;
	}
}
