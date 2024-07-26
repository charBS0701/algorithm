class Solution {
    static int[][] mat;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int y, x;
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        mat = new int[height][width];
        
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (park[i].charAt(j) == 'S') {
                    mat[i][j] = -1;
                    y = i;
                    x = j;
                }
                else if (park[i].charAt(j) == 'O') mat[i][j] = 0;
                else mat[i][j] = 1;
            }
        }
            
        for (int i=0; i<routes.length; i++) {
            char dir = routes[i].charAt(0);
            int d = -1;
            int num = Character.getNumericValue(routes[i].charAt(2));
            
            if (dir == 'N') d = 0;
            else if (dir == 'S') d = 1;
            else if (dir == 'W') d = 2;
            else if (dir == 'E') d = 3;

            int ny = y;
            int nx = x;

            for (int n = 0; n < num; n++) {
                ny += dy[d];
                nx += dx[d];
                if (ny < 0 || nx < 0 || ny >= height || nx >= width || mat[ny][nx] == 1) {
                    ny = y;
                    nx = x;
                    break;
                }
            }
            y = ny;
            x = nx;
            System.out.println(y + ", " + x);
        }
        
        return new int[] {y, x};
    }
}