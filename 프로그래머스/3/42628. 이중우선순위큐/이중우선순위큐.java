import java.util.*;
class Solution {
    static PriorityQueue<Integer> minH = new PriorityQueue<>();
    static PriorityQueue<Integer> maxH = new PriorityQueue<>((o1,o2) -> o2-o1);
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        for (String oper : operations) {
            String op = oper.split(" ")[0];
            Integer operand = Integer.valueOf(oper.split(" ")[1]);
            
            if (op.equals("I")) {
                minH.add(operand);
                maxH.add(operand);
            } else if (op.equals("D")) {
                if (minH.isEmpty()) continue;
                if (operand == 1) {
                    minH.remove(maxH.poll());
                } else if (operand == -1) {
                    maxH.remove(minH.poll());
                }
            }
        }
        
        if (minH.isEmpty()) answer = new int[]{0,0};
        else answer = new int[]{maxH.poll(),minH.poll()};
        
        return answer;
    }
}