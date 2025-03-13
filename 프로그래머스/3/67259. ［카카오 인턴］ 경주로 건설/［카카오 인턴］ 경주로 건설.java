import java.util.*;

class Solution {
    
    static class Node {
        int y, x, d, c;
        public Node(int y, int x, int d, int c) {
            this.y=y;
            this.x=x;
            this.d=d;
            this.c=c;
        }
    }
    
    static int[][][] cost;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int N, answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N][4];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs(board);
        
        return answer;
    }
    
    static void bfs(int[][] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.c-o2.c);
        pq.offer(new Node(0,0,-1,0));
        Arrays.fill(cost[0][0], 0);
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.y == N-1 && now.x == N-1) {
                answer = Math.min(answer,now.c);
                continue;
            }
            
            for (int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] != 0) continue;
                
                int nCost = now.c + (d == now.d || now.d == -1 ? 100 : 600);
                
                if (nCost < cost[ny][nx][d]) {
                    cost[ny][nx][d] = nCost;
                    pq.offer(new Node(ny,nx,d,nCost));
                }
            }
        }
        
    }
}