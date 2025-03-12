import java.io.*;
import java.util.*;

public class Main
{   
    
    static int N;
    static char[][] mat;
    static int answer;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mat = new char[N][N];
        
        for (int n=0; n<N; n++) {
            mat[n] = br.readLine().toCharArray();
        }
        
        for (int n=0; n<N; n++) {
            int cnt = 0;
            for (int m=0; m<N; m++) {
                if (n==m) continue;
                if (mat[n][m] == 'Y') cnt++;
                else {
                    for (int t=0; t<N; t++) {
                        if (mat[m][t] == 'Y' && mat[t][n] == 'Y') {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            
            answer = Math.max(answer,cnt);
            
        }
        
        
        System.out.println(answer);
        
	}
}