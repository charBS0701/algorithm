import java.io.*;
import java.util.*;

public class Main {
    
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tmpSb = new StringBuilder();
    static char[] src = new char[]{' ','+','-'};
    static char[] tgt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            tgt = new char[N-1];
            
            solve(0);
            sb.append("\n");
            
        }
        
        System.out.println(sb);
        
    }
    
    static void solve(int tgtIdx) {
        if (tgtIdx == N-1) {
            check();
            return;
        }
        
        for (int i=0; i<src.length; i++) {
            tgt[tgtIdx] = src[i];
            solve(tgtIdx+1);
        }
    }
    
    static void check() {
        tmpSb.setLength(0);
        int sum = 0;
        tmpSb.append(1);
        
        StringBuilder oper = new StringBuilder();
        oper.append(1);
        char op = '+';
        
        for (int n=0; n<N-1; n++) {
            tmpSb.append(tgt[n]).append(n+2);
            if (tgt[n] != ' ') {
                if (op == '+') {
                    sum += Integer.parseInt(oper.toString());
                    oper.setLength(0);
                    oper.append(n+2);
                    op = tgt[n];
                } else if (op == '-') {
                    sum -= Integer.parseInt(oper.toString());
                    oper.setLength(0);
                    oper.append(n+2);
                    op = tgt[n];
                }
            } else {
                oper.append(n+2);
            }
                
        }
            
        if (op == '+') sum += Integer.parseInt(oper.toString());
        else sum -= Integer.parseInt(oper.toString());        
        
        if (sum == 0) sb.append(tmpSb).append("\n");
        
    }
    
}