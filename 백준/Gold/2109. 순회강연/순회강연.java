import java.io.*;
import java.util.*;

public class Main {
    static int N;       // 0~10000
    static List<List<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> restPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
    static int sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        for (int n=0; n<=10000; n++) {
            list.add(new ArrayList<>());
        }
                
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());       // 강연료
            int d = Integer.parseInt(st.nextToken());       // 남은 기한
            list.get(d).add(p);
        }
        
        for (int t=10000; t>0; t--) {
            if (list.get(t).size() == 0 && restPQ.size() == 0) continue;  // 할 거 없음
            
            for (int re : list.get(t)) {      // 남은 과제 pq에 저장
                restPQ.add(re);
            }
            
            sum += restPQ.poll();
            
        }
        
        System.out.println(sum);
    }
}