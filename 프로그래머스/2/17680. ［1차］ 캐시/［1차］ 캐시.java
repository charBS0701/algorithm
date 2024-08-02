import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            city = city.toUpperCase();

            if (list.contains(city)) {  // hit
                answer++;
                list.remove(city);
                list.add(city);
            } else {                    // miss
                if (list.size() >= cacheSize) list.remove(0);
                list.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}