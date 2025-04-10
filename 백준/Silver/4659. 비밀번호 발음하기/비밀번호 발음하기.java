import java.io.*;
import java.util.*;

public class Main
{
    static Set<Character> mo = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mo.add('a');
		mo.add('e');
		mo.add('i');
		mo.add('o');
		mo.add('u');
		
		while (true) {
		    String s = br.readLine();
		    if (s.equals("end")) break;
		    boolean flag = false;
		    
		    int moCnt = 0;
		    int jaCnt = 0;
		    char pre = ' ';
		    
		    for (int i=0; i<s.length(); i++) {
		        char c = s.charAt(i);
		        
		        // 1. 모음 포함
		        if (mo.contains(c)) flag = true;        
		        
		        // 3. 연속 체크
		        if (c == pre && c != 'e' && c != 'o') {                         
		            flag = false;
		            break;
		        }
		        pre = c;
		        
		        // 2. 모자 연속 3번 체크
		        if (mo.contains(c)) {       
		            moCnt++;
		            jaCnt = 0;
		        } else {
		            jaCnt++;
		            moCnt = 0;
		        }
		        
		        if (moCnt >= 3 || jaCnt >= 3) {
		            flag = false;
		            break;
		        }
		    }
		    
		    
		    if (flag) {
		        sb.append("<").append(s).append(">").append(" is acceptable.").append("\n");    
		    } else {
    		    sb.append("<").append(s).append(">").append(" is not acceptable.").append("\n");
		    }
		    
		}
		
		
		System.out.println(sb);
		
	}
}

