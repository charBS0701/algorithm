import java.io.*;
import java.util.*;

class Main {
    
    static int T;
    static int N, K;
    static int[] inDegrees;
    static List<List<Integer>> outGraph;
    static int[] dTimes;
    static int[] totalTime;
    static int W;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 건물 수
            inDegrees = new int[N+1];               // 진입 차수
            totalTime = new int[N+1];
            outGraph = new ArrayList<>();
            for (int n=0; n<=N; n++) {
                outGraph.add(new ArrayList<>());
            }
            
            K = Integer.parseInt(st.nextToken());   // 규칙 수
            st = new StringTokenizer(br.readLine());    // 건설시간
            dTimes = new int[N+1];
            for (int d=1; d<=N; d++) {
                dTimes[d] = Integer.parseInt(st.nextToken());
            }
            
            for (int k=0; k<K; k++) {       // 규칙 입력
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                inDegrees[b]++;     // 진입차수 증가
                outGraph.get(a).add(b);
            }
            
            W = Integer.parseInt(br.readLine());     // 목표 건물
            
            bfs();
            
        }
        
        System.out.println(sb);
    }
    
    static void bfs() {
        Deque<Integer> que = new ArrayDeque<>();
        for (int n=1; n<=N; n++) {
            if (inDegrees[n] == 0) {
                que.add(n);
                totalTime[n] = dTimes[n];   // 초기 건물 짓는 시간
            }
        }
            
        while (!que.isEmpty()) {
            int now = que.poll();
            
            if (now == W) {     // 목표건물 지을시 return
                sb.append(totalTime[now]).append("\n");
                return;
            }
            
            for (int next : outGraph.get(now)) {
                inDegrees[next]--;
                totalTime[next] = Math.max(totalTime[next], totalTime[now] + dTimes[next]);
                if (inDegrees[next] == 0) {
                    que.add(next);
                }
                
            }
            
        }
    }
}