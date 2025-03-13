class Solution {
    
    static int answer = 0;
    static int[] servers;
    
    public int solution(int[] players, int m, int k) {
        
        servers = new int[24];
        
        for (int i=0; i<24; i++) {
            int player = players[i];
            int capa = (servers[i]+1) * m;
            if (capa <= player) {
                int diff = (player - capa) / m + 1;
                for (int j=0; j<k && i+j<24; j++) {
                    servers[i+j] += diff;
                }
                answer += diff;
            }
        }
        
        return answer;
    }
}