import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}
}
		
	