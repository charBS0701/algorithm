class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int time = 0;
            for (int j = i + 1; j < len; j++) {
                time++;
                if (prices[i] > prices[j]) {
                    break;  // 가격이 떨어지면 루프 종료
                }
            }
            answer[i] = time;
        }
        
        return answer;
    }
}
