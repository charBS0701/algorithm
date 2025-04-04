import java.io.*;
import java.util.*;

public class Main
{
    
    static int N;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Deque<Integer> que = new ArrayDeque<>();
		for (int n=1; n<=N; n++) {
		    que.offer(n);
		}
		
		while (que.size() >= 2) {
		    sb.append(que.poll()).append(" ");
		    que.offer(que.poll());
		}
		
		if (!que.isEmpty()) sb.append(que.poll());
		
		System.out.println(sb);
		
	}
}