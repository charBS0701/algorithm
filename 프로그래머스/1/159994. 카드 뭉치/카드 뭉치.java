class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx1=-1;
        int idx2=-1;
        for (String el : goal) {
            boolean isContains = false;
            
            // cards1 에 있는지
            for (int i=idx1+1; i<cards1.length; i++) {
                if (el.equals(cards1[i])) {
                    isContains = true;
                    // 카드를 사용하지않고 다음카드로 넘어가면
                    if (i != idx1+1) {
                        return "No";
                    } else idx1=i;
                    
                    break;
                }
            }
            
            // cards2 에 있는지
            if(!isContains) {
                for (int i=idx2+1; i<cards2.length; i++) {
                    if (el.equals(cards2[i])) {
                        isContains = true;
                        // 뒤에있는게 먼저 나왔으면
                        if (i != idx2+1) {
                            return "No";
                        } else idx2=i;
                        
                        break;
                    }
                }
            }
            
            if (!isContains) return "No";
            
        }
        
        return "Yes";
    }
}