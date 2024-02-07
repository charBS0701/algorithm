package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// visit 필요 X

public class 정사각형방_eg_BFS {

    static int[][] map;
    static int T, N, NO, COUNT; // 방번호, 이동횟수
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 풀이
            NO = 0;
            COUNT = 1;
            
            // 모든 좌표에서 다 시도해보고 그 각각의 결과 중 최선을 선택
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // queue 초기화 queue.clear(); 는 현재 필요 X <= bfs()에서 완전히 empty
                    queue.offer(new Node(i, j, map[i][j], 1));
                    bfs();
                }
            }
            
            sb.append("#").append(t).append(" ").append(NO).append(" ").append(COUNT).append("\n");
        }
        
        System.out.println(sb);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.cnt > COUNT) {
                COUNT = node.cnt;
                NO = node.no;
            }
            else if(node.cnt == COUNT) {
                NO = (node.no < NO) ? node.no : NO;
            }
            
            // 이후 조건에 맍는 더 갈 수 있는 곳 방문
            for(int d=0; d<4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if(ny<0 || nx<0 || ny>=N || nx>=N || map[ny][nx]!=map[node.y][node.x]+1)
                    continue;
                
                queue.offer(new Node(ny, nx, node.no, node.cnt+1));
                break;
            }
        }
    }
    
    static class Node {
        int y, x, no, cnt;
        Node(int y, int x, int no, int cnt) {
            this.y = y;
            this.x = x;
            this.no = no;
            this.cnt = cnt;
        }
    }
}
