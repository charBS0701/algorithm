import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = 0;
        for(int i=0; i<8; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (i == 0 && (n!=1 && n!=8)) {
                System.out.println("mixed");
                return;
            } else if (i!=0) {
                if (Math.abs(prev-n) != 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            
            prev = n;
            
            if (i==7) {
                if (n == 8) System.out.println("ascending");
                else if (n == 1) System.out.println("descending");
            }
            
        }
        
    }

}