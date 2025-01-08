import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int result;
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                set.clear();
            } else {
                if (!set.contains(log)) {
                    set.add(log);
                    result++;
                }
            }
        }
        
        System.out.println(result);
        
    }
}