import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int time = Integer.MAX_VALUE;
    static PriorityQueue<Job> pq = new PriorityQueue<>((o1,o2) -> o2.s == o1.s ? o2.t-o1.t : o2.s-o1.s);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    for (int n=0; n<N; n++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int t_i = Integer.parseInt(st.nextToken());
	        int s_i = Integer.parseInt(st.nextToken());
	        
            pq.add(new Job(t_i, s_i));
	    }
        
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            time = Math.min(time, job.s);   // 이 마칠 수 있는 가장 늦은 시간
            time -= job.t;  // 일 끝냄
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
