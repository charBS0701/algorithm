import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static char[] arr;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        
        for (int n=0; n<N; n++) {
            if (arr[n] == 'P') {
                for (int k=-K; k<=K; k++) {
                    int idx = n+k;
                    if (idx<0 || idx>=N) continue;
                    if (arr[idx] == 'H') {
                        arr[idx] = 'X';
                        answer++;
                        break;
                    }
                }
            }
        }
        
        System.out.println(answer);
        
    }

}