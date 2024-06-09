import java.io.*;
import java.util.*;

public class Main {

	static int[] answers = new int[10];
	static int result;
	static int[] tgt = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			answers[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0);
		
		System.out.println(result);
	}
	
	static void solve(int idx) {
		if (idx == 10) {
			if(isPass()) result++;
			return;
		}
		
		for (int i = 1; i <= 5; i++) {	// 영재의 정답
			if (idx >= 2 && i == tgt[idx-1] && i == tgt[idx-2]) {
				continue;
			}
			tgt[idx] = i;
			solve(idx+1);
		}
		
	}
	
	static boolean isPass() {
		int score=0;
		for (int i = 0; i < 10; i++) {
			if (answers[i] == tgt[i]) score++;
		}
		
		if (score >= 5) return true;
		return false;
	}
}
		

