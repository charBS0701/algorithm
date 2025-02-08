import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] inDegrees;
    static List<List<Integer>> graph = new ArrayList<>();
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 가수의 수
        M = Integer.parseInt(st.nextToken());       // 보조PD의 수
        
        inDegrees = new int[N+1];
        
        for (int n=0; n<=N; n++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int m=1; m<=M; m++) {      // 보조PD가 정한 가수의 순서 입력
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int n=1; n<len; n++) {
                int num = Integer.parseInt(st.nextToken());
                graph.get(prev).add(num);
                inDegrees[num]++;
                prev = num;
            }
        }
        
        bfs();
        
        for (int n=1; n<=N; n++) {
            if (inDegrees[n] != 0) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println(sb);
        
    }
    
    static void bfs() {
        Deque<Integer> que = new ArrayDeque<>();
        
        for (int n=1; n<=N; n++) {
            if (inDegrees[n] == 0) {
                que.add(n);
            }
        }
        
        while (!que.isEmpty()) {
            int now = que.poll();
            sb.append(now).append("\n");
            
            for (int next : graph.get(now)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    que.add(next);
                }
            }
         
            
        }
        
    }
}