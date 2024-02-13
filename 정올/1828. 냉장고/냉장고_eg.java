package basic;
// 클래스 대신 2차원 배열 사용, 정렬에 lambda 사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 냉장고_eg {

	static int N, count;
	static int[][] input;		// input[i][0] : i번째 물질의 최저온도, input[i][1] : i 번째 물질의 최고온도
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());		// 최저
			input[i][1] = Integer.parseInt(st.nextToken());		// 최고
		}
		// 최고 온도 기준으로 배열 정렬
		Arrays.sort(input, (o1, o2) -> o1[1] - o2[1]); // 최고 온도 기준으로 정렬
		
		int max = Integer.MIN_VALUE; // max 값 초기화
		count = 0;
		for (int i = 0; i < N; i++) {	
			if (input[i][0] > max) {	// 새로운 냉장고가 필요
				count++;	// 냉장고 수 증가
				max = input[i][1];	// 새로운 물질의 최고 온도로 max 갱신
			}
		}
		System.out.println(count);
	}
}
