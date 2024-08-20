import java.util.*;
class Solution {
    static int[][] dp;
    int solution(int[][] land) {
        int len = land.length;
        dp = new int[len][4];
        for (int i=0; i<4; i++) 
            dp[0][i] = land[0][i];
        for (int i=1; i<len; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<4; k++) {
                    if (j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+land[i][j]);
                }
            }
        }
        
        return Arrays.stream(dp[len-1]).max().getAsInt();

    }
}