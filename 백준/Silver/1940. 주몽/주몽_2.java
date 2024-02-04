import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// two pointers
public class Main {

	static int N, M;
	static int arr[];
	static int idx1 = 0;
	static int idx2;
	static int result = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine()); // 재료의 개수 1~15,000
		M = Integer.parseInt(br.readLine()); // 완성 요건 1~10,000,000
		arr = new int[N];
		idx2 = N-1;
		
		// 재료 고유번호 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		while(idx1 < idx2) {
			if (arr[idx1] + arr[idx2] == M) {	// 요건에 부합할 때 
				result++;
				idx1++;
				idx2--;
			} else if (arr[idx1] + arr[idx2] < M) {	// 요건보다 작을 때
				idx1++;
			} else if (arr[idx1] + arr[idx2] > M){	// 요건보다 클 때 
				idx2--;
			}
		}
		System.out.println(result);

	}

}
