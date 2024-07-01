import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for (int el : ingredient) {
            list.add(el);
            
            while (list.size() >= 4) {
                int s = list.size();
                if (list.get(s-1) == 1 && list.get(s-2) == 3 && list.get(s-3) == 2 && list.get(s-4) == 1) {
                    answer++;
                    for(int i=0; i<4; i++) {
                        list.remove(list.size()-1);
                    }
                } else break;
            }
        }
        
        return answer;
    }
}