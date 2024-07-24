class Solution {
    public int[] solution(String[] wallpaper) {
        int left = 50;
        int up = 50;
        int right = 0;
        int down = 0;
        int xlen = wallpaper.length;
        int ylen = wallpaper[0].length();
        for (int i=0; i<xlen; i++) {
            for (int j=0; j<ylen; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    left = Math.min(left, j);
                    up = Math.min(up, i);
                    right = Math.max(right, j+1);
                    down = Math.max(down, i+1);
                }
            }
        }
        
        return new int[] {up, left, down, right};
    }
}