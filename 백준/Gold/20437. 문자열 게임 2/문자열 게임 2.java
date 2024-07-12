import java.io.*;
import java.util.*;

public class Main {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int max = -1;
			
			int[] count = new int[26];	// 개수
			List<LinkedList<Integer>> index = new ArrayList<>();		// 인덱스 저장
			for (int i = 0; i < 26; i++) {
				index.add(new LinkedList<>());
			}
						
			for (int i=0; i<W.length(); i++) {
				char c = W.charAt(i);
				int num = c-'a';
				count[num]++;
				index.get(num).add(i);
				 
				if (count[num] == K) {
					min = Math.min(min, i - index.get(num).get(0) + 1);
					max = Math.max(max, i - index.get(num).get(0) + 1);
					index.get(num).remove(0);
					count[num]--;
				}
			}
			
			if (max == -1) sb.append(-1).append("\n");
			else sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}