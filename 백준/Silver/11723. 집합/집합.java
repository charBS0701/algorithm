import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			switch (command) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "check":
				sb.append(set.contains(x) ? 1 : 0).append("\n");
				break;
			case "toggle":
				if (set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			case "all":
				for (int i = 1; i <= 20; i++) {
					set.add(i);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
			
		}
		System.out.println(sb);
	}
}	
