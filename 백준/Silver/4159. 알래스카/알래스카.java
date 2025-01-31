import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            list.clear();
            boolean flag = true;
            N = Integer.parseInt(br.readLine());
            if (N==0) {
                break;
            }
            
            for (int n=0; n<N; n++) {
                int loc = Integer.parseInt(br.readLine());
                list.add(loc);
            }
            
            Collections.sort(list);
            
            // 마지막 충전소와 델타 정션의 왕복거리가 200보다 크면 실패
            if ( (1422 - list.get(N-1)) * 2 > 200) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }
            
            // n이 1이하일 경우는 이미 걸러짐
            for (int n=1; n<N; n++) {
                if (list.get(n) - list.get(n-1) > 200) {
                    sb.append("IMPOSSIBLE").append("\n");
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                sb.append("POSSIBLE").append("\n");
            }
            
        }
        
        System.out.println(sb);
    
    }
}