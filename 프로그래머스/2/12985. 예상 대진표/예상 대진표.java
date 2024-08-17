class Solution
{
    static int answer = 0;
    public int solution(int n, int a, int b)
    {
        a = ((a-1) / 2) + 1;
        b = ((b-1) / 2) + 1;
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        
        int jisu = 0;
        while (n != 1) {
            n = n >> 1;
            jisu++;
        }
        
        answer++;   // 1차에서 같은 조 일 때
        while (a != b) {
            answer++;
            a = (a-1) / 2 + 1;
            b = (b-1) / 2 + 1;
        }
        
        return answer;
    }
}