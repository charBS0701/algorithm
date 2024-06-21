class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int endTime = attacks[attacks.length-1][0];
        int attackCnt = 0;
        int bandCnt = 0;
        int maxHealth = health;
        
        for (int t=1; t<=endTime; t++) {           
            // 공격받는 시간이면
            if (attacks[attackCnt][0] == t) {
                health -= attacks[attackCnt++][1];
                bandCnt = 0;
                
                // 죽으면 탈출
                if (health <= 0) {  
                    health = -1;
                    break;
                }                  
            } else {    // 붕대감기
                health += bandage[1];
                bandCnt++;
                if (bandCnt == bandage[0]) {    // 시전시간 끝
                    health += bandage[2];   // 추가회복
                    bandCnt = 0;
                }
                // 최대체력을 못 넘김
                if (health > maxHealth) health = maxHealth;
            }
            
        }
        
        return health;
    }
}