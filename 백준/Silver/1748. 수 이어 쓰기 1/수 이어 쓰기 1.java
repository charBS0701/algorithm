import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 0;
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i*=10) {
			result += N - i + 1; 
		}
		
		System.out.println(result);
	}
}
