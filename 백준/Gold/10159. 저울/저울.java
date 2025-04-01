import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static List<List<Integer>> adjList2 = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());        // 물건의 수    
		M = Integer.parseInt(br.readLine());        // 비교 쌍 수
		
		for (int n=0; n<=N; n++) {
		    adjList.add(new ArrayList<>());
		    adjList2.add(new ArrayList<>());
		}
		
		for (int m=0; m<M; m++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    adjList.get(b).add(a);
		    adjList2.get(a).add(b);
		}
		
		for (int i=1; i<=N; i++) {
		    set.clear();
		    set.add(i);
		    
		    getBiggers(i);
		    getSmallers(i);
		    
		    sb.append(N-set.size()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void getBiggers(int now) {
	    for (int bigger : adjList.get(now)) {
	        if (set.contains(bigger)) continue;
	        set.add(bigger);
	        getBiggers(bigger);
	    }
	}
	
	static void getSmallers(int now) {
	    for (int smaller : adjList2.get(now)) {
	        if (set.contains(smaller)) continue;
	        set.add(smaller);
	        getSmallers(smaller);
	    }
	}
}