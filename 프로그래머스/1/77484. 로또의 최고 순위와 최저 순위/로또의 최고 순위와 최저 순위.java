class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int hit = 0;
        int zero = 0;
        for (int i=0; i<6; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j=0; j<6; j++) {
                if (lottos[i] == win_nums[j]) {
                    hit++;
                    break;
                }
            }
        }
        
        int[] answer = new int[2];  // 최고히트, 최저히트
        answer[0] = hit + zero;
        answer[1] = hit;
        
        // 등수로 치환
        answer[0] = answer[0] >= 2 ? 7-answer[0] : 6;
        answer[1] = answer[1] >= 2 ? 7-answer[1] : 6;
        
        return answer;
    }
}