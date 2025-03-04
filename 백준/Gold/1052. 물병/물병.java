import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K;
    static int answer;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        while (true) {
            int count = Integer.bitCount(N);
            if (count <= K) break;
            N++;
            answer++;
        }
        
        System.out.println(answer);
    
    }
}