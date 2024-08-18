import java.util.*;
class Solution {
    static List<Integer> list = new ArrayList<>();
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int height, width;
    
    public int[] solution(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        map = new int[height][width];
        visit = new boolean[height][width];
        
        for(int i=0; i<height; i++) {
            String row = maps[i];
            for (int j=0; j<width; j++) {
                char c = row.charAt(j);
                if (c=='X') map[i][j] = 0;
                else map[i][j] = Character.getNumericValue(c);
            }
        }
        
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (visit[i][j] || map[i][j] == 0) continue;
                bfs(i,j);
            }
        }
        
        if (list.isEmpty()) return new int[] {-1};
        return list.stream().sorted().mapToInt(a->a).toArray();
        
    }
    
    static void bfs(int i, int j) {
        int sum = 0;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{i,j});
        visit[i][j] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            sum += map[now[0]][now[1]];
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if (ny >= height || nx >= width || ny<0 || nx<0 || visit[ny][nx] || map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                que.add(new int[]{ny,nx});
            }
        }
        
        list.add(sum);
        
    }
}