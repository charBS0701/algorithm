import java.util.*;
import java.io.*;

class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t=0; t<T; t++) {
            Long sum = 0L;
            pq.clear();
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int k=0; k<K; k++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            
            while (pq.size() != 1) {
                Long a = pq.poll();
                Long b = pq.poll();
                
                sum += a+b;
                pq.add(a+b);
            }
            
            sb.append(sum).append("\n");
        }

        System.out.println(sb);    
        
    }
    
}