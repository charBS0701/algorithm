import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer;
    static boolean[][] cal;
    static PriorityQueue<Plan> pq = new PriorityQueue<>((o1, o2) -> o1.s == o2.s ? o2.days - o1.days : o1.s - o2.s);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cal = new boolean[1001][366];  // 1000개의 일정과 365일을 처리할 수 있도록 수정
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            pq.add(new Plan(S, E));
        }

        while (!pq.isEmpty()) {
            Plan plan = pq.poll();
            boolean flag = false;
            for (int i = 0; i < 1001; i++) {  // 1000개로 크기 확장
                if (!cal[i][plan.s]) {
                    for (int j = plan.s; j <= plan.e; j++) {
                        if (cal[i][j]) break;
                        if (j == plan.e) flag = true;
                    }
                }

                if (flag) {
                    for (int j = plan.s; j <= plan.e; j++) {
                        cal[i][j] = true;
                    }
                    break;
                }
            }
        }

        int start = 0;
        int num = 0;  // 연속된 기간에서 최대 일정 개수
        for (int c = 1; c <= 365; c++) {  // 1일부터 365일까지 처리
            boolean flag = false;  // 해당 날 일정 여부
            for (int r = 0; r < 1001; r++) {
                if (cal[r][c]) {
                    if (start == 0) start = c;
                    flag = true;
                    num = Math.max(num, r + 1);
                }
            }
            if (!flag && num != 0) {
                answer += (c - start) * num;
                start = 0;
                num = 0;
            }
        }

        // 마지막 처리
        if (start != 0) {
            answer += (365 - start + 1) * num;
        }

        System.out.println(answer);
    }

    static class Plan {
        int s;
        int e;
        int days;

        public Plan(int s, int e) {
            this.s = s;
            this.e = e;
            this.days = e - s + 1;
        }
    }
}
