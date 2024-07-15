import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] sizes;
    static int T, P;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sizes = new int[6];
        for (int i=0; i<6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
            
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        for (int i=0; i<6; i++) {
            sum += (sizes[i] + (T-1)) / T;
        }
        
        sb.append(sum).append("\n").append(N/P).append(" ").append(N%P);
        System.out.println(sb);
    }
}