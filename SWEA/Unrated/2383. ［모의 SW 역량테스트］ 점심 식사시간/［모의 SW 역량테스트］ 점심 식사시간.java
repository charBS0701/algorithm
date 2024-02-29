import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static int[][] map;
	static List<P> Ps = new ArrayList<>();
	static List<S> Ss = new ArrayList<>();
	static boolean[] select; // 사람의 1번 2번 계단 선택 on/off
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			min = Integer.MAX_VALUE;
			Ps.clear();
			Ss.clear();

			N = Integer.parseInt(br.readLine()); // 지도 크기 // (4 ≤ N ≤ 10) // (1 ≤ 사람의 수 ≤ 10)
			map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) { // 맵 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						Ps.add(new P(i, j));
					if (map[i][j] >= 2)
						Ss.add(new S(i, j, map[i][j]));
				}
			}
			// 풀이
			select = new boolean[Ps.size()];

			subset(0); // 선택: 1번계단 선택 / 비선택: 2번계단 선택
			sb.append("#").append(t).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}

	static void simul() {
		int time = 0;
		List<P> PsCp = new ArrayList<>();
		for (P p : Ps) {
			PsCp.add(new P(p.y,p.x));
		}

		for (int i = 0; i < PsCp.size(); i++) {
		    P person = PsCp.get(i);
		    if (select[i]) { 
		        person.dest = Ss.get(0);
		    } else {
		        person.dest = Ss.get(1);
		    }
		    person.dist = dist(person, person.dest);
		}

		while (true) { // 시간 시뮬레이션
			++time;
			for (int q = 0; q <= 1; q++) {
				List<P> que = Ss.get(q).que;

				if (!que.isEmpty()) { 
					for (P p : que) {	// 계단에 올라있는 사람들 계단 횟수 증가
						p.stairTime++;
					}
					for (int i = que.size() - 1; i >= 0; i--) {			// 계단 다 내려간 사람 졸업
						if (que.get(i).stairTime == Ss.get(q).height) {
							que.remove(i); // 계단올라간 리스트에서 제거
						}
					}
				}
			}

			// 계단 안오른 사람들
			if (!PsCp.isEmpty()) {
				for (int i = PsCp.size() - 1; i >= 0; i--) {
					P person = PsCp.get(i);
					person.dist--;
					if (person.stairTime == -1 && person.dist <= -1 && person.dest.que.size() < 3) {
						// 계단에 안올라가있는사람이 // 계단에 도착한지 1초가 지났고 // 목적계단에 3명 미만 있을 떄
						person.dest.que.add(person);
						person.stairTime++;
						PsCp.remove(person);
					}
				}
			}
			// 시뮬레이션 종료조건
			if (Ss.get(0).que.isEmpty() && Ss.get(1).que.isEmpty() && PsCp.isEmpty())
				break;
		}

		min = Math.min(min, time);

	}

	static void subset(int srcIdx) {
		if (srcIdx == Ps.size()) {
			simul(); // 시뮬레이션 시작
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static int dist(P p, S s) { // 계단까지의 거리
		return Math.abs(p.y - s.y) + Math.abs(p.x - s.x);
	}

	static class P {
		int y, x;
		int dist; // 계단까지의 거리
		S dest; // 목적계단
		int stairTime = -1; // 계단에 올라가 있는 시간

		public P(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class S {
		int y, x, height;
		List<P> que = new ArrayList<>();

		public S(int y, int x, int height) {
			this.y = y;
			this.x = x;
			this.height = height;
		}
	}

}