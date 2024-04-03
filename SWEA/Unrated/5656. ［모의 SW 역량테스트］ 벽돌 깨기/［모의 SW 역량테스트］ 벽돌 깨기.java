import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
    static int T, N, W, H, count, total, max;
    static int[][] map, copymap;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 구슬 횟수 <= 4
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
 
            total = 0;
            max = 0;
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] != 0) {
                        total++;
                    }
                }
            }
 
            tgt = new int[N];
            comb(0);
            sb.append("#").append(t).append(" ").append(total - max).append("\n");
        }
        System.out.println(sb);
    }
 
    static int[] tgt;
 
    static void comb(int tgtIdx) {
        if (tgtIdx == N) {
            check();
            return;
        }
 
        for (int i = 0; i < W; i++) {
            tgt[tgtIdx] = i;
            comb(tgtIdx + 1);
        }
    }
 
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
 
    // 현재 구슬 순서에 따라 시뮬레이션
    static void check() {
        count = 0;
        copymap = copymap();
        for (int i = 0; i < N; i++) {
            int x = tgt[i];
 
            for (int j = 0; j < H; j++) {
                if (copymap[j][x] != 0) {
                    bomb(j, x);
                    break;
                }
            }
 
            // 중력 처리
            for (int k = 0; k < W; k++) {
                Stack<Integer> stack = new Stack<>();
                for (int j = 0; j < H; j++) {
                    if (copymap[j][k] != 0) {
                        stack.push(copymap[j][k]);
                        copymap[j][k] = 0;
                    }
                }
 
                int y = H - 1;
                while (!stack.isEmpty()) {
                    copymap[y--][k] = stack.pop();
                }
            }
        }
    }
 
    static void bomb(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] select = new boolean[H][W];
 
        select[y][x] = true;
        queue.offer(new int[] { y, x });
 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int range = copymap[cur[0]][cur[1]];
 
            if (copymap[cur[0]][cur[1]] != 0)
                count++;
            copymap[cur[0]][cur[1]] = 0; // 터뜨리기
 
            for (int i = 0; i < 4; i++) {
                int ny = cur[0];
                int nx = cur[1];
 
                for (int j = 0; j < range - 1; j++) {
                    ny += dy[i];
                    nx += dx[i];
 
                    if (ny < 0 || nx < 0 || ny >= H || nx >= W || copymap[ny][nx] == 0)
                        continue;
                    select[ny][nx] = true;
                    queue.offer(new int[] { ny, nx });
                }
            }
        }
        max = Math.max(max, count);
    }
 
    static int[][] copymap() {
        int[][] temp = new int[H][];
        for (int i = 0; i < H; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
}