import java.util.*;
import java.io.*;

public class Main {
    
    static int M, N;
    static int[] dy = new int[]{1,0,-1,0};  // 상 우 하 좌
    static int[] dx = new int[]{0,1,0,-1};
    static int dir = 1;
    static int[] cur = new int[]{0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int rand = Integer.parseInt(st.nextToken());
            
            if (op.equals("MOVE")) {
                cur[0] += dy[dir] * rand;
                cur[1] += dx[dir] * rand;
                
                if (cur[0] < 0 || cur[1] < 0 || cur[0] > M || cur[1] > M) {
                    System.out.println(-1);
                    return;
                }
            } else if (op.equals("TURN")) {
                if (rand == 0) {    // 왼쪽 회전
                    dir--;
                } else {            // 오른쪽 회전
                    dir++;
                }
                dir = (dir+4) % 4;
            }
            
        }
        
        System.out.println(cur[1] + " " + cur[0]);
        
    }
}