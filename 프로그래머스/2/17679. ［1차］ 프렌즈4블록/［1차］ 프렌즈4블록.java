import java.util.*;

class Solution {
    static int answer;
    static int prev;
    static char[][] mat;
    public int solution(int m, int n, String[] board) {
        mat = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = board[m-1-i].charAt(j);
            }
        }
        
        while (true) {
            boolean flag = false;   // 블록 지움 플래그
            // 복사본 생성
            char[][] copy = new char[m][n];
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    copy[i][j] = mat[i][j];
                }
            }            
            
            // 같은블록 찾기
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    char c = mat[i][j];
                    if (c == '-') continue;
                    if (c == mat[i][j+1] && c == mat[i+1][j] && c == mat[i+1][j+1]) {
                        if (copy[i][j] != '-') {
                            flag = true;        // 지운 행위를 함
                            answer++;           // 지운 갯수 증가
                            copy[i][j] = '-';   // 없어짐 처리
                        }
                        if (copy[i][j+1] != '-') {
                            flag = true;        // 지운 행위를 함
                            answer++;           // 지운 갯수 증가
                            copy[i][j+1] = '-';   // 없어짐 처리
                        }
                        if (copy[i+1][j] != '-') {
                            flag = true;        // 지운 행위를 함
                            answer++;           // 지운 갯수 증가
                            copy[i+1][j] = '-';   // 없어짐 처리
                        }
                        if (copy[i+1][j+1] != '-') {
                            flag = true;        // 지운 행위를 함
                            answer++;           // 지운 갯수 증가
                            copy[i+1][j+1] = '-';   // 없어짐 처리
                        }                        
                    }
                }
            }
            
            if (!flag || prev == answer) break;   // 블럭을 안지웠으면 종료      
            
            // 다 돌았으면 업데이트
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (copy[i][j] == '-') {    // 없어진 곳이면 채우기
                        mat[i][j] = '-';
                        for (int k=i+1; k<m; k++) {
                            if (copy[k][j] != '-') {
                                mat[i][j] = copy[k][j];
                                copy[k][j] = '-';
                                mat[k][j] = '-';
                                break;
                            } else {
                                mat[k][j] = '-';
                            }
                        }
                    }
                }
            }                
        }
        
        
        return answer;
    }
}