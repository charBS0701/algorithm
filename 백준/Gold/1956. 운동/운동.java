import java.io.*;
import java.util.*;

class Main {
    
    static int V, E;
    static int[][] mat;
    static final int INF = 100_000_000;
    static int minCost = INF;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer V = Integer.parseInt(st.nextToken());
        Integer E = Integer.parseInt(st.nextToken());
        
        mat = new int[V+1][V+1];
        for (int v=1; v<=V; v++) {
            Arrays.fill(mat[v], INF);
            mat[v][v] = 0;
        }
        
        for (int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mat[a][b] = c;
        }
        
        for (int k=1; k<=V; k++) {
            for (int i=1; i<=V; i++) {
                for (int j=1; j<=V; j++) {
                    if (mat[i][k] == INF || mat[k][j] == INF) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        
        for (int i=1; i<=V; i++) {
            for (int j=1; j<=V; j++) {
                if (i==j) continue;
                minCost = Math.min(minCost, mat[i][j] + mat[j][i]);
            }
        }
        
        System.out.println(minCost == INF ? -1 : minCost);
        
    }
}