import java.io.*;
import java.util.*;

public class Main
{
    
    static int N, answer;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] indegrees, times, preTimes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		indegrees = new int[N+1];
		times = new int[N+1];
		preTimes = new int[N+1];		
		for (int n=0; n<=N; n++) {
		    adjList.add(new ArrayList<>());
		}
		
		for (int n=1; n<=N; n++) {
		    st = new StringTokenizer(br.readLine());
		    int t = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    times[n] = t;
		    
		    for (int m=0; m<M; m++) {
		        int pre = Integer.parseInt(st.nextToken());
		        adjList.get(pre).add(n);
		        indegrees[n]++;
		    }
		}
		
		Deque<Integer> que = new ArrayDeque<>();
		for (int n=1; n<=N; n++) {
		    if (indegrees[n] == 0) {
		        que.offer(n);
		        answer = Math.max(answer, times[n]);
		    }
		}
		
		while (!que.isEmpty()) {
		    int now = que.poll();
		    for (int next : adjList.get(now)) {
		        preTimes[next] = Math.max(preTimes[next], preTimes[now] + times[now]);
		        if (--indegrees[next] == 0) {
		            que.offer(next);
		            answer = Math.max(answer, preTimes[next] + times[next]);
		        }
		    }
		}
		
		System.out.println(answer);
		
	}
}