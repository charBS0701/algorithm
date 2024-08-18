import java.util.*;
class Solution {
    static String[] src = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();        
    public int solution(String word) {
        
        for (String s : src) {
            solve("", s);    
        }
        
        Collections.sort(list);
        
        return list.indexOf(word)+1;
    }
    
    static void solve(String now, String plus) {
        String next = now+plus;
        if (next.length() > 5) return;
        if (list.contains(next)) return;
        list.add(next);
        for (String s : src) {
            solve(next, s);
        }
    }
}