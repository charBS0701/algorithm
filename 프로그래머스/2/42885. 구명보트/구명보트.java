import java.util.*;
class Solution {
    static List<Integer> list = new ArrayList<>();
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for (int person : people) list.add(person);
        
        while (!list.isEmpty()) {
            int weight = list.remove(list.size()-1);
            if (list.isEmpty() || limit < weight + list.get(0)) {   // 한 명일 때나 혼자만 탈 수 있을 때
            } else list.remove(0);

            answer++;            
        }
        
        return answer;
    }
}