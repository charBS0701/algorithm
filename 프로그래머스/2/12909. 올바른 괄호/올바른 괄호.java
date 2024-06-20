import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;
        // ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if ( c== ')') {
                if (count <= 0) return false;
                else count--;
            }
        }
        
        if (count>0) return false;
        return true;
    }
}