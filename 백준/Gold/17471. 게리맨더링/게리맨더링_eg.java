import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 2개의 그룹 나눈다. => 부분집합 => select 배열 선택/비선택
// 부분집합이 유효한지? 각 그룹의 선택된 수 최소 1개 이상, 모두 연결
// 각각 그룹 모두 연결?? 그래프의 자료구조(인접행렬) 를 이용해서 완탐 갈 수 있는 곳을 모두 방문
//   <= 모두 갈 수 있으면 모두 연결, 하나라도 못 가면 모두 연결 X
// 모든 조건이 통과되면 A, B 두개의 인구수를 합하고, 차이의 최소값을 구한다.
// 선거구별 인구수는 인접행렬 0 가 dummy 인데 이곳을 활욜
public class Main {

    static int N, min;
    static int[][] matrix;
    static boolean[] select; // 부분집합에서 사용, true: A, false: B
    static boolean[] visit; // 모두 연결되어 있는 지 판단 사용, 갈 수 있는 곳이면 true
    // 갈 수 있는 모든 곳을 방문했는 데 visit [] 에 false 가 있다면 모두 연결 X
    static Queue<Integer> queue = new ArrayDeque<>(); // 모두 연결 완탐 : bfs
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 구역의 수
        
        matrix = new int[N+1][N+1]; // 그래프의 인접 행렬, 0 dummy
        select = new boolean[N+1];
        visit = new boolean[N+1];
        min = Integer.MAX_VALUE;
        
        // 인구수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken()); // 맨 앞 인구수 저장
        }
        
        // 인접 구역
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // i 구역에 인접한 구역의 수
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                matrix[i][j] = v;
            }
        }

        subset(1); // 1 구역 선택/비선택.....
        
        if( min == Integer.MAX_VALUE ) System.out.println(-1); // 불가능한 경우
        else System.out.println(min);
    }

    // 이미 두 개의 그룹으로 나뉜 상태 <= select 배열에 true/false 로 구분되어 있다.
    // 유효성 검증 (그룹별로 1개이상, 두그룹 모두 연결) 후에 min 갱신
    static void check() {
        // visit, queue
        Arrays.fill(visit, false);
        queue.clear();
        
        // A : select:true
        for (int i = 1; i <= N; i++) {
            if( select[i] ) {
                visit[i] = true;
                queue.offer(i);
                break; // 한 구역만 넣고 bfs 준비
            }
        }
        
        if( queue.size() == 0 ) return;
        while( !queue.isEmpty() ) {
            int v = queue.poll();
            for (int i = 1; i <= N; i++) {
                int adj = matrix[v][i];
                if( adj != 0 && ! visit[adj] && select[adj]) {
                    visit[adj] = true;
                    queue.offer(adj);
                }
            }
        }
                
        // B : select:false
        for (int i = 1; i <= N; i++) {
            if( ! select[i] ) {
                visit[i] = true;
                queue.offer(i);
                break; // 한 구역만 넣고 bfs 준비
            }
        }
        
        if( queue.size() == 0 ) return;
        
        while( !queue.isEmpty() ) {
            int v = queue.poll();
            for (int i = 1; i <= N; i++) {
                int adj = matrix[v][i];
                if( adj != 0 && ! visit[adj] && !select[adj]) {
                    visit[adj] = true;
                    queue.offer(adj);
                }
            }
        }    
        
        // 모든 구역이 모두 연결되었는 지 확인
        for (int i = 1; i <= N; i++) {
            if( !visit[i] ) return; // 연결되지 않은 구역 발견
        }
        
        // 유효성 검증 완료
        int sumA = 0;
        int sumB = 0;
        
        for (int i = 1; i <= N; i++) {
            if( select[i] ) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }
        
        min = Math.min(min, Math.abs(sumA - sumB));
    }
    
    static void subset(int srcIdx) { // 1 ~> N 선택/비선택
        // 기저조건
        if( srcIdx == N + 1 ) {
            // 경우의 수 
            check();
            return;
        }
        
        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
}
