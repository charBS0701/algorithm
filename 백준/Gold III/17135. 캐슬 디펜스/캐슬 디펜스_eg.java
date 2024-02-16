import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, max;
	static int[] archer = new int[3]; // 궁수 위치 3자리(x)
	static List<Enemy> enemy = new ArrayList<>();
	static List<Enemy> enemyCopy = new ArrayList<>();
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>((e1, e2) -> e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행의 수 3 ≤ N, M ≤ 15
		M = Integer.parseInt(st.nextToken()); // 열의 수
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한 1 ≤ D ≤ 10
		// 적군 정보
		for (int i = 0; i < N; i++) { // 맵 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) enemyCopy.add(new Enemy(i,j));
			}
		}
		// 풀이
		comb(0,0);	// 궁수의 자리 
		System.out.println(max);
			
	}
	
	static void check() {
		// 초기화 및 적 복사
		enemy.clear();
		for (Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y, e.x));
		}
		// 시뮬레이션
		int dead = 0;
		while (true) {
			// 조건에 맞는 적을 게속 죽이는 과정 반복 
			// 각 궁수가 한 명씩 발사
			for (int i = 0; i < 3; i++) {
				pqueue.clear();
				int ac = archer[i];
				// 현재 남은 적들 중 현재 궁사와의 사정거리 안에 드는 적을 선별 삭제 
				int size = enemy.size();
				for (int j = 0; j < size; j++) {
					Enemy e = enemy.get(j);
					// 현재 궁수와 현재 적의 거리를 계산, 저장
					e.d = Math.abs(ac-e.x) + Math.abs(N - e.y);
					if (e.d <= D) {
						pqueue.offer(e);
					}
				}
				if (!pqueue.isEmpty()) {
					pqueue.poll().dead = true;	// enemy엔 남아 있다.
				}
			}
			
			// 사망한 적 제거
			for (int i = enemy.size()-1; i >= 0; i--) {
				Enemy e = enemy.get(i);
				if (e.dead) {
					enemy.remove(i);	// 죽은 적
					dead++;
				} else if (e.y == N -1) {
					enemy.remove(i);	// 영역 벗어난 적
				} else {
					e.y++;
				}
			}
			
			if (enemy.size() == 0 ) break;
		}
		
		max = Math.max(max, dead);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			check();
			return;
		}
		
		if (srcIdx == M) return;
		
		archer[tgtIdx] = srcIdx; // 현재 선택
		
		comb(srcIdx + 1, tgtIdx +1);
		comb(srcIdx + 1, tgtIdx);
		
	}
	static class Enemy {
		int y, x, d;
		boolean dead; // 사망 여부

		Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
