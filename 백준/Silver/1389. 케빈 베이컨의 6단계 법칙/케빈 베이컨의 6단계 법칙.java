// 1389 케빈 베이컨의 6단계 법칙
// https://www.acmicpc.net/problem/1389
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> a = new ArrayList<>();
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static int tmp, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int n = 0; n <= N; n++) {
            a.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) { // 간선 연결
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a.get(s).add(e);
            a.get(e).add(s);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            tmp = 0;
            bfs(i);
        }

        System.out.println(result);
    }

    static void bfs(int start) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {start,0});
        visit[start] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int next : a.get(now[0])) {
                if (visit[next]) continue;
                visit[next] = true;
                tmp += now[1]+1;
                que.offer(new int[] {next, now[1]+1});
            }
        }
        
        if (tmp < min) {
        	result = start;
        	min = tmp;
        } else if (tmp == min) {
        	result = Math.min(result, start);
        }
    }

}