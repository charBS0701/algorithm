import java.util.*;

// land : 500x500 = 250_000

class Solution {
    
    static boolean[][] visited;
    static int N, M;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int[] parents, rank;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;        
        visited = new boolean[N][M];
        
        makeSet();
        
        for (int m=0; m<M; m++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int n=0; n<N; n++) {
                if (land[n][m] != 1) continue;
                
                int idx = n*M+m;
                if (set.contains(find(idx))) continue;
                else if (visited[n][m] && !set.contains(find(idx))) {
                    sum += rank[find(idx)];
                    set.add(find(idx));
                } else { 
                    sum += bfs(land,n,m);
                    set.add(find(idx));
                }
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    static int bfs(int[][] land, int n, int m) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{n,m});
        visited[n][m] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int d=0; d<4; d++) {
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if (ny<0||nx<0||ny>=N||nx>=M || land[ny][nx] != 1 || visited[ny][nx])
                    continue;
                union(n*M + m, ny*M + nx);
                que.offer(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }
        return rank[find(n*M+m)];
    }
    
    static void makeSet() {
        parents = new int[N*M];
        rank = new int[N*M];
        for (int i=0; i<N*M; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    
    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parenta = find(a);
        int parentb = find(b);
        if (parenta == parentb) return false;
        parents[parentb] = parenta;
        rank[parenta] += rank[parentb];
        return true;
    }
}