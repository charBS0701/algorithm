class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left + 1);
        int[] answer = new int[len];
        
        for (int i=0; i<len; i++) {
            long idx = left+i;
            int row = (int)(idx / n);
            int col = (int)(idx % n);
            answer[i] = Math.max(row,col)+1;
        }
        
        return answer;
    }
}