import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, r, c;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int line = 1 << N; // 한 변의 길이
		z(line / 2, r, c); // 2 3 1

		System.out.println(count);
	}

	static void z(int half, int row, int col) {
		if (half == 1) {
			if (r % 2 == 0)
				row = 0;
			if (c % 2 == 0)
				col = 0;
			count += row * 2 + col;
			return;
		}

		// 1 2
		// 3 4 사분면이라고 가정
		if (row >= half) { // 3,4사분면
			if (col >= half) { // 4사분면
				count += half * half * 3;
				z(half/2, row-half, col-half);
			} else { // 3사분면
				count += half * half * 2;
				z(half/2, row-half, col); // 2, 1, 1
			}
		} else { // 1, 2 사분면
			if (col >= half) { // 2사분면
				count += half * half;
				z(half/2, row, col-half);
			} else { // 1사분면
				z(half/2, row, col);
			}
		}
	}
		
}
