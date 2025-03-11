import java.io.*;
import java.util.*;

public class Main
{   
    
    static int N, M;
    static int[][] mat, acc;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        mat = new int[N+1][N+1];
        acc = new int[N+1][N+1];
        
        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=1; m<=N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 누적합
        for (int n=1; n<=N; n++) {
            for (int m=1; m<=N; m++) {
                acc[n][m] = mat[n][m] + acc[n-1][m] + acc[n][m-1] - acc[n-1][m-1];
            }
        }
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            sb.append(acc[r2][c2] - acc[r2][c1-1] - acc[r1-1][c2] + acc[r1-1][c1-1]).append("\n");
        }
        
        System.out.println(sb);
        
	}
}