import java.io.*;
import java.util.*;

public class Main {
    
    static class Jew implements Comparable<Jew>{
        int m,v;
        public Jew(int m, int v) {
            this.m = m;
            this.v = v;
        }
        @Override
        public int compareTo(Jew o) {
            return Integer.compare(o.v, this.v);   // 비싼거 순
        }
    }
    
    static int N, K;
    static PriorityQueue<Jew> jpq = new PriorityQueue<>();
    static TreeMap<Integer, Integer> bags = new TreeMap<>();
    static long answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());       // 무게 
            int v = Integer.parseInt(st.nextToken());       // 가격
            jpq.offer(new Jew(m,v));
        }
        
        for (int k=0; k<K; k++) {
            int c = Integer.parseInt(br.readLine());        // 가방당 넣을 수 있는 무게
            bags.put(c, bags.getOrDefault(c,0) + 1);
        }        
        
        // 비싼걸 담을 수 있는 최소한의 가방크기먼저
        while (!jpq.isEmpty() && !bags.isEmpty()) {
            Jew jewel = jpq.poll();
            Integer bag = bags.ceilingKey(jewel.m);
            
            if (bag != null) {
                answer += jewel.v;
                if (bags.get(bag) == 1) bags.remove(bag);
                else bags.put(bag, bags.get(bag)-1);
            }
        }
        
        System.out.println(answer);
        
    }
    
}