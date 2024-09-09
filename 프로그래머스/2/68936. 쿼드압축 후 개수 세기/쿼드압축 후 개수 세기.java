class Solution {
    static int[] answer = new int[]{0,0};
    public int[] solution(int[][] arr) {
        rec(arr, 0, 0, arr.length);
        return answer;
    }
    
    static void rec(int[][] arr, int r, int c, int l) {
        boolean is0 = true;
        boolean is1 = true;
        for (int i=r; i<r+l; i++) {
            for (int j=c; j<c+l; j++) {
                if (arr[i][j] == 0) is1 = false;
                else if (arr[i][j] == 1) is0 = false;
            }
        }
        if (is0) {
            answer[0]++;
        } else if (is1) {
            answer[1]++;
        } else {
            rec(arr, r, c, l/2);
            rec(arr, r+l/2, c, l/2);
            rec(arr, r, c+l/2, l/2);
            rec(arr, r+l/2, c+l/2, l/2);
        }
    }
}