import java.util.*;

class Solution {
    public int solution(int n) {
        char[] biN = Integer.toBinaryString(n).toCharArray();
        int count1 = 0;
        for (char c : biN) {
            if (c == '1') count1++;
        }
        
        int next = n+1;
        while (true) {
            char[] s = Integer.toBinaryString(next).toCharArray();
            int count = 0;
            for (char c : s) {
                if (c == '1') count++;
                if (count > count1) break;
            }
            if (count == count1) return next;
            next++;
        }
    }
}