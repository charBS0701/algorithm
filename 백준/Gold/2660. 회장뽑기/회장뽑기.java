import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] cost;
    static final int INF = 100;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        cost = new int[N+1][N+1];
        for (int i=1; i<N+1; i++) {
            Arrays.fill(cost[i], INF);
        }
        
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            
            cost[a][b] = 1;
            cost[b][a] = 1;
        }
        
        floyd();
        
        // 점수, 후보수, 후보
        int min = INF;
        List<Integer> candies = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            int max = 0;
            for (int j=1; j<=N; j++) {
                if (cost[i][j] == INF) continue;
                max = Math.max(max, cost[i][j]);
            }
            if (max == min) candies.add(i);
            else if (max < min) {
                min = max;
                candies.clear();
                candies.add(i);
            }
        }
        
        sb.append(min).append(" ").append(candies.size()).append("\n");
        for (int candi : candies) sb.append(candi).append(" ");        
        
        System.out.println(sb);
    }
    
    
    static void floyd() {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                for (int k=1; k<=N; k++) {
                    if (i==j || i==k || j==k) continue;
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        cost[j][i] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
    }
}