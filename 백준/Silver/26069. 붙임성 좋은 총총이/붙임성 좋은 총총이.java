import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        set.add("ChongChong");
        
        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String man1 = st.nextToken();
            String man2 = st.nextToken();
            
            if (set.contains(man1)) {
                set.add(man2);
            } else if (set.contains(man2)) {
                set.add(man1);
            }
         
        }
        
        System.out.println(set.size());
        
    }
    
}