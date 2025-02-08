import java.io.*;
import java.util.*;

class Main {
    
    static int N, M, K, k;
    static int[] prices;
    static int[] parents;
    static boolean[] friends;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 친구 수
        M = Integer.parseInt(st.nextToken());   // 관계 수
        k = Integer.parseInt(st.nextToken());   // 용돈버짓
        K = k;      // 초기 용돈 저장

        makeSet();
        
        prices = new int[N+1];        
        st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++) {      // 친구비 입력
            int price = Integer.parseInt(st.nextToken());
            prices[n] = price;
        }
        
        for (int m=0; m<M; m++) {      // 친구관계 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        
        friends = new boolean[N+1];
        for (int n=1; n<=N; n++) {
            int parentN = find(n);
            if (friends[parentN]) continue;     // 이미 친구면 pass
            if (prices[parentN] <= k) {         // 친구비 납입 가능
                friends[parentN] = true;
                k -= prices[parentN];
            } else {
                System.out.println("Oh no");
                return;
            }
        }        
        
        System.out.println(K-k);
        
    }
    
    static void makeSet() {
        parents = new int[N+1];
        for (int n=1; n<=N; n++) {
            parents[n] = n;
        }
    }
    
    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        int priceA = prices[parentA];
        int priceB = prices[parentB];
        if (parentA == parentB) {
            return false;
        } else if (priceA < priceB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
        return true;
    }
}