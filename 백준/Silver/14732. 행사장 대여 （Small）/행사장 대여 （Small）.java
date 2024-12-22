import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static boolean[][] map = new boolean[501][501];
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int i=y2-1; i>=y1; i--) {
                for (int j=x2-1; j>=x1; j--) {
                    map[i][j] = true;   
                }
            }
        }
        
        for (int i=0; i<=500; i++) {
            for (int j=0; j<=500; j++) {
                if (map[i][j]) answer++;
            }
        }
        
        System.out.println(answer);
        
    }
    
}