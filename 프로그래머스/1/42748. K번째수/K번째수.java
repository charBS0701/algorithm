import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int[] tmp = new int[commands[i][1]-commands[i][0]+1];
            for (int j=0; j<commands[i][1]-commands[i][0]+1; j++) {
                tmp[j] = array[commands[i][0]+j-1];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        
        return answer;
    }
}