import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int rowLen = board.length;
        int colLen = board[0].length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] topIdx = new int[colLen+1];
        Arrays.fill(topIdx, -1);
        
        // col별 topIdx 구하기
        for(int r=0; r<rowLen; r++) {
            for (int c=0; c<colLen; c++) {
                if (topIdx[c+1] != -1) continue; // 이미구했으면 pass
                if (board[r][c] != 0) topIdx[c+1] = rowLen-r;
            }
        }
        // System.out.println(Arrays.toString(topIdx));
        
        for (int col : moves) {
            int row = topIdx[col];
            
            if(row == 0 || row == -1) continue;  // 빈 곳이면 pass
            
            int now = board[rowLen-row][col-1];
            // System.out.println(row);
            // System.out.println(now);
            if (!stack.isEmpty() && stack.peek() == now) {
                answer += 2;
                stack.pop();
            } else {
                stack.push(now);
            }
            board[rowLen-row][col-1] = 0;
            topIdx[col]--;
            // System.out.println(stack.toString());
        }
        
        return answer;
    }
}