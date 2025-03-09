import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int N = park.length;
        int M = park[0].length;
        Arrays.sort(mats);
        
        for (int i=mats.length-1; i>=0; i--) {
            int size = mats[i];
            
            if(check(park, N, M, size)) {
                answer = size;
                break;
            }
        }
            
        return answer;
    }
    
    static boolean check(String[][] park, int N, int M, int size) {
        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                if (!park[n][m].equals("-1")) continue;
                if (n+size > N || m+size > M) continue;

                boolean flag = true;
                
                for (int n2=n; n2<n+size; n2++) {
                    for (int m2=m; m2<m+size; m2++) {
                        if (!park[n2][m2].equals("-1")) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                
                if (flag) return true;

            }
        }  
        return false;
    }
}