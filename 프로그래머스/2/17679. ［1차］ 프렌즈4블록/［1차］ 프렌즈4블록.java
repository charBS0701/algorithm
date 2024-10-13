import java.util.*;

public class Solution {
    
    public int solution(int m, int n, String[] board) {
        char[][] mat = new char[m][n];
        
        // 입력된 문자열 배열을 2D char 배열로 변환
        for (int i = 0; i < m; i++) {
            mat[i] = board[i].toCharArray();
        }
        
        int totalRemoved = 0;
        
        while (true) {
            // 1. 2x2 블록 찾기
            boolean[][] toRemove = new boolean[m][n];
            boolean found = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (mat[i][j] != ' ' && mat[i][j] == mat[i][j + 1] && mat[i][j] == mat[i + 1][j] && mat[i][j] == mat[i + 1][j + 1]) {
                        toRemove[i][j] = true;
                        toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = true;
                        toRemove[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }
            
            // 더 이상 지울 블록이 없으면 종료
            if (!found) break;
            
            // 2. 블록 지우기
            int removed = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        mat[i][j] = ' ';
                        removed++;
                    }
                }
            }
            totalRemoved += removed;
            
            // 3. 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (mat[i][j] == ' ') {
                        // 위쪽에서 블록을 찾아 내려보내기
                        for (int k = i - 1; k >= 0; k--) {
                            if (mat[k][j] != ' ') {
                                mat[i][j] = mat[k][j];
                                mat[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return totalRemoved;
    }

}
