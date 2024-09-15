import java.util.*;
class Solution {
    static int answer;
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> tmpMap;
    
    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int day = 0; day <= discount.length - 10; day++) {
            tmpMap = new HashMap(map);
            for (int idx = day; idx < day + 10; idx++) {
                String item = discount[idx];
                if (!tmpMap.containsKey(item)) break;
                
                tmpMap.put(item, tmpMap.get(item) - 1);
                if (tmpMap.get(item) == 0) tmpMap.remove(item);
                
                if (idx == day+9) answer++;
            }
        }
        
        
        return answer;
    }
}