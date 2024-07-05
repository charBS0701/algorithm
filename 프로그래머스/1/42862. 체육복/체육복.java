import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        for(int el : lost) {
            lostList.add(el);
        }
        for (int el : reserve) {
            if (lostList.contains(el)) {
                lostList.remove(new Integer(el));
            } else reserveList.add(el);
        }
        
        while (!lostList.isEmpty()) {
            int now = lostList.get(0);
            if (reserveList.contains(now-1)) {
                reserveList.remove(new Integer(now-1));
            } else if (reserveList.contains(now+1)) {                
                reserveList.remove(new Integer(now+1));
            } else {
                answer--;
            }
            lostList.remove(0);
        }
        
        
        return answer;
    }
}