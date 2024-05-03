import java.util.*;
import java.io.*;

public class Main {

	static int M, N, H;
	static int[][][] tomatoes;
	static PriorityQueue<Tomato> que = new PriorityQueue<>((o1,o2) -> o1.day - o2.day);
	static int[] dz = {1,-1,0,0,0,0};  // 위 아래 왼 오 앞 뒤
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {0,0,0,0,-1,1};
	static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoes = new int[M][N][H]; // 가로 세로 높이
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomatoes[m][n][h] = Integer.parseInt(st.nextToken());
					if (tomatoes[m][n][h] == 1)
						que.offer(new Tomato(m, n, h, 0));
				}
			}
		}

		if (check()) { // 처음부터 다익음
			System.out.println(0);
			return;
		}
		
		bfs();
		
		System.out.println(result);
	}

	static void bfs() {
		int day = 0;
		while(!que.isEmpty()) {
			Tomato t = que.poll();
			if (t.day != day) {
				if (check()) {		// 토마토 다익음
					result = t.day;
					return;
				} else day = t.day;	// 다음 날짜로 갱신
			}
			
			for (int d = 0; d < 6; d++) {
				int nm = t.m + dx[d];
				int nn = t.n + dy[d];
				int nh = t.h + dz[d];
				if (!isValid(nm, nn, nh)) continue;
				if (tomatoes[nm][nn][nh] != 0) continue;
				// 덜익은 토마토인 경우
				que.offer(new Tomato(nm, nn, nh, day+1));
				tomatoes[nm][nn][nh] = 1;	// 익음
			}
		}
		if (check()) result = day;
		
	}

	static class Tomato {
		int h, m, n, day;

		public Tomato(int m, int n, int h, int day) {
			this.h = h;
			this.m = m;
			this.n = n;
			this.day = day;
		}
	}

	static boolean check() { // 다 익었는지 검사
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomatoes[m][n][h] == 0)
						return false;
				}
			}
		}
		return true;
	}
	
	static boolean isValid(int nm, int nn, int nh) {
		if (nm < 0 || nn < 0 || nh < 0 || nm >= M || nn >= N || nh >= H) return false;
		else return true;
	}
}