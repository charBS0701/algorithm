import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // makeSet()
        parent = new int[N];
        for (int n=0; n<N; n++) {
            parent[n] = n;
        }
        
        // 사이클이 처음으로 만들어진 차례의 번호를 출력 else 0 출력
        // 두 선분의 루트노트가 같으면 사이클 생성
        
        for (int i=1; i<=M; i++) {      // i번째 차례에 플레이어가 선택한 두 점의 번호
            st = new StringTokenizer(br.readLine());
            int dot1 = Integer.parseInt(st.nextToken());
            int dot2 = Integer.parseInt(st.nextToken());
            
            if (!union(dot1, dot2)) {   // 사이클 발생
                System.out.println(i);
                return;
            } else {
                union(dot1, dot2);
            }
        }
        
        System.out.println(0);
 
    }
    
    static int findSet(int node) {
        if (parent[node] == node) return node;
        else {
            return parent[node] = findSet(parent[node]);
        }
    }
    
    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        
        if (parentA == parentB) {
            return false;
        } else if (parentA < parentB) {
            parent[findSet(parentB)] = findSet(parentA);
        } else {
            parent[findSet(parentA)] = findSet(parentB);
        }
        return true;
    }
}