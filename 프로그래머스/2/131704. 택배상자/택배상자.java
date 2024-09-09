import java.util.*;
class Solution {
    static int answer;
    static Deque<Integer> stack = new ArrayDeque<>();
    public int solution(int[] order) {
        int idx = 1;        
        for (int num : order) {
            boolean flag = false;
            if (num == idx) {
                answer++;
                idx++;
                continue;
            }
            while (num > idx) {     // 나온적 없는 숫자
                stack.push(idx++);
                if (num == idx) {
                    answer++;
                    idx++;
                    flag = true;
                }
            }
            if (flag) {
                continue;
            }
            
            if (stack.peek() == num) {  // 보조 컨테이너에 있음
                stack.pop();
                answer++;
                continue;
            }
            
            break;      // 더이상 못 실음
        }
        
        return answer;
    }
}