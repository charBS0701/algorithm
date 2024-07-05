import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] result = new int[200];
        Arrays.fill(result,0);
        
        int[] score = new int[]{0,3,2,1,0,1,2,3}; // 매우비동의 ~ 매우동의시 얻는 점수
        
        for (int i=0; i<survey.length; i++) {
            int c1 = survey[i].charAt(0);  // 비동의 시 점수 얻는 유형
            int c2 = survey[i].charAt(1);  // 동의 시
            
            if (choices[i] <= 3) {
                result[c1]+=score[choices[i]];
            } else if (choices[i] >= 5) {
                result[c2]+=score[choices[i]];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(result[(int)'R']>=result[(int)'T'] ? 'R' : 'T');
        sb.append(result[(int)'C']>=result[(int)'F'] ? 'C' : 'F');
        sb.append(result[(int)'J']>=result[(int)'M'] ? 'J' : 'M');
        sb.append(result[(int)'A']>=result[(int)'N'] ? 'A' : 'N');
        
        return sb.toString();
    }
}