import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        // makeSet()
        parent = new int[N+1];
        for (int n=1; n<=N; n++) {
            parent[n] = n;
        }
        
        // 도시 간 연결여부 입력
        StringTokenizer st;
        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int n2=1; n2<=N; n2++) {
                int city = Integer.parseInt(st.nextToken());
                if (city == 0) continue;
                union(n, n2);
            }
        }
        
        st = new StringTokenizer(br.readLine());    // 여행계획
        int rep = Integer.parseInt(st.nextToken());
        for (int m=0; m<M-1; m++) {
            int city = Integer.parseInt(st.nextToken());
            if (parent[rep] != findSet(city)) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
        
    }
    
    static int findSet(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = findSet(parent[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        
        if (parentA == parentB) return false;
        else if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
        return false;
    }
}