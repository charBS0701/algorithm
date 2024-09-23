import java.io.*;
import java.util.*;
public class Main
{

    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
	    
        Character[] mArr = new Character[]{'a','i','y','e','o','u'};
        List<Character> mlist = new ArrayList<>();
        for (char c : mArr) {
            mlist.add(c);
        }
        
        Character[] jArr = new Character[]{'b','k','x','z','n','h','d','c','w','g','p','v','j','q','t','s','r','l','m','f'};
        List<Character> jlist = new ArrayList<>();	    
        for (char c : jArr) {
            jlist.add(c);
        }
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		while (s != null) {
            
            for (char c : s.toCharArray()) {
                if (!Character.isLetter(c)) {
                    sb.append(c);
                    continue;
                }
                
                boolean isBig = Character.isUpperCase(c);
                c = Character.toLowerCase(c);
                
                int idx = -1;
                char nc = '-';
                
                if (mlist.indexOf(c) != -1) {
                    idx = mlist.indexOf(c);
                    idx -= 3;
                    if (idx < 0) {
                        idx += mlist.size();
                    }
                    nc = mlist.get(idx);
                    if (isBig) nc = Character.toUpperCase(nc);
                    
                } else if (jlist.indexOf(c) != -1) {
                    idx = jlist.indexOf(c);
                    idx -= 10;
                    if (idx < 0) {
                        idx += jlist.size();
                    }
                    nc = jlist.get(idx);
                    if (isBig) nc = Character.toUpperCase(nc);
                }
                
                sb.append(nc);
                
                
            }
            
            sb.append("\n");
            s = br.readLine();
		}
        
        System.out.println(sb);
		
	}
}