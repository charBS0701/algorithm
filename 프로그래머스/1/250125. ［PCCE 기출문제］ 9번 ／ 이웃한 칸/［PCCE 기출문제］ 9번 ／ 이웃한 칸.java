class Solution {
    static int[] dh = {-1,1,0,0};
    static int[] dw = {0,0,-1,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int len = board.length;
        
        for (int d=0; d<4; d++) {
            int nh = h + dh[d];
            int nw = w + dw[d];
            if (nh < 0 || nw < 0 || nh>=len || nw >=len) continue;
            if (board[h][w].equals(board[nh][nw])) answer++;
        }
        return answer;
    }
}