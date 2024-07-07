class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            String tmp = "null";
            int len = str.length();
            for (int i=0; i<len;) {
                char c = str.charAt(i);
                if (c == 'a' && !tmp.equals("aya") && i+2<len && str.charAt(i+1) == 'y' && str.charAt(i+2) == 'a') {
                    i += 3;
                    tmp = "aya";
                } else if (c == 'y' && !tmp.equals("ye") && i+1<len && str.charAt(i+1) == 'e') {
                    i += 2;
                    tmp = "ye";
                } else if (c == 'w' && !tmp.equals("woo") && i+2<len && str.charAt(i+1) == 'o' && str.charAt(i+2) == 'o') {
                    i += 3;
                    tmp = "woo";
                } else if (c == 'm' && !tmp.equals("ma") && i+1<len && str.charAt(i+1) == 'a') {
                    i += 2;
                    tmp = "ma";
                } else {
                    break;
                }
                
                if (i == len) answer++;
            }
        }
        
        
        return answer;
    }
}