class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for (int r = 3; r < sum; r++) {
            if (sum%r != 0) continue;
            int c = sum / r;
            if(r*2 + (c-2)*2 == brown) 
                return new int[] {c,r};
        }
        return new int[] {0,0};
    }
}