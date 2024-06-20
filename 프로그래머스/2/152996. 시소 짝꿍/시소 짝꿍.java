import java.util.*;

class Solution {
    static long[] count = new long[1001];
    static long cum(long cnt) {
        long sum=0;
        for(int i=1; i<=cnt; i++) sum+=i;
        return sum;
    }
    
    public long solution(int[] weights) {        
        for (int i=0; i<weights.length; i++) {
            count[weights[i]]++;
        }
        int[] seats = {2,3,4};
        
        long answer = 0;
        for (int i = 100; i<= 1000; i++) {
            if (count[i] == 0) continue;
            if (count[i]>1) {   // 같은 무게끼리 짝꿍인 경우
                answer += cum(count[i]-1);
            }
            for (int j = i+1; j<=1000; j++) {
                if (count[j] == 0) continue;
                boolean checked = false;
                for (int a=0; a<3; a++) {
                    if (checked) break;
                    for (int b=0; b<3; b++) {
                        if (i*seats[a] == j*seats[b]) {
                            answer += count[i]*count[j];
                            checked = true;
                            break;
                        }
                    }
                }
            }
        }
           
        return answer;
    }
}