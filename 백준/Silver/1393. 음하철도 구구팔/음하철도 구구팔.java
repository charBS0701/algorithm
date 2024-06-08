import java.io.*;
import java.util.*;

public class Main {

	static int xs, ys;
	static int xe, ye, dx, dy;
	static int gcd = 1;
	static int minDist;
	static int resultX, resultY;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		xs = Integer.parseInt(st.nextToken());
		ys = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		xe = Integer.parseInt(st.nextToken());
		ye = Integer.parseInt(st.nextToken());
		dx = Integer.parseInt(st.nextToken());
		dy = Integer.parseInt(st.nextToken());
		
		minDist = dist(xe, ye);
		resultX = xe;
		resultY = ye;

		// dx dy 의 최대공약수를 찾아서 나눈다
		gcd = gcd(dx, dy);
		dx /= gcd;
		dy /= gcd;

		// 현재 좌표에 그 수를 더해가며 정류장과 가장 가까운 좌표를 구한다
		while (true) {
			xe += dx;
			ye += dy;
			int dist = dist(xe,ye);
			if (dist < minDist) {
				minDist = dist;
				resultX = xe;
				resultY = ye;
			} else break;
			
		}
		
		sb.append(resultX).append(" ").append(resultY);
		System.out.println(sb);

	}

	static int gcd(int dx, int dy) {
		int big = Math.max(dx, dy);
		int small = Math.min(dx, dy);

		if (small == 0)
			return big;
		else
			return gcd(small, big % small);
	}

	static int dist(int x, int y) { // 정류장까지의 거리
		return (xs-x)*(xs-x) + (ys-y)*(ys-y);
	}
}