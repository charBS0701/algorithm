import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map = new int[10][10];
	static boolean[][] rSelect = new boolean[10][10];
	static boolean[][] cSelect = new boolean[10][10];
	static boolean[][] sSelect = new boolean[10][10];
	static StringBuilder sb = new StringBuilder();
	static boolean doneFlag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1; j <= 9; j++) {
				int now = Character.getNumericValue(tmp[j - 1]);

				map[i][j] = now;

				if (now != 0) {
					int row = (i - 1) / 3; // 몇번째행
					int col = (j - 1) / 3; // 몇번째열
					int square = row * 3 + col + 1;

					// 사용한 수 체크
					rSelect[i][now] = true;
					cSelect[j][now] = true;
					sSelect[square][now] = true;
				}

			}
		}

		// 풀이
		inject(1, 1);
	}

	static void inject(int r, int c) {
		if (doneFlag) return;
		if (r==10) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			doneFlag = true;
			return;
		}
		int nc = c+1;
		int nr = r;
		if (nc==10) {
			nc-=9;
			nr++;
		}
		if (map[r][c] == 0) { // 채워야하는 칸이면
			int square = ((r - 1) / 3) * 3 + (c - 1) / 3 + 1;
			boolean[] candi = new boolean[10];
			Arrays.fill(candi, true);

			// 가로 중 사용한 수 제외
			for (int i = 1; i <= 9; i++) {
				if (rSelect[r][i])
					candi[i] = false;
			}
			// 세로 중 사용 가능한 수
			for (int i = 1; i <= 9; i++) {
				if (cSelect[c][i])
					candi[i] = false;
			}
			// 사각형 중 사용 가능한 수
			for (int i = 1; i <= 9; i++) {
				if (sSelect[square][i])
					candi[i] = false;
			}

			boolean flag = false;	// 후보가 있는지
			for (int i = 1; i <= 9; i++) {
				if (!candi[i])
					continue;
				flag = true;	// 넣을게 있음
				map[r][c] = i; // 후보 넣기
				rSelect[r][i] = true; // 넣음 처리
				cSelect[c][i] = true;
				sSelect[square][i] = true;

				// 다음 칸 진행
				inject(nr,nc);
				
				map[r][c] = 0;
				rSelect[r][i] = false; // 복원
				cSelect[c][i] = false;
				sSelect[square][i] = false;
				
			}
			
			if(!flag) {	// 넣을게 없으면
				// 되돌아간다
				return;
			}
			
			
		} else {
			inject(nr,nc); // 0이 아니면 다음칸으로
		}

	}

}