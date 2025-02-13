import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] parents;
    static Set<Integer>[] sets;
    static boolean[] isCounted;
    static int answer;
    static final int MAX = 1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        makeSet();
        sets = new HashSet[N+1];
        for (int n=1; n<=N; n++) {
            sets[n] = new HashSet<Integer>();
        }
        
        StringTokenizer st = null;
        for (int m=1; m<=M; m++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
        
            if (c == 'F') {     // 친구
                union(p,q);
            } else {            // 적
                sets[p].add(q);
                sets[q].add(p);
            }
        }
        
        // 적의 적 끼리 친구되기
        for (int n=1; n<=N; n++) {
            if (sets[n].size() < 2) continue;
            Iterator<Integer> iter = sets[n].iterator();
            int root = iter.next();
            while(iter.hasNext()) {
                union(root, iter.next());
            }
        }
        
        isCounted = new boolean[N+1];
        for (int n=1; n<=N; n++) {
            int parentN = find(n);
            if (isCounted[parentN]) continue;
            isCounted[parentN] = true;
            answer++;
        }
        
        System.out.println(answer);
        
    }
    
    static void makeSet() {
        parents = new int[N+1];
        for (int n=1; n<=N; n++) {
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