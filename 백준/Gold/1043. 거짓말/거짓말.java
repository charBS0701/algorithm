import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, know; // 사람수 / 파티수 / 진실아는사람수
    static List<List<Integer>> parties = new ArrayList<>(); // 파티당 참석하는 사람들
    static List<List<Integer>> graph = new ArrayList<>(); // 인간관계 그래프
    static List<Integer> knows = new ArrayList<>(); // 진실을 아는 사람들
    static List<Integer> knows2 = new ArrayList<>(); // 진실을 아는 사람들
    static int[] tgt = new int[2];
    static int result;
    static boolean visit[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        know = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        for (int i = 0; i <= N; i++) { // 인간관계 테이블
            graph.add(new ArrayList<>());
        }
        if (know != 0) { // 진실을 아는 사람들 추가
            while (st.hasMoreTokens()) {
            	int tmp = Integer.parseInt(st.nextToken());
            	knows.add(tmp);
            	knows2.add(tmp);
            }
        }

        for (int m = 0; m < M; m++) { // 각 파티마다
            parties.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 오는 사람 수
            for (int i = 0; i < num; i++) { // 오는 사람들 입력
                int person = Integer.parseInt(st.nextToken());
                parties.get(m).add(person);
            }
            combs(0, 0, m); // 인간관계 채우기
        }
        
        for (int know : knows2) {
        	visit = new boolean[N+1];
            bfs(know);
        }
        
        // 파티 순회
        for (int i=0; i<M; i++) {
            boolean flag = true;
            for (int p : knows) {
                if (parties.get(i).contains(p)) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        
        System.out.println(result);
    }
    
    public static void bfs(int node) {
        visit = new boolean[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(node);
        visit[node] = true;
        
        while(!que.isEmpty()) {
            int now = que.poll();
            
            for (int next : graph.get(now)) {
                if (visit[next]) continue;
                que.offer(next);
                visit[next] = true;
                if (!knows.contains(next)) {
                    knows.add(next);
                }
            }
        }
        
    }

    public static void combs(int srcIdx, int tgtIdx, int partyIdx) {
        if (tgtIdx == 2) {
            if (!graph.get(tgt[0]).contains(tgt[1]))
                graph.get(tgt[0]).add(tgt[1]);
            if (!graph.get(tgt[1]).contains(tgt[0]))
                graph.get(tgt[1]).add(tgt[0]);
            return;
        }

        if (srcIdx == parties.get(partyIdx).size())
            return;

        tgt[tgtIdx] = parties.get(partyIdx).get(srcIdx);

        combs(srcIdx + 1, tgtIdx + 1, partyIdx);
        combs(srcIdx + 1, tgtIdx, partyIdx);
    }
}