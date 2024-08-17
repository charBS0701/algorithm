import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static int[][] mat = new int[1001][1001];
    static int[] cnt;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N+1];
        for (int n=1; n<=N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            
            for (int i=y; i<y+height; i++) {
                for (int j=x; j<x+width; j++) {
                    if (i>1000 || j>1000) continue;
                    mat[i][j] = n;
                }
            }
        }
        
        for (int i=0; i<1001; i++) {
            for (int j=0; j<1001; j++) {
                cnt[mat[i][j]]++;
            }
        }
        
        for (int n=1; n<=N; n++) {
            sb.append(cnt[n]).append("\n");
        }
        
        System.out.println(sb);
        
	}
}
