class Solution {
    public int solution(String s) {
        int result = 0;
        
        int stdIdx = 0;
        int stdCnt = 0;
        int elseCnt = 0;
        for(int i=0; i<s.length(); i++) {
            if (i == stdIdx) {
                stdCnt++;
                continue;
            }
            if (s.charAt(i) == s.charAt(stdIdx)) stdCnt++;
            else elseCnt++;
            
            if (stdCnt == elseCnt) {
                result++;
                stdCnt = 0;
                elseCnt = 0;
                stdIdx = i+1;
            }
        }
        if (stdCnt != 0) result++;
        
        return result;
    }
}