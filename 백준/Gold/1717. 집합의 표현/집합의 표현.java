import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());	// 연산의 개수
		parent = new int[n+1];
		
		// init
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());	// 0: 합, 1: 확인
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (op == 0) {
				union(a,b);
			} else if (op==1) {
				sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a==b) {
			return;
		} else {
			if (a < b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
		
	}

}
