import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N 이 주어지면 ( 2<= N <= 16) <= 순열 <= 단순한 순열로 풀면 시간 초과
// BitMasking + Memoi

// #1 1-2-3-4-5 도시
// 		1-3-2-5-4-1 처럼 순환구조이므로 왼쪽의 방문의 결과(비용)는 3-2-5-4-1-3 ... 모두 같다.
// 		결과적으로 1번 도시에서 출발하는 경우만 따지면 된다. ! 수 감소

// #2 현재까지 방문한 도시 -> BitMasking
//		0001 => 1번 도시 방문
//		1010 => 2번 4번 도시 방문
//		정수 1개로 최대 N 개 도시의 방문여부를 표현 문제 X 

// #3 순열의 경우의 수를 줄이기 위해 memoization 활용 ???
//		memoi[i][j] <= 현재 i번째 도시를 방문, 거쳐온 도시가 BitMasking (j) 로 표현
//						<= value ?? 남은 도시를 방문하는 최소 비용
// 1,2,3,4,5,6,7 도시가 있을 때
// memoi[3][1100101] => 1,3,6,7 도시를 방문, 현재는 3 일 때, 남은 도시 2, 4, 5 를 방문하는 최소 비용
// memoi[3][1100101] = 100 이라면, 3 전에 방문한 1,6,7 의 방문순서와 상관없이 동일

// memoi[3][1100101] 의 값은 남은 2,4,5 를 다음으로 각각 방문하는 과정의 최소비용으로 갱신
// 위 값은 아래 3개의 값 중 최소값을 선택
//	  3 ->  2 비용 + memoi[2][1100111]
// 	  3 -> 4 비용 + memoi[4][1101101]
//	  3 -> 5 비용 + memoi[5][1110101]

// memoi[2][1100111] 의 값은 남은 4,5 를 다음으로 각각 방문하는 과정의 최소비용으로 갱신
// 위 값은 아래 2개의 값 중 최소값을 선택
// 	  2 -> 4 비용 + memoi[4][1101111]
//	  2 -> 5 비용 + memoi[5][1110111]

public class Main {
	static int N, allMask, INF = 9_999_999;
	static int[][] W;
	static int[][] memoi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		allMask = ( 1 << N ) -1;		// 11111 <= 1 << 5 100000 => -1 해서 11111
		W = new int[N][N];
		memoi = new int[N][allMask];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1));  // 맨 앞 숫자, 00001
	}
	
	static int tsp(int idx, int mask) {
		// 기저조건
		// 모든 도시 방문
		if (mask==allMask) {
			if (W[idx][0] == 0) return INF;	// 남은 도시를 방문 했을 때 되돌아 가지 못하면 추분히 큰 값을 return 하도록 해서 경쟁에서 제외
			else return W[idx][0];		// 처음으로 되돌아가는 비용 
		}
		
		// 이미 최소비용 갱신되었는지 확인
		if (memoi[idx][mask] != 0) return memoi[idx][mask];
		
		// memoi[idx][mask] 를 구하고 저장하고 리턴
		memoi[idx][mask] = INF;		// 이어지는 코드에서 최소값을 갱신하기 위해 충분히 큰 값으로 초기화
		
		// 남은 도시를 탐색하면서 최소값 갱신 
		for (int i = 0; i < N; i++) {
			
			// 경로가 없거나, 이미 방문한 곳은 skip
			if (W[idx][i] == 0 || ( mask & 1 << i) != 0 ) continue;
			
			memoi[idx][mask] = Math.min(memoi[idx][mask], W[idx][i] + tsp(i, mask | (1 << i)));
		}
		
		return memoi[idx][mask];
	}
	
}
