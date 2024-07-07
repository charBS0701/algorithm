class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        char nowL = '*';      // 현재 손 위치
        char nowR = '#';
        for (int i=0; i<numbers.length; i++) {
            char c = String.valueOf(numbers[i]).charAt(0);
            if(c == '1' || c == '4' || c == '7') {
                sb.append("L");
                nowL = c;
            } else if (c == '3' || c == '6' || c == '9') {
                sb.append("R");
                nowR = c;
            } else {
                int distL = getDist(c,nowL);
                int distR = getDist(c,nowR);
                if (distL < distR || (distL == distR && hand.equals("left")) ) {   // 왼손
                    sb.append("L");
                    nowL = c;
                } else if (distL > distR || (distL == distR && hand.equals("right"))) {    // 오른손
                    sb.append("R");
                    nowR = c;
                }
            }
        }
        
        return sb.toString();
    }
    
    static int getDist(char c, char now) {
        if (c == '2') {
            if (now == '1' || now == '3' || now == '5') return 1;
            else if (now == '4' || now == '6' || now == '8') return 2;
            else if (now == '7' || now == '9' || now == '0') return 3;
            else if (now == '*' || now == '#') return 4;
            else return 0;
        } else if (c=='5') {
            if (now == '1' || now == '3') return 2;
            else if (now == '4' || now == '6' || now == '2' || now == '8') return 1;
            else if (now == '7' || now == '9' || now == '0') return 2;
            else if (now == '*' || now == '#') return 3;            
            else return 0;
        } else if (c=='8') {
            if (now == '1' || now == '3') return 3;
            else if (now == '4' || now == '6' || now == '2') return 2;
            else if (now == '7' || now == '9' || now == '5' || now == '0') return 1;
            else if (now == '*' || now == '#') return 2;          
            else return 0;
        } else if (c=='0') {
            if (now == '1' || now == '3') return 4;
            else if (now == '4' || now == '6' || now == '2') return 3;
            else if (now == '7' || now == '9' || now == '5') return 2;
            else if (now == '*' || now == '#' || now == '8') return 1;                 
            else return 0;
        }
        System.out.println("예외");
        System.out.println(c);
        System.out.println(now);
        return -1;
    }
}