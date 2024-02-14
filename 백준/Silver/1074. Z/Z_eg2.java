package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1074_2 {

	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// N 계산
		N = (int) Math.pow(2, N);

		// 최초 탐색 시작점
		z(0,0);
		
		System.out.println(ans);
	}
	
	static void z(int y, int x) {	// 시작점
		// 기저조건
		if (N == 1) return;
		
		N /= 2; // N >> 1 // 반으로 가로 세로 자른 다음
		
		// 4가지 영역 중 r, c 가 어디에 있는지에 따라 미리 계산할 수 있는 부분 이득을 취한다.
		if (r<y+N && c<x+N) {	// top-left <= 이득 x 이 부분을 다시 더 나눠야 한다.
			z(y,x);
		}else if (r < y+N && c >= x+N) {	// top-right <= 왼쪽 미리 계산 이득, 시작점 오른쪽 이동
			ans += N*N*1;
			z(y,x+N);
		} else if (r >= y+N && c<x+N) {	// bottom-left <= 위쪽 2개 미리 계산 이득, 시작점 밑으로
			ans += N * N * 2;
			z(y+N,x);
		}	else {	// bottom-right <= 위쪽 2개 오른쪽 1개 3개 미리 계산 이득, 시작점 오른쪽, 밑으로 이동
			ans += N * N * 3;
			z(y+N, x+N);
		}
	}
}
