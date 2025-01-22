import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = solve();
        
        System.out.println(answer);
        
    }
    
    static int solve() {
        if (N==1) {
            return 1;
        } else if (N==2) {
            return Math.min(4,(M+1)/2);
        } else if (M<7) {
            return Math.min(4,M);
        } else {
            return M-2;
        }
    }
    
}