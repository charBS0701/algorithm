import java.util.*;
import java.io.*;

class Main {
    static int N;
    static Long sum = 0L;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int n=0; n<N; n++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        
        while (pq.size() != 1) {
            Long a = pq.poll();
            Long b = pq.poll();
            
            sum += a+b;
            pq.add(a+b);
        }
        
        System.out.println(sum);
        
    }
    
}