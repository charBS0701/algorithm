import java.util.*;

class Solution {
    
    static StringBuilder sb = new StringBuilder();
    static List<String> list = new ArrayList<>();
    
    public String solution(int[] numbers) {
        
        for (int n : numbers) {
            list.add(String.valueOf(n));          
        }
        
        Collections.sort(list, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}