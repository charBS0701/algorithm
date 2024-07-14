import java.util.*;
import java.io.*;

class Main {
    static int E;    // E : 1~15
    static int S;   // S : 1~28
    static int M;   // M : 1~19
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goalE = Integer.parseInt(st.nextToken());
        int goalS = Integer.parseInt(st.nextToken());
        int goalM = Integer.parseInt(st.nextToken());
        
        for (int year=1; ; year++) {
            E = E<15 ? E+1 : 1;
            S = S<28 ? S+1 : 1;
            M = M<19 ? M+1 : 1;
            if (E==goalE && S==goalS && M==goalM) {
                System.out.println(year);
                break;
            }
        }

    }
}