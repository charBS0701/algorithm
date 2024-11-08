import java.util.*;
import java.io.*;

class Main {
    
    static int N, L;
    static int answer;
    static List<Integer> holes = new ArrayList<>();
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 물이 새는 곳 수
        L = Integer.parseInt(st.nextToken());   // 테이프의 길이
    
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            holes.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(holes);
        
        int prev = -10000;
        while(!holes.isEmpty()) {
            int hole = holes.remove(0);
            
            if (hole - prev + 1 <= L) {
                continue;
            } else {
                answer++;
                prev = hole;
            }
        }
        
        System.out.println(answer);
    }
}