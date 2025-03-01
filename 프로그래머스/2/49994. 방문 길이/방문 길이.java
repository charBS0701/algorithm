import java.util.*;

class Solution {
    
    static class Dot {
        int y, x;
        public Dot(int y, int x) {
            this.y=y;
            this.x=x;
        }
        @Override
        public boolean equals(Object o) {
            Dot d = (Dot) o;
            return this.y==d.y && this.x==d.x;
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.y, this.x);
        }
    }
    
    static class Edge {
        Dot a, b;
        public Edge(Dot a, Dot b) {
            this.a=a;
            this.b=b;
        }
        @Override
        public boolean equals(Object o) {
            Edge e = (Edge) o;
            return (this.a.equals(e.a) && this.b.equals(e.b)) || (this.a.equals(e.b) && this.b.equals(e.a));
        }
        @Override
        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }
    }
    
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static Set<Edge> visited = new HashSet<>();
    
    public int solution(String dirs) {
        
        Dot now = new Dot(0,0);
        for (char c : dirs.toCharArray()) {
            int dir = "UDLR".indexOf(c);
            Dot next = new Dot(now.y + dy[dir],now.x + dx[dir]);
            
            if (next.y < -5 || next.x < -5 || next.y > 5 || next.x > 5) continue;
            
            Edge edge = new Edge(new Dot(now.y,now.x), new Dot(next.y,next.x));
            if (!visited.contains(edge))    visited.add(edge);
            
            now = next;
        }
        
        return visited.size();
    }
}