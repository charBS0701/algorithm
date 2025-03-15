import java.io.*;
import java.util.*;

public class Main {
    
    static int T;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t=0; t<T; t++) {
            int idx = 0;
            char[] keys = br.readLine().toCharArray();
            List<Character> list = new LinkedList<>();
            
            for (int i=0; i<keys.length; i++) {
                if (keys[i] == '<') {
                    idx = Math.max(idx-1, 0);
                } else if (keys[i] == '>') {
                    idx = Math.min(idx+1, list.size());
                } else if (keys[i] == '-') {
                    if (idx == 0) continue;
                    list.remove(--idx);
                } else {
                    list.add(idx++, keys[i]);
                }
            }
            
            Iterator<Character> iter = list.iterator();
            while (iter.hasNext()) {
                sb.append(iter.next());
            }
            sb.append("\n");
            
        }
        
        System.out.println(sb.toString());        
    }
    
}