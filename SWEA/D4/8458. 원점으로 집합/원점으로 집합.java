import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 원점과 N 개의 점 사이의 거리 최적화 문제 ? ==> N 개의 점들 간의 관계 문제
/*
1. 2차원 배열을 1차원 배열로 만들 순 없을까?
    => 아예 원점으로부터의 맨하탄 거리를 계산해서 0 ~ >> 양의 정수로 표현 (2,-2) => 일직선상의 0 ~~> 4
2. 모두가 원점으로 올 수 없는 경우는?
    => 모든 점의 거리리가 모두 짝수이거나 모두 홀수이어야 한다.
3. 정말 모든 점이 한꺼번에 다 움직이면서 따져야 할 까?
    => 원점으로부터 가장 먼 점 기준으로 몇 번 움직이면 되는지 계산
    => 더 가까운 점들은 가장 먼 점이 도착하는 동안 원점으로부터 반 지나쳐서 반 돌아오면 된다.
4. 원점을 지나치는 경우는 ?
    => 원점으로부터 반 지나쳐서 반 돌아오면 된다.
 */
 
public class Solution {
     
    static int T, N, cnt;
    static int[] point; // 1차원 배열(원점으로부터 맨하탄 거리 지정)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            point = new int[N];
            // 입력을 받으면서 맨하탄 거리 계산
            // 가장 먼 점 계산
            // 모두 짝수, 홀수 여부도 함께 <= 이전 점과 현재 점 비교 <= index : i-1 <= 맨 처음값은 받고 시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[0] = Math.abs(x) + Math.abs(y);
            int maxLen = point[0];      // 첫 번째 점을 최초 지정
             
            boolean stop = false;   // 입력을 따져보고 진행할 필요 X 이면 true
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                point[i] = Math.abs(x) + Math.abs(y);
                maxLen = Math.max(maxLen, point[i]);
                 
                // 모두 짝수, 홀수 여부
                if (point[i] % 2 != point[i-1] % 2) stop = true;
            }
             
            if (stop) {
                sb.append("#").append(t).append(" ").append(-1).append("\n");
                continue;
            }
             
            // 모두 원점으로 올 수 있는 테케
            // maxLen 에 가장 먼 거리
            cnt = 0;
            int sum = 0;    // 원점까지의 누적거리
            while (true) {
                if (sum == maxLen || (sum > maxLen && (sum - maxLen) % 2 == 0)) break;
                // 원점에 도달 break
                sum += ++cnt;   // 
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
             
        }
        System.out.println(sb);
    }
}