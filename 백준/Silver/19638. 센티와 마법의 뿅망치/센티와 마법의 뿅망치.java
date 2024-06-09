import java.io.*;
import java.util.*;

public class Main { 
	static int N, H, T;	// N (1 ≤ N ≤ 10^5), H ≤ 2 × 10^9),  T (1 ≤ T ≤ 10^5)
	static boolean flag;
	static int time;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		for (int n = 0; n < N; n++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		for (int t = 0; t < T; t++) {
			int tmp = pq.poll();
			if (tmp == 1) {
				pq.offer(tmp);
				break;
			}
			
			if (H > tmp) {	// 센티가 제일 크다
				flag = true;
				time = t;
				pq.offer(tmp);
				break;
			}
			tmp /= 2;
			pq.offer(tmp);
			time = t+1;
		}
		
		int top = pq.poll();
		if (flag || top < H) {
			sb.append("YES").append("\n").append(time);
		} else {
			sb.append("NO").append("\n").append(top);
		}
		
		System.out.println(sb);
	}
}