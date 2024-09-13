import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] a;
    static int[] b;
    static int answer;
    static boolean done;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        while (true) {
            boolean allZero = true;
            for (int i=0; i<N; i++) {
                if (b[i] % 2 != 0) {    // 홀수면 
                    b[i]--;
                    answer++;
                }
                if (b[i] != 0) allZero = false;
            }
            
            if (allZero) break;
            
            for (int i=0; i<N; i++) {
                b[i] /= 2;
                if (i==0) answer++;
            }
            
        }
        
        System.out.println(answer);
        
    }

}