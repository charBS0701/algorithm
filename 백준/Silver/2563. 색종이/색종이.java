import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 100 이하 
		map = new int[100][100];	// 도화지 넓이
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			for (int i = x; i < x+10; i++) {	// 색종이 칠하기
				for (int j = y; j < y+10; j++) {
					map[i][j] = 1;
				}
				
			}
			
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) result++;
			}
		}
		
		System.out.println(result);
		
	}
}
