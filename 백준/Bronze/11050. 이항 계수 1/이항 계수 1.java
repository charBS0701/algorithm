import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = 1;
		// N~ (N-k)   곱해
		// k! 나눠
		for (int n = N; n > N-K; n--) {
			result *= n;
		}
		for (int k = 1; k <= K; k++) {
			result /= k;
		}
		System.out.println(result);
		
	}
		
}
