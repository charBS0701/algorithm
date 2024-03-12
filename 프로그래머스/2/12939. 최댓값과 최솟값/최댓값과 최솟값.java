import java.util.*;
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public String solution(String s) {
        String answer = "";
        
        String[] tmp = s.split(" ");
        for(String a : tmp) {
            list.add(Integer.parseInt(a));
        }
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
        answer = sb.toString();
        return answer;
    }
}