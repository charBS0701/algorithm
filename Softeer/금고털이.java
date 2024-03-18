import java.io.*;
import java.util.*;

public class Main {
    static List<Stone> arr = new ArrayList<>();
    static int W, N, result, bag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken());
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr.add(new Stone(m,p));
        }

        Collections.sort(arr, (o1,o2) -> (int)(o2.p - o1.p)); 

        for (Stone now : arr) {
            if (bag + now.m <= W) {
                result += now.p * now.m;
                bag += now.m;
            } else {
                int more = W-bag;  // 더 담을 수 있는 무게
                result += more*now.p;
                bag += more;
                break;
            }
        }

        System.out.println(result);
        
    }

    static class Stone {
        int m, p;
        public Stone(int m, int p) {
            this.m = m;
            this.p = p;
        }

    }
}
