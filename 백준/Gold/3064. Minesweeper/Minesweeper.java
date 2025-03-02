import java.io.*;
import java.util.*;

public class Main {
    
    static int T, N;
    static char[][] mat;
    static int[] dy = new int[]{-1,-1,-1,0,0,1,1,1};
    static int[] dx = new int[]{-1,0,1,-1,1,-1,0,1};
    static int answer;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            mat = new char[N][N];
            for (int n=0; n<N; n++) {
                mat[n] = br.readLine().toCharArray();
            }
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i != 0 && j != 0 && i != N-1 && j != N-1) continue;     // 숫자 적힌 칸만
                    
                    int candiCnt = 0;   // 폭탄 후보
                    int bombCnt = 0;    // 폭탄 확실
                    
                    for (int d=0; d<8; d++) {   // 주변 나온 폭탄 수, 더 나올 수 있는 후보 세기
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny <= 0 || nx <= 0 || ny >= N-1 || nx >= N-1) continue;
                        if (mat[ny][nx] == '#') candiCnt++;
                        else if (mat[ny][nx] == '*') bombCnt++;
                    }
                    
                    if (mat[i][j] == '0') {
                        for (int d=0; d<8; d++) {   
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny <= 0 || nx <= 0 || ny >= N-1 || nx >= N-1) continue;
                            mat[ny][nx] = '-';
                        }                    
                    } else if (candiCnt + bombCnt == Integer.valueOf(Character.toString(mat[i][j]))) {  // 후보 다 폭탄 확실
                        for (int d=0; d<8; d++) {   
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny <= 0 || nx <= 0 || ny >= N-1 || nx >= N-1 || mat[ny][nx] == '-') continue;
                            mat[ny][nx] = '*';
                        }                    
                    } else if (bombCnt == Integer.valueOf(Character.toString(mat[i][j]))) {  // 이미 폭탄 다 나옴 -> 후보엔 다 없음
                        for (int d=0; d<8; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny <= 0 || nx <= 0 || ny >= N-1 || nx >= N-1 || mat[ny][nx] == '*') continue;
                            mat[ny][nx] = '-';
                        }                    
                    }
                }
            }
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (mat[i][j] == '*' || mat[i][j] == '#') answer++;
                }
            }            
            
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
        
    }
}