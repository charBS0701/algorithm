import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int time = Integer.MAX_VALUE;
    static PriorityQueue<Job> pq = new PriorityQueue<>((o1,o2) -> o2.s - o1.s);     // 늦게 끝내도 되는 순으로 정렬
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pq.add(new Job(t,s));
        }
        
        while (!pq.isEmpty() && time > 0) {
            Job job = pq.poll();
            if (time > job.s) {
                time = job.s;    
            }
            time -= job.t;
        }
        
        System.out.println(time < 0 ? -1 : time);
        
    }
    
    static class Job {
        int t;
        int s;
        public Job(int t, int s) {
            this.t = t;
            this.s = s;
        }
    }

}