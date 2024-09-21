import java.util.*;
import java.io.*;

class Main {
    
    static int N, K;
    static long answer;
    
    static Queue<Integer>[] ques = new ArrayDeque[21];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for (int i=2; i<=20; i++) {
            ques[i] = new ArrayDeque<>();
        }
        
        for (int n=1; n<=N; n++) {
            int len = br.readLine().length();

            while (!ques[len].isEmpty() && n - ques[len].peek() > K) {
                ques[len].poll();
            }
            
            answer += ques[len].size();
            
            ques[len].offer(n);
            
        }
        
        System.out.println(answer);
        
    }
    
}