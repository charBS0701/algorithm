import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] mat;
    static Set<Integer> team1Set = new HashSet<>();
    static Set<Integer> team2Set = new HashSet<>();
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<N; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        makeTeam1(0,0);
        
        System.out.println(answer);
        
    }
    
    static void makeTeam1(int srcIdx, int sum) {
        if (team1Set.size() == N/2) {
            team2Set.clear();
            makeTeam2(sum);
            return;
        }
        
        for (int i=srcIdx; i<N; i++) {
            team1Set.add(i);
            for (int prev : team1Set) {
                sum += mat[prev][i];
                sum += mat[i][prev];
            }
            makeTeam1(i+1, sum);
            team1Set.remove(i);
            for (int prev : team1Set) {
                sum -= mat[prev][i];
                sum -= mat[i][prev];
            }            
        }
    }
    
    static void makeTeam2(int sum1) {
        int sum2 = 0;
        for (int i=0; i<N; i++) {
            if (!team1Set.contains(i)) {
                team2Set.add(i);
                for (int prev : team2Set) {
                    sum2 += mat[prev][i];
                    sum2 += mat[i][prev];
                }
            }
        }
        
        answer = Math.min(answer, Math.abs(sum1-sum2));
        
    }
    
}