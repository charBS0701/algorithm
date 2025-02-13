import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] parents;
    static int[] enemy;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        makeSet();
        enemy = new int[N+1];
        

        for (int m=1; m<=M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (find(a) == find(b)) {       // 입력관계가 친구면 이론 불성립
                System.out.println(0);
                return;
            }
            
            if (enemy[a] != 0) union(b, enemy[a]);
            if (enemy[b] != 0) union(a, enemy[b]);
            
            enemy[a] = b;
            enemy[b] = a;
        
        }
        
        System.out.println(1);
        
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