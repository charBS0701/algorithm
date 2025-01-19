import java.io.*;
import java.util.*;

class Main {
    
    static int T, N, level;
    static List<Integer> list, list1, list2;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t=0; t<T; t++) {
            level = 0;
            list = new ArrayList<>();
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int n=0; n<N; n++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            while(!list.isEmpty()) {
                list1.add(list.remove(0));
                if (list.isEmpty()) break;
                list2.add(list.remove(0));
            }
            
            Collections.sort(list2);
            
            for (int n=0; n<N; n++) {
                if (!list1.isEmpty()) {
                    list.add(list1.remove(0));
                    continue;
                }
                list.add(list2.remove(0));
            }
            
            level = Math.abs(list.get(0) - list.get(N-1));
            for (int n=1; n<N; n++) {
                level = Math.max(level, Math.abs(list.get(n-1) - list.get(n)));
            }
            
            sb.append(level).append("\n");
        }
        
        System.out.println(sb);
    }
}