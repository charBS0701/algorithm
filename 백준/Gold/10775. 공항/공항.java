import java.io.*;
import java.util.*;

public class Main
{   
    static int G, P;
    static int[] parents;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());        // 공항 수
        P = Integer.parseInt(br.readLine());        // 비행기 수
        
        makeSet();
        
        for (int p=1; p<=P; p++) {
            int g = Integer.parseInt(br.readLine());    // 도킹하려는 공항
            int target = find(g);
            if (target == 0) {
                System.out.println(p-1);
                return;
            }
            union(find(target-1), target);
        }
        System.out.println(P);
	}
	
    static void makeSet() {
        parents = new int[G+1];
        for (int g=0; g<=G; g++) {
            parents[g] = g;
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