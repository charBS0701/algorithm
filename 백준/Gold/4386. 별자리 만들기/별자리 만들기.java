import java.io.*;
import java.util.*;

public class Main {
    
    static class Star {
        float x, y;
        public Star(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge {
        int v;
        float c;
        public Edge(int v, float c) {
            this.v = v;
            this.c = c;
        }
    }
    
    static int N;
    static List<Star> list = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> Float.compare(o1.c,o2.c));
    static float[][] mat;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());        // 별자리 수
        mat = new float[N][N];
        isVisited = new boolean[N];
        StringTokenizer st = null;
        for (int n=0; n<N; n++) {                      // 별 목록 저장
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());
            Star star = new Star(x,y);
            list.add(star);
        }
        
        for (int n1=0; n1<N-1; n1++) {              // 모든 별 간의 거리 저장
            for (int n2=n1+1; n2<N; n2++) {
                Star s1 = list.get(n1);
                Star s2 = list.get(n2);
                float dis = getDis(s1,s2);
                mat[n1][n2] = dis;
                mat[n2][n1] = dis;
            }
        }
        
        // prim
        float totalDis = (float) 0.0;
        int count = 1;
        isVisited[0] = true;
        for (int n=1; n<N; n++) {
            pq.add(new Edge(n, mat[0][n]));
        }
            
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (isVisited[now.v]) continue;
            
            isVisited[now.v] = true;
            count++;
            totalDis += now.c;
            
            if (count == N) break;
            
            for (int n=0; n<N; n++) {
                if (isVisited[n]) continue;
                pq.add(new Edge(n,mat[now.v][n]));
            }
        }
        
        System.out.println(Math.round(totalDis*100)/100.0);

    }
    
    static float getDis(Star a, Star b) {
        return (float) Math.sqrt((double)(a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
    }
    
}