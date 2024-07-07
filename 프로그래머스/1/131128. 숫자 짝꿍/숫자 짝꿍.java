class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        for (int i=0; i<X.length(); i++) {
            char c = X.charAt(i);
            arrX[Character.getNumericValue(c)]++;
        }
        for (int i=0; i<Y.length(); i++) {
            char c = Y.charAt(i);
            arrY[Character.getNumericValue(c)]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            for(int j=0; j<Math.min(arrX[i],arrY[i]); j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) return "-1";
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) != '0') return sb.toString();
        }
        return "0";
    }
}