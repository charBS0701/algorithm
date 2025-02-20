import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 1~1000
    static List<List<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> restPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
    static int sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        for (int n=0; n<=1000; n++) {
            list.add(new ArrayList<>());
        }
                
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());       // 남은 마감일
            int w = Integer.parseInt(st.nextToken());       // 점수
            list.get(d).add(w);
        }
        
        for (int t=1000; t>0; t--) {
            if (list.get(t).size() == 0 && restPQ.size() == 0) continue;  // 할 거 없음
            
            for (int re : list.get(t)) {      // 남은 과제 pq에 저장
                restPQ.add(re);
            }
            
            sum += restPQ.poll();
            
        }
        
        System.out.println(sum);
    }
}