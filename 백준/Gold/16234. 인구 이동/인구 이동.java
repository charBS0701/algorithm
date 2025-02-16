import java.io.*;
import java.util.*;

public class Main {
    
    static int N, L, R;
    static int[][] mat;
    static int[] root;
    static int[] rootSum;
    static int[] rank;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        mat = new int[N][N];
        rootSum = new int[N*N];     // 각 루트의 인구수 합
        
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        int count = 0;
        boolean flag;       // 인구 이동 일어났는지    
        while (true) {
            makeSet();
            flag = false;
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    for (int d=0; d<4; d++) {
                        int nr = r+dy[d];
                        int nc = c+dx[d];
                        if (nr<0 || nc<0 || nr >= N || nc >= N) continue;   // 범위나감
                        int idx1 = r*N + c;
                        int idx2 = nr*N + nc;                        
                        if (find(idx1) == find(idx2)) continue;     // 이미 국경열림
                        
                        if (canMove(idx1, idx2)) {       // 국경열 수 있는지 확인
                            flag = true;
                            rootSum[find(idx1)] += rootSum[find(idx2)];
                            union(idx1, idx2);    // 국경열기
                        }
                    }
                }   // 국경문 열기 완료
            }
            if (!flag) break;   // 인구이동 없으면 종료
            else count++;            // 인구이동 수행함
            
            // 인구수 업데이트
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    int idx = r*N + c;
                    mat[r][c] = rootSum[find(idx)] / rank[find(idx)];
                }
            }

        }
        
        System.out.println(count);
        
    }
    
    static boolean canMove(int idx1, int idx2) {
        int popul1 = getPopul(idx1);
        int popul2 = getPopul(idx2);
        int diff = Math.abs(popul1-popul2);
        if (diff >= L && diff <= R) return true;
        else return false;
    }
    
    static int getPopul(int idx) {
        int root = find(idx);
        int r = idx/N;
        int c = idx%N;
        return mat[r][c];
    }
    
    static void makeSet() {
        root = new int[N*N];
        rank = new int[N*N];        // 각 연합국의 나라 갯수
        for (int i=0; i<N*N; i++) {
            root[i] = i;
            rank[i] = 1;
            rootSum[i] = mat[i/N][i%N];
        }
    }
    
    static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
    
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        
        root[rootB] = rootA;
        rank[rootA] += rank[rootB];     // 연합국 개수 더하기
        
        return true;
    }
    
}