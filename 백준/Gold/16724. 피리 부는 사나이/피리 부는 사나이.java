import java.io.*;
import java.util.*;

class Main {
    
    static class Dot implements Comparable<Dot> {
        int y, x;
        boolean isCounted = false;
        
        public Dot(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public int compareTo(Dot o) {
            if (this.y == o.y) return this.x-o.x;
            return this.y - o.y;
        }
        
        @Override
        public boolean equals(Object o) {
            Dot dot = (Dot) o;
            if (this.y == dot.y && this.x == dot.x) return true;
            return false;
        }
    }
    
    static int N, M;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int answer;
    static Dot[][] parents;
    static boolean[][] isCounted;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        makeSet();
        
        for (int n=0; n<N; n++) {
            String line = br.readLine();
            for (int m=0; m<M; m++) {
                char c = line.charAt(m);
                int ny = n;
                int nx = m;
                
                if (c == 'U') {
                    ny += dy[0];
                    nx += dx[0];
                } else if (c == 'D') {
                    ny += dy[1];
                    nx += dx[1];
                } else if (c == 'L') {
                    ny += dy[2];
                    nx += dx[2];
                } else {
                    ny += dy[3];
                    nx += dx[3];
                }
                
                union(new Dot(n,m), new Dot(ny,nx));
                
            }
        }
        
        isCounted = new boolean[N][M];
        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                Dot root = find(parents[n][m]);
                if (!root.isCounted) {
                    answer++;
                    root.isCounted = true;
                }
            }
        }
        
        System.out.println(answer);
        
    }
    
    
    static void makeSet() {
        parents = new Dot[N][M];
        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                parents[n][m] = new Dot(n,m);
            }
        }
    }
    
    static Dot find(Dot dot) {
        if (dot.equals(parents[dot.y][dot.x])) return parents[dot.y][dot.x];
        return parents[dot.y][dot.x] = find(parents[dot.y][dot.x]);
    }
    
    static boolean union(Dot a, Dot b) {
        Dot parentA = find(a);
        Dot parentB = find(b);
        
        if (parentA.equals(parentB)) return false;
        
        if (parentA.compareTo(parentB) < 0) {
            parents[parentB.y][parentB.x] = parentA;
        } else {
            parents[parentA.y][parentA.x] = parentB;
        }
        return true;
    }
}