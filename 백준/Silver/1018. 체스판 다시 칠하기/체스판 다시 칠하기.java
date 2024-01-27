import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 8 ~ 50
		int M = Integer.parseInt(st.nextToken()); // 8 ~ 50

		char[][] mat = new char[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				mat[n][m] = s.charAt(m);
			}
		}

		int minCnt = Integer.MAX_VALUE;
		for (int n = 0; n <= N - 8; n++) {
			for (int m = 0; m <= M - 8; m++) {
				char temp = mat[n][m] == 'W' ? 'B' : 'W';
				
				for (int rep = 0; rep < 2; rep++) {
					int cnt = 0;
					
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (temp == 'W') {
								if (i % 2 == 0) { // 짝수 행일 때
									if (j % 2 == 0) { // 짝수 열일 때
										if (mat[n + i][m + j] != 'W')
											cnt++;
									} else { // 홀수 열일 때
										if (mat[n + i][m + j] != 'B')
											cnt++;
									}
								} else { // 홀수 행일 때
									if (j % 2 == 0) { // 짝수 열일 때
										if (mat[n + i][m + j] != 'B')
											cnt++;
									} else { // 홀수 열일 때
										if (mat[n + i][m + j] != 'W')
											cnt++;
									}
								}
							} else if (temp == 'B') {
								if (i % 2 == 0) { // 짝수 행일 때
									if (j % 2 == 0) { // 짝수 열일 때
										if (mat[n + i][m + j] != 'B')
											cnt++;
									} else { // 홀수 열일 때
										if (mat[n + i][m + j] != 'W')
											cnt++;
									}
								} else { // 홀수 행일 때
									if (j % 2 == 0) { // 짝수 열일 때
										if (mat[n + i][m + j] != 'W')
											cnt++;
									} else { // 홀수 열일 때
										if (mat[n + i][m + j] != 'B')
											cnt++;
									}
								}
							}
						}
					}
					minCnt = Math.min(minCnt, cnt);
					temp = temp == 'W' ? 'B' : 'W';
					
				}
				
				


			}

		}
		System.out.println(minCnt);

	}
}