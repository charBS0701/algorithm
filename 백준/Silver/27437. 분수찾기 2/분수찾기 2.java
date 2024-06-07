import java.io.*;
import java.util.*;

public class Main {

	static long x;
	static long n; // 분모 분자 합 - 1 // 짝수: 분자가1로 시작, 홀수: 분모가 1로 시작
	static long c; // 해당 행의 몇 번째 수인지

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		x = Long.parseLong(br.readLine());

		long l = 1;
		long r = 10_000_000_001L;
		while (true) {
			long mid = (l+r)/2;
			long tmp = mid*(mid-1)/2;
			if (tmp >= x && (mid-1)*(mid-2)/2 < x) {
				n = mid-1;
				break;
			} else if (tmp < x) {
				l = mid+1;
			}
			else if (tmp > x) {
				r = mid-1;
			}
		}

		c = x - (n) * (n - 1) / 2;

		if (n % 2 == 0) {
			sb.append(c).append("/").append(n + 1 - c);
		} else {
			sb.append(n + 1 - c).append("/").append(c);
		}

		System.out.println(sb);
	}

}
