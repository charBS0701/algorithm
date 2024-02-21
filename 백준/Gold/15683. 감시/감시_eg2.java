package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 기존 map에 비추는 작업(write)을 하고 다 따진 뒤에 원복???
// 아무수나 write 가령 9 이후 이전 수??
// +1 ~> -1  <= 5 카메라가 벽으로 ??
// -1 ~> +1  <= 1 카메라가 0 <= count...<= 대책:  카메라 위치의 좌표는 모두 -1로 초기화
public class 감시_15683_eg2 {
    
    static int N, M, min;
    static int[][] map;
    static List<Cam> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if( n >= 1 && n <= 5 ) {
                    list.add(new Cam(i, j, n));
                    map[i][j] = -1; // 원복에 영향을 미치지 않도록
                }
            }
        }
        
        // 풀이
        min = Integer.MAX_VALUE;
        dfs(0); // 맨 앞 Cam
        System.out.println(min);
    }

    // idx : list 에 담긴 cam 객체 index
    // parent : 현재 idx 번째 cam 에서 따지기 직전 상태 배열이 복사되어 전달
    static void dfs(int idx) { 
        // 기저조건
        // 감시카메라가 비치지 않은 좌표 계산 min 갱신, return
        if( idx == list.size() ) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if( map[i][j] == 0 ) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }
        
        // idx 번 cam 으로 탐색
        Cam c = list.get(idx);
        
        switch(c.n) {
            case 1 : // 상,하,좌,우 각각 한 방향으로만 감시
                for (int d = 0; d < 4; d++) {
                    // 비추는 작업
                    watch(c.y, c.x, d);
                    dfs(idx + 1);
                    unwatch(c.y, c.x, d);
                }
                break;
            case 2 : // 상하, 좌우 감시
                for (int d = 0; d < 2; d++) {
                    // 비추는 작업
                    watch(c.y, c.x, d);
                    watch(c.y, c.x, d+2);
                    dfs(idx + 1);
                    unwatch(c.y, c.x, d);
                    unwatch(c.y, c.x, d+2);
                }                
                break;
            case 3 : // L 형 감시 
                for (int d = 0; d < 4; d++) {
                    // 비추는 작업
                    watch(c.y, c.x, d);
                    watch(c.y, c.x, (d+1) % 4);
                    dfs(idx + 1);
                    unwatch(c.y, c.x, d);
                    unwatch(c.y, c.x, (d+1) % 4);
                }                    
                break;
            case 4 : // ㅗ 형 감시 
                for (int d = 0; d < 4; d++) {
                    // 비추는 작업
                    watch(c.y, c.x, d);
                    watch(c.y, c.x, (d+1) % 4);
                    watch(c.y, c.x, (d+2) % 4);
                    dfs(idx + 1);
                    unwatch(c.y, c.x, d);
                    unwatch(c.y, c.x, (d+1) % 4);
                    unwatch(c.y, c.x, (d+2) % 4);
                }    
                break;
            case 5 : // 상하좌우 동시에 
                // 비추는 작업
                watch(c.y, c.x, 0);
                watch(c.y, c.x, 1);
                watch(c.y, c.x, 2);
                watch(c.y, c.x, 3);
                dfs(idx + 1);
                unwatch(c.y, c.x, 0);
                unwatch(c.y, c.x, 1);
                unwatch(c.y, c.x, 2);
                unwatch(c.y, c.x, 3);
                break;
        }
    }
    
    // 주어진 좌표에서부터 dir 방향으로 비추는 작업 -- 감소
    // 6 만나면 멈춤.
    // Cam 제외
    static void watch(int y, int x, int dir) {
        // dir : 0(좌) 1(상) 2(우) 3(하)
        switch(dir) {
            case 0 : // 좌
                for (int i = x - 1; i >= 0; i--) {
                    if( map[y][i] == 6) break;
                    map[y][i]--;
                }
                break;
            case 1 : // 상
                for (int i = y - 1; i >= 0; i--) {
                    if( map[i][x] == 6) break;
                    map[i][x]--;
                }
                break;
            case 2 : // 우
                for (int i = x + 1; i < M; i++) {
                    if( map[y][i] == 6) break;
                    map[y][i]--;
                }
                break;
            case 3 : // 하
                for (int i = y + 1; i < N; i++) {
                    if( map[i][x] == 6) break;
                    map[i][x]--;
                }
                break;
        }
    }

    static void unwatch(int y, int x, int dir) {
        // dir : 0(좌) 1(상) 2(우) 3(하)
        switch(dir) {
            case 0 : // 좌
                for (int i = x - 1; i >= 0; i--) {
                    if( map[y][i] == 6) break;
                    map[y][i]++;
                }
                break;
            case 1 : // 상
                for (int i = y - 1; i >= 0; i--) {
                    if( map[i][x] == 6) break;
                    map[i][x]++;
                }
                break;
            case 2 : // 우
                for (int i = x + 1; i < M; i++) {
                    if( map[y][i] == 6) break;
                    map[y][i]++;
                }
                break;
            case 3 : // 하
                for (int i = y + 1; i < N; i++) {
                    if( map[i][x] == 6) break;
                    map[i][x]++;
                }
                break;
        }
    }
    static class Cam{
        int y, x, n;
        Cam(int y, int x, int n){
            this.y = y; this.x = x; this.n = n;
        }
    }
}

