import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시뮬레이션 + 완탐 (중복조합)
public class Solution {
	
	static int T, M, A, ans;
	static int[] pathA, pathB;	// 두 사람의 이동 궤적
	static BC[] bcArray; 	// 충전소 객체의 배열
	static int ay, ax, by, bx;	// A, B 두 사람의 좌표
	// delta - 0 상 우 하 좌
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			// path
			pathA = new int[M];
			pathB = new int[M];
			// A path
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}
			// B path
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC
			bcArray = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y,x,c,p);
			}
			
			// 풀이
			// 초기화
			ans = 0;
			ay = ax = 1;
			by = bx = 10;
			// 충전
            charge();
			for (int i = 0; i < M; i++) {
				// 이동
				ay += dy[pathA[i]];
				ax += dx[pathA[i]];
				by += dy[pathB[i]];
				bx += dx[pathB[i]];
				// 충전
				charge();
				
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	// 충전 <- 현 ay, ax, by, bx 에서 충전 가능한 최대 충전
	static void charge() {
		int max = 0;
		// 최대 충전 max 갱신
		// a, b, 현재 위치에서 모든 BC에서 충전 시도
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				// 충전해서 sum 게산
				int aPower = getPower(bcArray[i], ay, ax);
				int bPower = getPower(bcArray[j], by, bx);
				
				if (aPower == 0 && bPower == 0) continue;
				
				// 충전이 된 상태
				if( i != j ) {
					sum = aPower + bPower;
				} else {	// 같은 충전소에서 동시에 충전
					// 둘 다 충전 <= 충전 100 : a(50) b(50)
					// 한 쪽만 충전 <= 충전 100 : a(100) b(0) 또는 a(0) b(100)
					sum = Math.max(aPower, bPower);
					
				}
				max = Math.max(max, sum);
			}
		}
		
		ans += max;
	
	}
	
	static int getPower(BC bc, int y, int x) {
		if (Math.abs(bc.y - y) + Math.abs(bc.x-x) <= bc.c) return bc.p;
		return 0;
	}
	
	static class BC {
		int y,x,c,p;
		BC(int y, int x, int c, int p) {
			this.y = y; this.x=x; this.c=c; this.p=p;
		}
	}

}
