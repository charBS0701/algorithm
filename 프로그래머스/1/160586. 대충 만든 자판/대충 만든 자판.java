import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character,Integer> map = new HashMap<>();
        for (String str : keymap) {
            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c,i+1);
                } else {
                    if (map.get(c) > i+1) map.put(c,i+1);
                }
            }
        }
        
        for (int i=0; i<targets.length; i++) {
            int sum = 0;
            boolean flag = true;
            String target = targets[i];
            for (int j=0; j<target.length(); j++) {
                char c = target.charAt(j);
                if (!map.containsKey(c)) {
                    answer[i] = -1;
                    flag = false;
                    break;
                } else {
                    sum += map.get(c);
                }
            }
            if (flag) answer[i] = sum;
        }
        
        return answer;
    }
}