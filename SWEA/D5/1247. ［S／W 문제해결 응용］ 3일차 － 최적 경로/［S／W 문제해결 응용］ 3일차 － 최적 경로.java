import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, comY, comX, homeY, homeX, min;
    static int[][] cust;
    static int[] tgt;
    static boolean[] select;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            
            min = Integer.MAX_VALUE;
            
            N = Integer.parseInt(br.readLine());; // 고객수
            
            cust = new int[N][2];
            select = new boolean[N];
            tgt = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            comY = Integer.parseInt(st.nextToken());
            comX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            
            for (int i = 0; i < N; i++) {
                cust[i][0] = Integer.parseInt(st.nextToken());
                cust[i][1] = Integer.parseInt(st.nextToken());
            }
            
            perm(0);
            
            sb.append("#").append(t).append(" ").append(min).append("\n");            
        }
        System.out.println(sb);
    }
    
    static void perm(int tgtIdx) {

        if( tgtIdx == N ) {
            
            // 회사 -> 첫번째 고객
            int sum = distance(
                    comY, comX, 
                    cust[tgt[0]][0], cust[tgt[0]][1]
                );
            
            // 첫번째 고객 -> 마지막 고객
            for (int i = 0; i < N - 1; i++) {
                sum += distance(
                        cust[tgt[i]][0], cust[tgt[i]][1], 
                        cust[tgt[i+1]][0], cust[tgt[i+1]][1]
                    );
            }

            // 마지막 고객 -> 집
            sum += distance(
                    homeY, homeX, 
                    cust[tgt[N-1]][0], cust[tgt[N-1]][1]
                );
            
            min = Math.min(min, sum);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            
            if( select[i] ) continue;

            tgt[tgtIdx] = i;
            
            select[i] = true;            
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }
    
    static int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

}
