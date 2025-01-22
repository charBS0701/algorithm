import java.io.*;
import java.util.*;

class Main {
    
    static int N, len;
    static char[] answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            String s = br.readLine();
            if (n==0) {
                answer = s.toCharArray();
                len = s.length();
                continue;
            }
            
            for (int i=0; i<len; i++) {
                if (answer[i] == '?') continue;
                if (answer[i] != s.charAt(i)) {
                    answer[i] = '?';
                }
            }
            
        }
        
        System.out.println(String.valueOf(answer));
        
    }
    
}