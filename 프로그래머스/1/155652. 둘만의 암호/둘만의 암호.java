class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] isSkip = new boolean[26];
        for (int i=0; i<skip.length(); i++) {
            isSkip[skip.charAt(i)-'a'] = true;
        }
        
        for (int n=0; n<s.length(); n++) {
            char c = s.charAt(n);
            for (int i=0; i<index; ) {
                if (c == 'z') {
                    c = 'a';
                } else c++;
                
                if (isSkip[c-'a']) {
                    continue;
                } else {
                    i++;
                }
            }
            sb.append(c);
        }        
            
        return sb.toString();
    }
}