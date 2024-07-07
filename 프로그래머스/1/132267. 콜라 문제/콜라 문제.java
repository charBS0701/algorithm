class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int have = n;
        
        while (have >= a) {
            int get = have/a*b;
            answer += get;
            have = have%a + get;
        }
        return answer;
    }
}