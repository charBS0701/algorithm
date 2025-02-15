import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int times[];
    static int inDeg[];
    static int preTime[];
    static List<List<Integer>> adjList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N+1];
        inDeg = new int[N+1];
        preTime = new int[N+1];
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<>());
        }
        
        StringTokenizer st = null;
        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            times[n] = Integer.parseInt(st.nextToken());        // 건설 소요시간
            int pre = Integer.parseInt(st.nextToken());
            while (pre != -1) {
                adjList.get(pre).add(n);
                inDeg[n]++;
                pre = Integer.parseInt(st.nextToken());
            }
        }
        
        Deque<Integer> que = new ArrayDeque<>();
        for (int n=1; n<=N; n++) {
            if (inDeg[n] == 0) que.add(n);
        }
        
        while (!que.isEmpty()) {
            int now = que.poll();
            
            for (int next : adjList.get(now)) {
                inDeg[next]--;
                preTime[next] = Math.max(preTime[next], preTime[now] + times[now]);
                if (inDeg[next] == 0) {
                    que.add(next);
                }
            }
        }
        
        for (int n=1; n<=N; n++) {
            sb.append(preTime[n] + times[n]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}