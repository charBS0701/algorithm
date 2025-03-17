import java.io.*;
import java.util.*;

public class Main {
    
    static int N, answer = Integer.MAX_VALUE;
    static int[][] mat;
    static int[][] dis;
    static boolean[][] visit;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};    
    static int[] sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N+1][N+1];
        for (int n=1; n<=N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m=1; m<=N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        

        for (int y=1; y<=N-2; y++) {        
            for (int x=2; x<=N-1; x++) {                
                for (int d1=1; d1<=N; d1++) {
                    for (int d2=1; d2<=N; d2++) {
                        if (x-d1 < 1 || x+d2 > N || y+d1+d2 > N) continue;
                        solve(x,y,d1,d2);
                    }
                }
            }
        }
        
        System.out.println(answer);

    }
    
    static void solve(int x, int y, int d1, int d2) {
        dis = new int[N+1][N+1];
        
        // 5번 구역 테두리
        for (int d=0; d<=d1; d++) {
            dis[y+d][x-d] = 5;
            dis[y+d2+d][x+d2-d] = 5;
        }
        
        for (int d=0; d<=d2; d++) {
            dis[y+d][x+d] = 5;
            dis[y+d1+d][x-d1+d] = 5;
        }
        
        // 5번 구역 내부
        for (int n=y+1; n<y+d1+d2; n++) {
            int cnt = 0;
            for (int m=x-d1; m<=x+d2; m++) {
                if (dis[n][m] == 5) {
                    cnt++;
                    continue;
                }
                if (cnt == 1) dis[n][m] = 5;
                else if (cnt == 2) break;
            }
        }
        
        // 1,2,3,4 번 구역
        for (int r = 1; r < y + d1; r++) {
            for (int c = 1; c <= x; c++) {
                if (dis[r][c] != 0) break;
                dis[r][c] = 1;
            }
        }
        for (int r = 1; r <= y + d2; r++) {
            for (int c = N; c >= x+1; c--) {
                if (dis[r][c] != 0) break;
                dis[r][c] = 2;
            }
        }
        for (int r = y + d1; r <= N; r++) {
            for (int c = 1; c < x - d1 + d2; c++) {
                if (dis[r][c] != 0) break;
                dis[r][c] = 3;
            }
        }
        for (int r = y + d2 + 1; r <= N; r++) {
            for (int c = N; c >= x - d1 + d2; c--) {
                if (dis[r][c] != 0) break;
                dis[r][c] = 4;
            }
        }
        
        // System.out.println("y : " + y + ", x : " + x + " , d1 : " + d1 + ", d2 : " + d2);        
        // for (int i=1; i<=N; i++) {
        //     for (int j=1; j<=N; j++) {
        //         System.out.print((dis[i][j] == 5 ? "*" : dis[i][j]) + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        sum = new int[5];
        for (int n=1; n<=N; n++) {
            for (int m=1; m<=N; m++) {
                int district = dis[n][m];
                int pop = mat[n][m];
                
                if (district == 1) sum[0] += pop;
                else if (district == 2) sum[1] += pop;
                else if (district == 3) sum[2] += pop;
                else if (district == 4) sum[3] += pop;
                else sum[4] += pop;
            }
        }
        
        Arrays.sort(sum);
        answer = Math.min(answer, sum[4] - sum[0]);
        
    }
}