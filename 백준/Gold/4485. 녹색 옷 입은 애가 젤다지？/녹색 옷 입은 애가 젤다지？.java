import java.util.*;

class Node implements Comparable<Node> {
    int x, y, cost;

    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemCount = 1;
        
        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;

            int[][] cave = new int[N][N];
            int[][] dist = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cave[i][j] = sc.nextInt();
                    dist[i][j] = INF;
                }
            }
            
            System.out.println("Problem " + problemCount + ": " + dijkstra(N, cave, dist));
            problemCount++;
        }
    }

    static int dijkstra(int N, int[][] cave, int[][] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, cave[0][0]));
        dist[0][0] = cave[0][0];
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;
            
            if (cost > dist[x][y]) continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = dist[x][y] + cave[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        return dist[N - 1][N - 1];
    }
}
