import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] dx = { 1, 0, -1, 0 };	// 우, 하, 좌, 상
	static int[] dy = { 0, 1, 0, -1 };
	static int dr;	// 방향
	static int x;
	static int y;
	static int[][] mat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			x=0;
			y=0;
			dr=0;
			sb.append("#").append(t).append("\n");
			int N = Integer.parseInt(br.readLine());
			int[][] mat = new int[N][N];
			int count = 1;
			mat[y][x]=count++;
			
			while (count<=N*N) {	// count <= N*N
				int nx = x + dx[dr];
				int ny = y + dy[dr];
				if ( nx>=0 && nx<N && ny>=0 && ny<N && mat[ny][nx] == 0) {
					x = nx;
					y = ny;
					mat[y][x] = count++;
				} else {	// 방향바꾸기
					dr++;
					if (dr==4) dr%=4;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(mat[i][j]).append(" ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);


	}
}
