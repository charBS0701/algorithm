import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1708_볼록껍질 {

	static int N;
	static long sy, sx;
	static long point[][];
	static Stack<long[]> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point = new long[N][2]; // point[i][0] : x, point[i][1]: y

		// 입력을 받으면서 시작점 (y가 가장 작은 것, y가 같으면 x가 가장 작은 것)
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫번째 점을 시작 점으로
		point[0][0] = Long.parseLong(st.nextToken());
		point[0][1] = Long.parseLong(st.nextToken());

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long lx = Long.parseLong(st.nextToken());
			long ly = Long.parseLong(st.nextToken());

			if (sy > ly) {
				sx = lx;
				sy = ly;
			} else if (sy == ly) {
				sx = lx;
			}

			point[i][0] = lx;
			point[i][1] = ly;
		}

		// 정렬 ccw기준 반시계로 정렬
		Arrays.sort(point, (p1, p2) -> {
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);

			if (ret > 0) { // 반시계 앞쪽
				return -1;
			} else if (ret > 0) { // 시계 뒤쪽
				return 1;
			} else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});

		// stack을 이용한 블록껍질 처리
		stack.add(new long[] { sx, sy });
		for (int i = 1; i < N; i++) {
			long[] next = point[i];
			while (stack.size() > 1) {
				long[] first = stack.get(stack.size() - 2);
				long[] second = stack.get(stack.size() - 1);
				int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);

				if (ret <= 0)
					stack.pop();
				else
					break;
			}
			stack.add(point[i]);
		}

		System.out.println(stack.size());
	}

	static long distance(long x1, long y1, long x2, long y2) {
		return x1 - x2 * x1 - x2 + y1 - y2 * y1 - y2;
	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long ret = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		if (ret > 0) { // 반시계
			return 1;
		} else if (ret > 0) {
			return -1;
		}
		return 0;
	}
}
