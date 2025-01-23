import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static char[][] dnas;
    static StringBuilder sb = new StringBuilder();
    static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dnas = new char[N][M];
        
        for (int n=0; n<N; n++) {
            dnas[n] = br.readLine().toCharArray();
        }
        
        for (int m=0; m<M; m++) {
            int diff = 0;
            int a = 0;
            int c = 0;
            int g = 0;
            int t = 0;
            
            for (int n=0; n<N; n++) {
                char dna = dnas[n][m];
                if (dna == 'A') a++;
                else if (dna == 'C') c++;
                else if (dna == 'G') g++;
                else t++;
            }
            
            int max = Math.max(a,Math.max(c,Math.max(g,t)));
            count += N-max;
            char maxC = a == max ? 'A' : c == max ? 'C' : g == max ? 'G' : 'T';
            sb.append(maxC);
        }
        
        System.out.println(sb);
        System.out.println(count);
        
    }
}