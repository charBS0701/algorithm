import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class Main{

	static class Ele implements Comparable<Ele> {
		int min;
		int max;

		public Ele(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return this.min + " ~ " + this.max + "\n";
		}

		@Override
		public int compareTo(Ele o) {
			return this.max == o.max ? this.min - o.min : this.max - o.max;
		}
	}
	
	static int N;
	static int result=1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		List<Ele> list = new ArrayList<>();

		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Ele(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	// 화학물질 입력
		}
		Collections.sort(list);
		
//		for (Ele a : list) {
//			System.out.print(a);
//		}
		
		int prevMax = list.get(0).max;
		for (int i = 1; i<N; i++) {
			if (prevMax < list.get(i).min) {
				result++;
				prevMax = list.get(i).max;
			}
		}

		System.out.println(result);
	}
}
