import java.io.*;
import java.util.*;

public class Main {

	static int N, K; // N:1~200_000, K:0~1_000_000
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = br.readLine().toCharArray();

		int idx = 0;
		while (K > 0) {
			if (arr[idx] == 'A' && idx < N - 1) {	// 끝 칸 아닌데 A 이면 
				idx++;
				continue;
			} else if (idx < N - 1 && 'Z' < (arr[idx] + K)) { // 끝 칸 아니고 해당 라인에서 돌리는게 이득일 때
				K -= 'Z' - (arr[idx]) + 1;
				arr[idx] = 'A';
				idx++;
				continue;
			} else if (idx < N - 1) { // 이 칸에서 못돌 리는데 맨 끝칸 아니면
				idx++;
				continue;
			}

			// 맨 끝 칸에서는 그냥 돌려야한다
			arr[idx]++;
			if (arr[idx] > 'Z')
				arr[idx] = 'A';
			K--;
		}

		System.out.println(String.valueOf(arr));

	}
}