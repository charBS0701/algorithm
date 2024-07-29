class Solution {
    static int time, count;
    
    public int[] solution(String s) {
        
        while (!s.equals("1")) {
            int cnt1 = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') cnt1++;
                else count++;
            }
            
            StringBuilder sb = new StringBuilder();
            while (cnt1 != 0) {
                if (cnt1 % 2 == 0) sb.append("0");
                else sb.append("1");
                cnt1 /= 2;
            }
            
            s = sb.reverse().toString();
            
            time++;
        }
        
        return new int[] {time, count};
    }
}