import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Set<Integer> list = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());	//  N(1 ≤ N ≤ 100,000)
		st = new StringTokenizer(br.readLine());	// 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.
		for (int n = 0; n < N; n++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());	// M(1 ≤ M ≤ 100,000)
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int m = 0; m < M; m++) {
			int result = list.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}
}