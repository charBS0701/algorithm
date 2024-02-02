import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static Deque<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {	// 테스트 케이스 10번
			que.clear();
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 8; n++) {	// que 입력
				que.offer(Integer.parseInt(st.nextToken()));				
			}
			
			int cycle = 1;
			while(true) {
				if (cycle==6) cycle=1;
				if(que.peek()-cycle <= 0) {	// 기저조건
				que.poll();
				que.offer(0);
				break;
				}
				
				que.offer(que.poll()-cycle);
				cycle++;
				
			}
			
			sb.append("#").append(t).append(" ");
			for (Integer num : que) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
