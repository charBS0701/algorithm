import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> set = new HashSet<>();
        Deque<Character> que = new ArrayDeque<>();   
        
        for (char c : skill.toCharArray()) {
            set.add(c);
            que.offer(c);
        }
        
        for (String s : skill_trees) {            
            boolean flag = true;
            Set<Character> copySet = new HashSet<>(set);
            Deque<Character> copyQue = new ArrayDeque<>(que);                          
            
            for (char c : s.toCharArray()) {
                if (!copySet.contains(c)) continue;
                if (copyQue.poll() != c) {
                    flag = false;
                    break;  // 실패
                }
            }
            
            if (flag) answer++;
            
        }
        
        return answer;
    }
}
