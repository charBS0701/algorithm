import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 결과가 데이터로 주어진 문제 <= 이 결과의 유효성을 따지는 문제
// 두 팀의 시합을 모든 경우에 대해서 진행하면서 주어진 결과 데이터를 검증
/*
 * 시험 이어나가기 -----------------> 단계별로 첫 경기부터 시합을 진행하면서 마지막 경기까지 오면서 주어진 데이터를 검증
 * 마지막 경기까지 모두 문제없이 치르면 성공, 중간에 데이터가 맞지 않으면 다음으로 이동 x, 모든 경우가 마지막까지 오지 못하면 실패 
 * 0 0 0 0 0 1 1 1 1 2 2 2 3 3 4 
 * 1 2 3 4 5 2 3 4 5 3 4 5 4 5 5 
 * 
 * 매 경기에서 가능한 3가지 완탐 승, 무 , 패
 */
public class Main {

	static int[] win, lose, draw; // 주어지는 결과 데이터 <- 검증 대상 <= index 는 팀 구별
	static int[][] game; // 순서대로 진행할 게임 별 <= win, lose, draw 의 index 와 동일한 index
	static boolean result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		win = new int[6];
		lose = new int[6];
		draw = new int[6];

		game = new int[15][2];

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}

		// 4 가지 테케
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			result = false;
			int sum = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 18 -> 6 / 6 / 6
			for (int i = 0; i < 6; i++) {
				sum += win[i] = Integer.parseInt(st.nextToken());
				sum += draw[i] = Integer.parseInt(st.nextToken());
				sum += lose[i] = Integer.parseInt(st.nextToken());
			}

			// 초기 가지치기
			if (sum != 30) {
				sb.append("0 ");
				continue;
			}

			// dfs 완탐
			dfs(0); // 맨 앞 경기부터 진행
			if (result)
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		System.out.println(sb);

	}
	
	static void dfs(int idx) {	// game[] index
		if (idx == 15) {
			result = true;
			return;
		}
		
		// 현재 (idx) 경기를 진행 승, 무, 패  
		
		int teamA = game[idx][0];
		int teamB = game[idx][1];
		
		// 아래 세가지 경우 중 유효한 경우에만 dfs 를 이어간다. 
		// A 승리 <= 검증 데이터에서 win[teamA] --, lose[teamB] --
		if (win[teamA] > 0 && lose[teamB] > 0) {
			win[teamA]--;
			lose[teamB]--;
			
			dfs(idx+1);
			
			win[teamA]++;
			lose[teamB]++;
		}
		// B 승리
		if (win[teamB] > 0 && lose[teamA] > 0) {
			win[teamB]--;
			lose[teamA]--;
			
			dfs(idx+1);
			
			win[teamB]++;
			lose[teamA]++;
		}
		
		// 무승부
		if (draw[teamB] > 0 && draw[teamA] > 0) {
			draw[teamA]--;
			draw[teamB]--;
			
			dfs(idx+1);
			
			draw[teamA]++;
			draw[teamB]++;
		}
	}

}
