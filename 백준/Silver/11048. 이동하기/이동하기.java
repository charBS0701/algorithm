import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[][] map;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=1; m<=M; m++) {
                int candy = Integer.parseInt(st.nextToken());
                map[n][m] = Math.max(Math.max(map[n-1][m],map[n][m-1]),map[n-1][m-1]) + candy;
            }
        }
        
        System.out.println(map[N][M]);
        
    }
}