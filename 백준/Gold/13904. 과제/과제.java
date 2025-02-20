import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 1~1000
    static boolean[] did = new boolean[1001];
    static List<PriorityQueue<Integer>> pqList = new ArrayList<>();
    static PriorityQueue<Integer> restPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
    static int sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        for (int n=0; n<=1000; n++) {
            pqList.add(new PriorityQueue<>((o1,o2)->o2-o1));
        }
                
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());       // 남은 마감일
            int w = Integer.parseInt(st.nextToken());       // 점수
            pqList.get(d).add(w);
        }
        
        for (int t=1000; t>0; t--) {
            // System.out.println(t + "초!!");
            if (pqList.get(t).size() == 0 && restPQ.size() == 0) continue;  // 할 거 없음
            
            int restTop = -1;
            if (restPQ.size() != 0) restTop = restPQ.peek();
            
            int nowTop = -1;
            if (pqList.get(t).size() != 0) nowTop = pqList.get(t).peek();
            
            if (nowTop >= restTop) {
                sum += pqList.get(t).poll();
            } else {
                sum += restPQ.poll();
            }
            
            for (int re : pqList.get(t)) {      // 남은 과제 pq에 저장
                restPQ.add(re);
            }
            
        }
        
        System.out.println(sum);
    }
}