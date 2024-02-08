import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] come;
	static int[] go;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		come = new int[N];
		go = new int[N];
		for (int i = 0; i < N; i++) { // 각 학생이
			st = new StringTokenizer(br.readLine());
			come[i] = Integer.parseInt(st.nextToken()); // 학교 오는 시간
			go[i] = Integer.parseInt(st.nextToken()); // 떠나는 시간
		}

		// 제일 늦게 오는 팬의 시간 - 제일 처음 떠나는 팬의 시간 구하기
		// 음수면 0 으로
		int result = Arrays.stream(come).max().getAsInt() - Arrays.stream(go).min().getAsInt();
		System.out.println(result<0 ? 0 : result);

	}

}
