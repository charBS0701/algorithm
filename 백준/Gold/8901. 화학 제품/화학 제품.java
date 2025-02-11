import java.io.*;
import java.util.*;

class Main {
    
    static int T;
    static int A, B, C;
    static int[] prices = new int[3];
    static int result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        StringTokenizer st = null;
        for (int t=0; t<T; t++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<3; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }   // 입력 끝
            
            for (int ab=0; ab <= Math.min(A,B); ab++) {
                int abP = ab * prices[0];
                for (int bc=0; bc <= Math.min(B-ab, C); bc++) {
                    int bcP = bc * prices[1];
                    int ac = Math.min(A-ab, C-bc);
                    int acP = ac * prices[2];
                    
                    result = Math.max(result, abP+bcP+acP);
                }
            }
            
            sb.append(result).append("\n");   
                
        }
        
        System.out.println(sb);
    
    }
}