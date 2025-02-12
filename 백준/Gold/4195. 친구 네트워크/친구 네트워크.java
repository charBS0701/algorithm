import java.io.*;
import java.util.*;
// BOJ 4195 (친구 네트워크)
public class Main
{   
    static int T, F;
    static final int N = 200_000;
    static int[] parents;
    static int[] child;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            F = Integer.parseInt(br.readLine());
            makeSet();
            
            for (int f=1; f<=F; f++) {      // 친구 관계 입력
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a,map.size());
                }
                if (!map.containsKey(b)) {
                    map.put(b,map.size());
                }
                
                int idx1 = map.get(a);
                int idx2 = map.get(b);
                
                int tmp = child[find(idx2)];
                if (union(idx1,idx2)) {
                    child[find(idx1)] += tmp;
                }
                
                sb.append(child[find(idx1)]).append("\n");
                
            }
        
        }
        
        System.out.println(sb);
	}
	
    static void makeSet() {
        parents = new int[N+1];
        child = new int[N+1];
        for (int n=0; n<=N; n++) {
            parents[n] = n;
            child[n] = 1;      // 네트워크의 친구 수
        }
    }
    
    static int find(int a) {
        if (parents[a] == a) return parents[a];
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if (parentA == parentB) return false;
        parents[parentB] = parentA;
        return true;
    }
}