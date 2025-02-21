import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int R, C;        // <= 1000
    static char[][] mat;
    static int jr, jc;
    static List<int[]> fList = new ArrayList<>();
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int answer;
    static Deque<int[]> que = new ArrayDeque<>();
    static Deque<int[]> fq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            answer = 0;
            fList.clear();
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            mat = new char[R][C];
            for (int r=0; r<R; r++) {
                mat[r] = br.readLine().toCharArray();
                for (int c=0; c<C; c++) {
                    if (mat[r][c] == '@') {
                        jr = r;
                        jc = c;
                    } else if (mat[r][c] == '*') {
                        fList.add(new int[]{r,c});
                    }
                }
            }
            
            bfs();
            sb.append(answer == 0 ? "IMPOSSIBLE" : answer).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    static void bfs() {
        que.clear();
        fq.clear();

        que.add(new int[]{jr,jc,0});
        for (int[] f : fList) {
            fq.add(new int[]{f[0],f[1],0});
        }
        
        int time = 0;
        while (!que.isEmpty()) {
            while (!que.isEmpty() && que.peek()[2] == time) {
                int[] nj = que.poll();
                if (mat[nj[0]][nj[1]] != '@') continue;
                if (exodus(nj[0],nj[1])) {
                    answer = time + 1;
                    return;
                }
                
                for (int d=0; d<4; d++) {
                    int njr = nj[0] + dy[d];
                    int njc = nj[1] + dx[d];
                    if (mat[njr][njc] != '.') continue;
                    mat[njr][njc] = '@';
                    que.offer(new int[]{njr,njc,time+1});
                }
            }
            
            while (!fq.isEmpty() && fq.peek()[2] == time) {
                int[] nf = fq.poll();
                for (int d=0; d<4; d++) {       // burn it 
                    int nfr = nf[0] + dy[d];
                    int nfc = nf[1] + dx[d];
                    if (nfr < 0 || nfc < 0 || nfr == R || nfc == C || mat[nfr][nfc] == '*' || mat[nfr][nfc] == '#')
                        continue;
                    mat[nfr][nfc] = '*';
                    fq.offer(new int[]{nfr,nfc,time+1});
                }
            }
            
            time++;
            
        }
    }
    
    static boolean exodus(int r, int c) {
        if (r==0 || r==R-1 || c==0 || c==C-1) {
            return true;
        }
        return false;
    }
}