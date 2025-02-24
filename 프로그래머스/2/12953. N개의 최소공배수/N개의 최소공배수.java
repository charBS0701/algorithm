class Solution {
    public long solution(int[] arr) {
        long answer = arr[0];
        
        for (int a : arr) {
            answer = lcm(answer, a);
        }
        
        return answer;
    }
    
    static long lcm(long a, long b) {
        return a * b / gcd(a,b);
    }
    
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}