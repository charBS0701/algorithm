import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] tgt;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];	// 1부터 N까지의 자연수인 배열
		tgt = new int[M];	// 결과 배열
		for (int n = 0; n < N; n++) {
			arr[n] = n+1;
		}
		
		// 1부터 N까지 자연수 중에서 중복없이 M개를 고른 수열
		// 오름차순으로 출력
		comb(0,0);

	}
	public static void comb(int tgtIdx, int arrIdx) {
		// 수 M 개 정했으면 출력
		if (tgtIdx == M) {
			for (int m = 0; m < M; m++) {
				System.out.print(tgt[m]+ " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = arrIdx; i < N; i++) {
			tgt[tgtIdx] = arr[i];
			comb(tgtIdx+1, i+1);
			
		}
		
	}

}