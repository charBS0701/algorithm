import java.io.*;
import java.util.*;

class Main {
    
    static String s;
    static char c = 'z'+1;
    static String answer = String.valueOf(c);
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int len = s.length();        
        
        StringBuilder sb;
        
        for (int i=1; i<len-1; i++) {
            StringBuilder first = new StringBuilder(s.substring(0,i));
            first = first.reverse();
            
            for (int j=i+1; j<len; j++) {
                sb = new StringBuilder();
                
                StringBuilder second = new StringBuilder(s.substring(i,j));
                StringBuilder third = new StringBuilder(s.substring(j));
                second = second.reverse();
                third = third.reverse();
                
                sb.append(first);
                sb.append(second);
                sb.append(third);
                
                answer = answer.compareTo(sb.toString()) <= 0 ? answer : sb.toString();
                
            }
        }
        
        System.out.println(answer);
        
        
    }
    
}