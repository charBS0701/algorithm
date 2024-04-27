import java.io.*;
import java.util.*;

public class Main {

	static int N;	// 1 ~ 3 * 10**5
	static long sum;
	static List<Element> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a, b;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list.add(new Element(a,b));
		}
		
		while (list.size()>1) {
			Element e1 = list.remove(list.size()-1);
			Element e2 = list.remove(list.size()-1);
			
			sum += e1.a * e2.b + e1.b * e2.a;
			list.add(new Element(e1.a+e2.a, e1.b+e2.b));
		}
		
		System.out.println(sum);
		
	}
	
	static class Element {
		long a, b;
		public Element(long a, long b) {
			this.a = a;
			this.b = b;
		}
	}
}