package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// PriorityQueue 사용 X
// enemyCopy 는 ArrayList 가 합당. 입력받으면서 확인되고, 복사만 해 주면 되므로.
// 어차피 enemy 는 매번 초기화 - 문제풀이(삭제) - 다시 초기화가 반복되므로 배열로 만들면? Enemy 객체도 2차원 배열로 표현해 보자
// 궁사에게 쏘인 적은 null 처리
// 적은 수가 굉장히 크면 배열안의 null 처리가 부담될 수 있으나, 오히려 ArrayList 도 그만큼 index 조정에 시간이 걸린다.

public class BJ_캐슬디펜스_17135_3 {

    static int N, M, D, enemySize, max;
    static int[] archer = new int[3];    // 궁수 3자리 (x 좌표)
    static List<int[]> enemyCopy = new ArrayList<>();
    static int[][] enemy;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 행 - N
        N = Integer.parseInt(st.nextToken());
        // 열 - M
        M = Integer.parseInt(st.nextToken());
        // 사정거리 - 공격 거리제한
        D = Integer.parseInt(st.nextToken());
        
        // 적군 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 1 ) enemyCopy.add(new int[] {i, j, 0});
            }
        }
        
        enemySize = enemyCopy.size();
        // enemy 배열 객체 생성
        enemy = new int[enemySize][3]; // 0: y, 1: x, 2: dead ( 0: alive, 1: dead )

        // 만약 모든 enemy의 y가  Y가 된다면 방어 실패
        // 0 <= x && x < C인  x에서 3개를 고르는 조합
        // 조합이 완성되면 check() 로 확인
        comb(0, 0);
        System.out.println(max);
    }

    static void check() {
        
        // 복사해서 쓴다.
        for (int i = 0; i < enemySize; i++) {
            int[] e = enemyCopy.get(i);
            enemy[i] = new int[] {e[0], e[1], e[2]};
        }

        // 시뮬레이션 시작
        int dead = 0;
        int enemyCnt = enemySize; // enemy[] 중 살아있는 enemy 수 <= while 종료 조건
        while (true) {
            
            // 궁수가 한 명씩 발사
            // 다른 궁사가 같은 적을 쏠 수도 있다. <= dead 로 표시만 하고 모든 궁사가 다 쏘고 나서 dead 처리
            for (int i = 0; i < 3; i++) {

                int ac = archer[i];
                int size = enemySize;
                
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minIdx = -1;
                
                for (int j = 0; j < size; j++) {
                    int[] e = enemy[j];
                    
                    if( e == null ) continue; // 죽거나 사라진 enemy
                    
                    // 턴 마다 새롭게 d 계산
                    int d = Math.abs(ac - e[1]) + Math.abs(N - e[0]);
                    
                    if( d > D ) continue;
                    
                    if( minD == d ) {
                        if( minX > e[1] ) {
                            minX = e[1];
                            minIdx = j;
                        }
                    }else if( minD > d ) {
                        minD = d;
                        minX = e[1];
                        minIdx = j;
                    }
                }
                
                if( minIdx != -1 ) {
                    enemy[minIdx][2] = 1;
                }
            }

            // 사망자 정리 및 이동, 종료 체크   <= i 뒤 부터  
            for (int i = 0; i < enemySize; i++) {
                
                if( enemy[i] == null ) continue;
                
                if( enemy[i][2] == 1 ) {
                    enemy[i] = null;
                    dead++; // 사망자 처리
                    enemyCnt--;
                }else if( enemy[i][0] == N - 1) {
                    enemy[i] = null; // 맨 아래 적 제외
                    enemyCnt--;
                }else {
                    enemy[i][0]++; // 남은 적 아래로 한 칸 이동
                }
            }

            // 모든 병사가 다 사라지면
            if ( enemyCnt == 0 ) break;
        }
        
        max = Math.max(max, dead);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 3) {
            check();
            return;
        }
        if (srcIdx == M) {
            return;
        }
        
        archer[tgtIdx] = srcIdx;

        comb(srcIdx + 1, tgtIdx + 1);    // 선택(O)
        comb(srcIdx + 1, tgtIdx);         // 선택(X)
    }
}
