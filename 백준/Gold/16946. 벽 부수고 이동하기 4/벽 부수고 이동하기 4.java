import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static char[][] mat;
    static int[][] result;
    static int[][] answer;
    static boolean[][] visited;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static Deque<Dot> que = new ArrayDeque<>();
    static int[] parents;
    static int[] rank;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new char[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];
        for (int n=0; n<N; n++) {
            mat[n] = br.readLine().toCharArray();
        }
        
        makeSet();
        
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (mat[y][x] == '1' || visited[y][x]) continue;
                bfs(y,x);
            }
        }
        
        answer = new int[N][M];        
        Set<Integer> addSet = new HashSet<>();
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (mat[y][x] == '0') continue;
                answer[y][x] = 1;
                addSet.clear();
                for (int d=0; d<4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny<0||nx<0||ny>=N||nx>=M||mat[ny][nx]=='1') continue;
                    
                    int idx = ny*M + nx;
                    int parentIdx = find(idx);
                    if (addSet.contains(parentIdx)) continue;
                    int parentY = parentIdx/M;
                    int parentX = parentIdx%M;                    
                    answer[y][x] += result[parentY][parentX];
                    addSet.add(parentIdx);
                }
            }
        }

        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                sb.append(answer[y][x]%10);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    static void bfs(int y, int x) {
        que.clear();
        int count = 0;
        que.add(new Dot(y,x));
        visited[y][x] = true;
        count++;
        
        while (!que.isEmpty()) {
            Dot now = que.poll();
            for (int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if (ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx]||mat[ny][nx]=='1') continue;
                que.add(new Dot(ny,nx));
                int nowIdx = M*now.y + now.x;
                int nextIdx = M*ny + nx;
                union(nowIdx,nextIdx);
                
                visited[ny][nx] = true;
                count++;
            }
        }
        
        result[y][x] = count;
    }
    
    static class Dot {
        int y,x;
        public Dot(int y, int x) {
            this.y=y;
            this.x=x;
        }
    }
    
    static void makeSet() {
        parents = new int[N*M];
        rank = new int[N*M];
        for (int i=0; i<parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    
    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parentsA = find(a);
        int parentsB = find(b);
        if (parentsA == parentsB) return false;
        
        if (rank[parentsA] > rank[parentsB]) parents[parentsB] = parentsA;
        else if (rank[parentsB] > rank[parentsA]) parents[parentsA] = parentsB;
        else {
            parents[parentsB] = parentsA;
            rank[parentsA]++;
        }
        
        return true;
    }
    
}