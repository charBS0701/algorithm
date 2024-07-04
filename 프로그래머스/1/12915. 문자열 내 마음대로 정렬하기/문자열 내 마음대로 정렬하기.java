import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((o1,o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n)).toArray(String[]::new);
    }
}