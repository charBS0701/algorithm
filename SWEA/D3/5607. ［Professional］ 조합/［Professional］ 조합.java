import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, R, P;
    static long ans;
    static long[] factMod;  // factMod[3] = 3  < 3을 P로 나눈 나머지가 3
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        
        P = 1234567891;
        long aaa = pow(2, 14);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        P = 1234567891;
        factMod = new long[1_000_001];
        // dp 로 factMod 채운다
        factMod[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factMod[i] = (factMod[i-1]*i) % P;
        }
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            
            // nCr
            //       n!                    1
            //------------- ==> n! * ----------  ==> n! % p * ( (n-r)! * r! ) ^ p-2
            // (n-r)! * r!           (n-r)! * r! 
            long top = factMod[N];
            long bottom = (factMod[N-R] * factMod[R]) % P; 
            // 1/bottom = bottom ^(p-2)
            ans = (top * pow(bottom, P-2))%P;
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    // 2^16
    // Math.pow() 는 overflow
    // 제곱하면서 계속 P 로 나눈 나머지를 취하는 방식
    static long pow(long base, long expo) { // 2^3 pow(2, 3) => 2*2*2 return
        if( expo == 0 ) return 1;
        else if( expo == 1 ) return base;
        
        long num = 1;
        
        while( expo > 0 ) {
            
            if( expo % 2 == 1 ) { // 맨 마지막에 지수가 1이될 때 num 에 base 계산 값을 저장
                num *= base; // 계산 중간에 expo가 홀수가 되면 뒤의 expo / 2 에서 1 손해발생 이를 미리 보정해 준다.
                num %= P;
            }
            base = (base*base) % P;
            expo /= 2;
        }
        return num;
    }
}