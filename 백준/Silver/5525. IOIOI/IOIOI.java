import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M, result;
	static int I, O, iCnt, oCnt;
	static String S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 1 ≤ N ≤ 1,000,000
		M = Integer.parseInt(br.readLine());	// 2N+1 ≤ M ≤ 1,000,000
		S = br.readLine();
		
		I = N+1;
		O = N;
		
		for (int i = 0; i < M; i++) {
			char c = S.charAt(i);
			
			if (c == 'I') {
				if (i==0) iCnt++;
				else {
					char prev = S.charAt(i-1);
					if (prev == 'I') {
						init();
						iCnt++;
					} else if (prev == 'O') {
						iCnt++;
					}
				}
			} else if (c == 'O') {
				if (i==0) init();
				else {
					char prev = S.charAt(i-1);
					if (prev == 'I') {
						oCnt++;
					} else if( prev == 'O') {
						init();
					}
				}
			}
			
			if (iCnt == I && oCnt == O) {	// 찾음
				result++;
				iCnt--;
				oCnt--;
			}
		}
		
		// 출력
		System.out.println(result);
	}
	
	static void init() {
		iCnt = 0;
		oCnt = 0;
	}
	
}