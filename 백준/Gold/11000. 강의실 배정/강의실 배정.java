import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int answer;
	static List<Lecture> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long t = Long.parseLong(st.nextToken());
			list.add(new Lecture(s,t));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Long> during = new PriorityQueue<>();
		for (Lecture el : list) {
			during.add(el.t);
			while (during.peek() <= el.s) {
				during.poll();
			}
			answer = Math.max(answer, during.size());
		}
		
		System.out.println(answer);
		
	}
	
	static class Lecture implements Comparable<Lecture>{
		long s;
		long t;
		public Lecture(long s, long t) {
			this.s=s;
			this.t=t;
		}
		
		@Override
		public int compareTo(Lecture other) {
			if (this.s != other.s) return Long.compare(this.s, other.s);
			else return Long.compare(this.t, other.t);
		}

	}
}
		
	