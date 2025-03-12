import java.util.*;

class Solution {
    
    static int N,M;
    
    static Map<String,Integer> log = new HashMap<>();
    
    static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        
        for (int[] route : routes) {
            int time = 0;
            for (int i=1; i<route.length; i++) {
                int[] point1 = points[route[i-1]-1];
                int[] point2 = points[route[i]-1];
                time = go(point1, point2, time);
            }
        }
        
        return answer;
    }
    
    
    static int go(int[] from, int[] to, int time) {
        int fr = from[0], fc = from[1], tr = to[0], tc = to[1];
        if (time == 0) check(fr+","+fc+","+time);

        while (fr < tr) {
            fr++;
            time++;
            check(fr+","+fc+","+time);
        }
        while (fr > tr) {
            fr--;
            time++;
            check(fr+","+fc+","+time);            
        }
        while (fc < tc) {
            fc++;
            time++;
            check(fr+","+fc+","+time);
        }
        while (fc > tc) {
            fc--;
            time++;
            check(fr+","+fc+","+time);
        }
        
        return time;
    }
    
    static void check(String key) {
        if (log.containsKey(key)) {
            if (log.get(key) == 1) {
                answer++;
                log.put(key,2);
            }
        } else {
            log.put(key,1);
        }        
    }
        
            
}