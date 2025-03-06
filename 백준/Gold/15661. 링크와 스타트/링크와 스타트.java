import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] mat;
    static boolean[] teams;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        teams = new boolean[N];
        mat = new int[N][N];
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        teamMake(0,0);
        
        System.out.println(answer);
        
    }
    
    static void teamMake(int srcIdx, int tgtIdx) {
        if (tgtIdx == N) {
            return;
        }
        
        calc();
        
        for (int i=srcIdx; i<N; i++) {
            teams[i] = true;
            teamMake(i+1, tgtIdx+1);
            teams[i] = false;
        }
        
    }
    
    static void calc() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<N; i++) {
            for (int j=i; j<N; j++) {
                if (teams[i] && teams[j]) {
                    sum1 += mat[i][j] + mat[j][i];
                } else if (!teams[i] && !teams[j]) {
                    sum2 += mat[i][j] + mat[j][i];
                }
            }
        }
        
        answer = Math.min(answer, Math.abs(sum1-sum2));
        
    }

}