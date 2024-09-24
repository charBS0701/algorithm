import java.util.*;
import java.util.stream.*;

class Solution {
    static List<Integer> set = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    
    public int[] solution(String s) {
        String[] arr = s.substring(1,s.length()-2).replaceAll("\\{","").split("\\},");
        for (String a : arr) {
            list.add(a);
        }
        
        Collections.sort(list, Comparator.comparingInt(String::length));
            
        for (String st : list) {
            String[] numbers = st.split(",");
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                
                if (!set.contains(value)) {
                    set.add(value);
                }
            }
        }
        
        return set.stream().mapToInt(i -> i).toArray();
    }
    
    
}