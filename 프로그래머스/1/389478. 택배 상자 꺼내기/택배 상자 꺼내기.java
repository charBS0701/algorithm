import java.util.*;

class Solution {
    
    static int[][] mat;
    static int W;
    public int solution(int n, int w, int num) {
        int answer = 0;
        W = w;
        
        int N = getH(n);    // 층 수

        mat = new int[N][w];
        
        for (int i=1; i<=n; i++) {
            int h = getH(i);   // 층 수
            if ( h % 2 == 1) {  // 홀수 층
                mat[h-1][(i-1)%w] = i;
            } else {
                mat[h-1][w - (i-1)%w - 1] = i;
            }
        }
        
        
        int M = getH(num)%2 == 1 ? (num-1)%w : w - (num-1)%w - 1;
        for (int i=getH(num); i<=N; i++) {
            if (mat[i-1][M] != 0) answer++;
        }
        
                
        return answer;
        
    }
    
    static int getH(int num) {
        return (num-1)/W + 1;
    }
    
}