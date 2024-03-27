package algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 이진탐색을 통해 O(Nlogn)
// LIS 배열 <= 모든 수열의 수만큼 채워나가는 방식의 배열[3] <= 4번쨋수가 현재 만드는 LIS 의 길이 
// memoi 배열 <= 다 채울수도 있고 중간가지만 채울수도 있다. memoi[3] <= LIS 길이가 3을 만드는 가장 작은 수
// len = 0 시작, memoi[0] => len 1 증가, memoi[3] => len 1 증가 
public class sw_3307_최장증가부분수열_eg2 {
	
	static int T, N, len;
	static int[] input;
	static int[] memoi;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			// 풀이
			len = 0;
			// {1, 3, 2, ... }
			// {1, 3, 
			for (int i = 0; i < N; i++) {
				// bs(memoi, 0, 0, 1) return -1 <= index 0
				// bs(memoi, 0, 1, 3) return -2 <= index 1
				// bs(memoi, 0, 2, 2) return -2 <= index 1
				int pos = Arrays.binarySearch(memoi, 0, len, input[i]); // 리턴하는 값이 음수이면 이걸 리턴
				if (pos >= 0) continue;
				pos = Math.abs(pos) - 1;	// 새로 늘어나거나, 중간값을 바구거나 
				memoi[pos] = input[i];
				if ( len == pos ) len++;		// len == pos 의미는 새로 늘어난다. 이 조건에 안맞으면 중간값 변경
				
			}
			
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb);
	}

}
