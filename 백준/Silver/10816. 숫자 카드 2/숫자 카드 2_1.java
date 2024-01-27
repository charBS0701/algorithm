import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int[] table = new int[20_000_002]; 
		
		int N = Integer.parseInt(br.readLine());	//  N(1 ≤ N ≤ 500,000)
		st = new StringTokenizer(br.readLine());	// -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			table[num+10_000_000]++;
		}
		
		int M = Integer.parseInt(br.readLine());	// M(1 ≤ M ≤ 500,000)
		st = new StringTokenizer(br.readLine());	// -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
		
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(table[key+10_000_000] + " ");
		}
		System.out.println(sb);
		
	}
}
