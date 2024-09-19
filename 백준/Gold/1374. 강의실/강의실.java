import java.util.*;
import java.io.*;

class Main {
    static int N;
    static PriorityQueue<Class> pq = new PriorityQueue<>((o1,o2) -> 
        o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s);
    static PriorityQueue<Class> pq2 = new PriorityQueue<>((o1,o2) -> 
        o1.e - o2.e);
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            pq.add(new Class(num, s, e));
        }
        
        while (!pq.isEmpty()) {
            Class now = pq.poll();
            if (pq2.isEmpty()) {
                pq2.add(now);
                answer = Math.max(answer, pq2.size());
                continue;
            }
            
            while(!pq2.isEmpty() && pq2.peek().e <= now.s) {
                pq2.poll();
            }
            pq2.add(now);
            
            answer = Math.max(answer, pq2.size());
            
        }
        
        System.out.println(answer);
        
    }
    
    static class Class {
        int num;
        int s;
        int e;
        
        public Class(int num, int s, int e) {
            this.num = num;
            this.s = s;
            this.e = e;
        }
    }
}