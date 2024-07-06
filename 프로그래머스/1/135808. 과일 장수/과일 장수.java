import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int boxNum = score.length/m;
        Arrays.sort(score);
        for (int i=0; i < score.length%m; i++) {
            score[i] = 10; // 사과를 빼버림
        }
        Arrays.sort(score);
        
        for (int box=0; box < m * boxNum; box+=m) {
            answer += score[box] * m;
        }

        return answer;
    }
}