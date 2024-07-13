import java.io.*;
import java.util.*;

public class Main {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int answer = 0;
			boolean skip = false;
			int[] count = new int[300];
			PriorityQueue<Integer> aIdx1 = new PriorityQueue<>();
			PriorityQueue<Integer> aIdx2 = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			for (int i=0; i<A.length(); i++) {
				char c = A.charAt(i);
				count[c]++;
				if (c == 'a') aIdx1.add(i);
			}
			for (int i=0; i<B.length(); i++) {
				char c = B.charAt(i);
				count[c]--;
				if (c == 'a') aIdx2.add(i);
			}
			for (int j = 0; j < 300; j++) {
				if (count[j] != 0) {
					sb.append(-1).append("\n");
					skip = true;
					break;
				}
			}
			if (skip) continue;
			
			while(!aIdx1.isEmpty()) {
				int idx1 = aIdx1.poll();
				int idx2 = aIdx2.poll();
				if (idx1 == idx2) continue;
				answer += Math.abs(idx1-idx2);
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}