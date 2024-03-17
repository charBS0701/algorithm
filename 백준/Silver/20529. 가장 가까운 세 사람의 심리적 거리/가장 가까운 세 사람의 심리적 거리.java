import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 3~100_000
			int min = Integer.MAX_VALUE;
			int tmp = Integer.MAX_VALUE;
			arr = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (N > 16*3) {
				sb.append(0).append("\n");
				continue;
			}
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = i+1; j < N-1; j++) {
					for (int j2 = j+1; j2 < N; j2++) {
						tmp = calc(i,j,j2);
						min = Math.min(min, tmp);
					}
				}
			}
			
			sb.append(min).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static int calc(int i, int j, int j2) {
		int cnt = 0;
		String s1 = arr[i];
		String s2 = arr[j];
		String s3 = arr[j2];
		
		for (int k = 0; k < 4; k++) {
			if (s1.charAt(k) != s2.charAt(k)) cnt++;
			if (s1.charAt(k) != s3.charAt(k)) cnt++;
			if (s2.charAt(k) != s3.charAt(k)) cnt++;
		}
		
		return cnt;
	}
}
