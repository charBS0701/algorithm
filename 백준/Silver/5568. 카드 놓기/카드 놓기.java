import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static int n, k;
    static int[] arr;
    static int[] tgt;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        tgt = new int[k];
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3장 고름
        perm(0);

        System.out.println(answer);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == k) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<k; i++) {
                sb.append(String.valueOf(tgt[i]));
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                answer++;
            }
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            tgt[tgtIdx] = arr[i];
            visited[i] = true;
            perm(tgtIdx+1);
            visited[i] = false;
        }
    }
}