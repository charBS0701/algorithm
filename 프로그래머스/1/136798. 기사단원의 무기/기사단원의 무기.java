import java.util.stream.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int num : IntStream.range(1,number+1).toArray()) {
            //  약수 개수 찾기
            int med = 0;
            boolean over = false;
            for (int i=1; i <= Math.sqrt(num); i++) {
                if (num%i==0) med++;
                
                if (med > limit) {
                    over = true;
                    break;
                }
                
                
            }
            if (num % Math.sqrt(num) == 0) med = med * 2 - 1;
            else med *= 2;
            
            if (med > limit) over = true;
            
            answer += over ? power : med;
            
        }
        
        return answer;
    }
}
