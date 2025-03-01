import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int N, int[][] computers) {
        int answer = 0;
        visited = new boolean[N];
        
        for (int n=0; n<N; n++) {
            if (visited[n]) continue;
            dfs(n, computers, N);
            answer++;
        }
        
        return answer;
    }
    
    static void dfs(int start, int[][] computers, int N) {
        visited[start] = true;
        for (int i=0; i<N; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                dfs(i, computers, N);
            }
        }
    }
}