import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // makeSet
        parent = new int[N+1];
        makeSet();
        
        // 시뮬레이션
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (oper == 0) {    // union
                union(a,b);
            } else if (oper == 1) {     // check if(findSet(a)==findSet(b))
                if (findSet(a) == findSet(b)) {
                    sb.append("YES").append("\n");
                } else sb.append("NO").append("\n");
            }
        }
    
        System.out.println(sb);
    
    }
    
    static void makeSet() {
        for (int n=0; n<=N; n++) {
            parent[n] = n;
        }
    }
    
    static int findSet(int child) {
        if (child == parent[child]) return child;
        else return parent[child] = findSet(parent[child]);     // path 압축
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