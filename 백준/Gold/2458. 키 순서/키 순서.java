import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[][] mat;
    static final int INF = 501;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        mat = new int[N+1][N+1];
        for (int n=1; n<=N; n++) {
            Arrays.fill(mat[n], INF);
            mat[n][n] = 0;
        }
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            mat[from][to] = 1;
        }

        // 어떤 노드가 본인에게 오는 경로가 있거나 본인이 다른 노드에게 경로가 있으면 순서를 알 수 있음
        floyd();
        
        for (int k=1; k<=N; k++) {
            int cnt = 0;
            for (int i=1; i<=N; i++) {
                if (mat[i][k] != 0 && mat[i][k] != INF) cnt++;
                if (mat[k][i] != 0 && mat[k][i] != INF) cnt++;
            }
            if (cnt == N-1) answer++;
        }
        
        System.out.println(answer);
    }
    
    static void floyd() {
        for (int k=1; k<=N; k++) {          // 경유지
            for (int i=1; i<=N; i++) {      // 출발지
                for (int j=1; j<=N; j++) {  // 도착지
                    int i2j = mat[i][j];
                    int i2k = mat[i][k];
                    int k2j = mat[k][j];
                    if (i2k == INF || k2j == INF) continue;
                    mat[i][j] = Math.min(i2j, i2k+k2j);
                }
            }
        }
        
    }
}