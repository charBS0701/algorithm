import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int n = elements.length;
        
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                int idx = i+j >= n ? i+j-n : i+j;
                sum += elements[idx];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}