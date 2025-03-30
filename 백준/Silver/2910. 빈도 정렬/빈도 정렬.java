import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int key, value = 1;
        public Node(int key) {
            this.key = key;
        }
        @Override
        public boolean equals(Object o) {
            Node n = (Node) o;
            return key == n.key;
        }
        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
        @Override
        public int compareTo(Node n) {
            return n.value - value;
        }
    }
    
    static int N, C;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            int key = Integer.parseInt(st.nextToken());
            Node now = new Node(key);
            if (list.contains(now)) {
                list.get(list.indexOf(now)).value++;
            } else {
                list.add(now);
            }
        }
        
        Collections.sort(list);
        
        for (Node node : list) {
            for (int i=0; i<node.value; i++) {
                sb.append(node.key).append(" ");
            }
        }
        
        System.out.println(sb);
        
    }
}