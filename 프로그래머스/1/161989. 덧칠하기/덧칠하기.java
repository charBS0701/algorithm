import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for (int el : section) {
            list.add(el);
        }
        
        while(!list.isEmpty()) {
            int from = list.remove(0);
            while(!list.isEmpty()) {
                if (list.get(0) < from + m) {
                    list.remove(0);
                } else break;
            }
            answer++;
        }
        
        return answer;
    }
}