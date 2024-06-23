import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int count=0;
        ArrayList<Integer> scores = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {     // 숫자인경우
                sb.append(c);
            } else if (Character.isLetter(c)) { // 제곱처리
                int tmp = Integer.parseInt(sb.toString());
                sb.setLength(0);
                switch(c) {
                    case 'D':
                        tmp=tmp*tmp;
                        break;
                    case 'T':
                        tmp=tmp*tmp*tmp;
                        break;
                }
                scores.add(tmp);
                count++;
            } else {        // 옵션처리
                switch(c) {
                    case '*':
                        scores.set(count-1, scores.get(count-1)*2);
                        if (count>=2) scores.set(count-2, scores.get(count-2)*2);
                        break;
                    case '#':
                        scores.set(count-1, scores.get(count-1)*-1);
                        break;
                }
            }
        }
        for (Integer score : scores) {
            answer += score;
        }        
        
        return answer;
    }
    
}

