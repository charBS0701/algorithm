import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        Set<String> set = new HashSet<>();
        
        String prev = null;
        for(int i=0; i<words.length; i++) {
            String now = words[i];
            // 이미 나온 단어인지 확인
            if (set.contains(now)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            } else if (i!=0 && prev.charAt(prev.length()-1) != now.charAt(0) ) {
                 // 앞 단어와 끝과 이번 단어의 첫이 같은지 확인
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;                
            } else {        // 통과
                prev = new String(now);
                set.add(now);
            }
       
        }

        return answer;
    }
}