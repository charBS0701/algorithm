import java.io.*;
import java.util.*;

class Main {
    
    static class Vertex {
        int r,c;
        int w;
        
        public Vertex(int r, int c, int w) {
            this.r=r;
            this.c=c;
            this.w=w;
        }
    }
    
    static int N;
    static List<Vertex>[][] mat;
    static int[][] originMat;
    static int[][] cost;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static final int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            originMat = new int[N][N];
            mat = new ArrayList[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    mat[i][j] = new ArrayList<Vertex>();
                }
            }
             
            cost = new int[N][N];   
            for (int i=0; i<N; i++) {
                Arrays.fill(cost[i], INF);
            }
            
            StringTokenizer st = null;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    int weight = Integer.parseInt(st.nextToken());
                    originMat[i][j] = weight;
                    for (int d=0; d<4; d++) {
                        int ny = i+dy[d];
                        int nx = j+dx[d];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                        mat[ny][nx].add(new Vertex(i,j,weight));
                    }
                }
            }
            
            dijkstra();
            
            sb.append("Problem ").append(t++).append(": ").append(cost[N-1][N-1]).append("\n");
            
        }
        
        System.out.println(sb);
    }
    
    static void dijkstra() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2) -> o1.w-o2.w);
        pq.add(new Vertex(0,0,originMat[0][0]));
        cost[0][0] = originMat[0][0];
        
        while (!pq.isEmpty()) {
            Vertex now = pq.poll();
            if (now.w > cost[now.r][now.c]) continue;
            
            for (Vertex nv : mat[now.r][now.c]) {
                if (cost[nv.r][nv.c] > cost[now.r][now.c] + nv.w) {
                    cost[nv.r][nv.c] = cost[now.r][now.c] + nv.w;
                    pq.add(new Vertex(nv.r,nv.c,nv.w));
                }
            }
        }
        
        
    }
}