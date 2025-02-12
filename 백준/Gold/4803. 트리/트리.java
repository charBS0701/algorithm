import java.io.*;
import java.util.*;

public class Main
{   
    static int N, M;
    static int[] parents;
    static Set<Integer> cycleSet = new HashSet<>();
    static Set<Integer> resSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int test = 0;
        while (true) {
            ++test;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            makeSet();
            cycleSet.clear();
            
            for (int m=1; m<=M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (!union(a,b)) {  // 사이클이 존재
                    cycleSet.add(find(a));
                };
            }
            
            
            int count = 0;
            resSet.clear();
            for (int el : cycleSet) {
                resSet.add(find(el));
            }
            
            for (int n=1; n<=N; n++) {      // 트리 카운트
                if (resSet.contains(find(n))) continue;
                resSet.add(find(n));
                count++;
            }
            
            sb.append("Case ").append(test).append(": ");
            if (count == 0) {
                sb.append("No trees.");
            } else if (count == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
            
        }
        
        System.out.println(sb);
	}
	
    static void makeSet() {
        parents = new int[N+1];
        for (int n=0; n<=N; n++) {
            parents[n] = n;
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