import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[][] mat;
    static final int INF = 100_000_001;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());        // 도시의 수
        M = Integer.parseInt(br.readLine());        // 버스의 수
        
        mat = new int[N+1][N+1];
        
        for (int n=1; n<=N; n++) {
            Arrays.fill(mat[n], INF);
            mat[n][n] = 0;
        }
        
        StringTokenizer st = null;
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            mat[a][b] = Math.min(mat[a][b], c);
        }
        
        fluid();
        
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                int value = mat[i][j];
                sb.append(value == INF ? 0 : value).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    static void fluid() {
        for (int k=1; k<=N; k++) {       // 경유지
            for (int i=1; i<=N; i++) {       // 출발지
                for (int j=1; j<=N; j++) {      // 도착지
                    if (mat[i][k] == INF || mat[k][j] == INF) continue;     // 연결이 없는 경우 건너뜀
                    int s2e = mat[i][j];        // 기존 경로
                    int s2m2e = mat[i][k] + mat[k][j];      // 경유지를 거쳐간 경로
                    mat[i][j] = Math.min(s2e, s2m2e);       // 업데이트
                }
            }
        }
    }
}