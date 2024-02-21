import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] alpha;
	static ArrayList<Character> mo;
	static ArrayList<Character> ja;
	static char[] tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		alpha = new char[C];
		mo = new ArrayList<>();
		ja = new ArrayList<>();
		tgt = new char[L];
		for (int i = 0; i < C; i++) { // 입력
			alpha[i] = st.nextToken().charAt(0);
			if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')
				mo.add(alpha[i]);
			else
				ja.add(alpha[i]);
		}
		Arrays.sort(alpha);
		
		combs(0,0);
		
		System.out.println(sb);
	}
	
	static void combs(int srcIdx, int tgtIdx) {
		if (tgtIdx == L) {
			// L 개를 골랐는데 mo 에서 2개 1개이상, ja 에서 2개 이상이 아니면 pass
			int moCnt=0;
			int jaCnt=0;
			for (int i = 0; i < L; i++) {
				char now = tgt[i];
				if (mo.contains(now)) moCnt++;
				else if (ja.contains(now)) jaCnt++;
			}
			if (moCnt < 1 || jaCnt < 2) return;
			sb.append(tgt).append("\n");
			return;
		}
		
		if (srcIdx == C) return;
		
		tgt[tgtIdx] = alpha[srcIdx];
		
		combs(srcIdx+1,tgtIdx+1);
		combs(srcIdx+1,tgtIdx);
	}

}
