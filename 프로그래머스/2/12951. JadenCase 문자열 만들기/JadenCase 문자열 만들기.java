import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (first) {
                if (c != ' ') {   
                    if (c >= 'a' && c <= 'z') {
                        c = (char)(c-('a'-'A'));
                    }
                    first = false;
                }                    
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c+('a'-'A'));
                } else if (c == ' ') {
                    first = true;
                }
            }

            sb.append(c);          
                    
        }
        
        return sb.toString();
        
    }
}