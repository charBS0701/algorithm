import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static PriorityQueue<Double> pq = new PriorityQueue<>((o1,o2) -> Double.compare(o2,o1));
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            long drink = Long.parseLong(st.nextToken());
            pq.add((double)drink);
        }
        
        while (pq.size() != 1) {
            double d1 = pq.poll();
            double d2 = pq.poll();
            pq.add(d1 + d2/2);
        }
        
        System.out.printf("%.5f\n", pq.poll());
        
    }
}