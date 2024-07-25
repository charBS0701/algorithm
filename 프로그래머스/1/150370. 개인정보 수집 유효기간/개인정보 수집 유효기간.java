import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        LocalDate todayDate = LocalDate.of(Integer.parseInt(today.substring(0,4)), Integer.parseInt(today.substring(5,7)), Integer.parseInt(today.substring(8)));
        
        PriorityQueue<Integer> result = new PriorityQueue<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            char c = tmp[0].charAt(0);
            int n = Integer.parseInt(tmp[1]);
            map.put(c,n);
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String dateStr = tmp[0];
            char type = tmp[1].charAt(0);
            LocalDate date = LocalDate.of(Integer.parseInt(dateStr.substring(0,4)), Integer.parseInt(dateStr.substring(5,7)), Integer.parseInt(dateStr.substring(8)));
            date = date.plusMonths(map.get(type)).minusDays(1);
            if (todayDate.compareTo(date) > 0) {
                result.offer(i+1);
            System.out.println(date);
            }
        }
        int size=  result.size();
        int[] answer = new int[result.size()];
        for(int i=0; i< size; i++) {
            answer[i] = result.poll();
        }
    
        return answer;
    }
}