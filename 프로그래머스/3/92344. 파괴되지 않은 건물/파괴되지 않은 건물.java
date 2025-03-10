import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] impact;  // 변화량 기록
    static int answer;
    
    public int solution(int[][] board, int[][] skill) {
        N = board.length;       //  <= 1000
        M = board[0].length;    //  <= 1000
        impact = new int[N+1][M+1];
        
        // 'impact 에 변화량 기록'
        for (int k=0; k<skill.length; k++) {
            int type = skill[k][0], degree = skill[k][5];
            int r1 = skill[k][1], c1 = skill[k][2];
            int r2 = skill[k][3], c2 = skill[k][4];
            
            int effect = (type == 1) ? -degree : degree;
            impact[r1][c1] += effect;
            impact[r1][c2+1] -= effect;
            impact[r2+1][c1] -= effect;
            impact[r2+1][c2+1] += effect;
        }
        
        // 행 기준 누적합 계산
        for (int r=0; r<N; r++) {
            for (int c=1; c<M; c++) {
                impact[r][c] += impact[r][c-1];
            }
        }
        
        // 열 기준 누적합 계산
        for (int c=0; c<M; c++) {
            for (int r=1; r<N; r++) {
                impact[r][c] += impact[r-1][c];
            }
        }
        
        // board 에 적용
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                board[r][c] += impact[r][c];
                if (board[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}