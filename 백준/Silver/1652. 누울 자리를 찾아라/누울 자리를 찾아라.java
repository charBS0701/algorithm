import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static char[][] mat;
    static int rowCan, colCan;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new char[N][N];
        
        for (int r=0; r<N; r++) {
            String s = br.readLine();
            for (int c=0; c<N; c++) {
                mat[r][c] = s.charAt(c);
            }
        }
        
        // 가로 검사
        for (int r=0; r<N; r++) {
            boolean isEmpty = false;
            boolean blocked = true;
            for (int c=0; c<N; c++) {
                if (mat[r][c] == '.') {
                    if (blocked && !isEmpty) {
                        isEmpty = true;
                    } else if (blocked && isEmpty) {
                        rowCan++;
                        blocked = false;
                    }
                } else {
                    isEmpty = false;
                    blocked = true;
                }
            }
        }    
        
        // 세로 검사
        for (int c=0; c<N; c++) {
            boolean isEmpty = false;
            boolean blocked = true;
            for (int r=0; r<N; r++) {
                if (mat[r][c] == '.') {
                    if (blocked && !isEmpty) {
                        isEmpty = true;
                    } else if (blocked && isEmpty) {
                        colCan++;
                        blocked = false;
                    }
                } else {
                    isEmpty = false;
                    blocked = true;
                }
            }
        }          
        
        
        System.out.println(rowCan + " " + colCan);
    }
}