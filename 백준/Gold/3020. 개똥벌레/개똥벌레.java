import java.io.*;
import java.util.*;

public class Main {
    
    static int N, H;
    static int[] bot, top;
    static int[] botSum, topSum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 2 <= 200_000
        H = Integer.parseInt(st.nextToken());   // 2 <= 500_000
        bot = new int[H+2];
        top = new int[H+2];
        botSum = new int[H+2];
        topSum = new int[H+2];
        
        for (int n=0; n<N; n++) {
            int h = Integer.parseInt(br.readLine());
            if (n%2 == 0) {
                bot[h]++;
            } else {
                top[H-h+1]++;
            }
        }
        
        for (int h=1; h<=H; h++) {
            topSum[h] = topSum[h-1] + top[h];
        }
        for (int h=H; h>0; h--) {
            botSum[h] = botSum[h+1] + bot[h];
        }
        
        int heightCnt = 0;
        int minCount = 200_000;
        
        for (int h=1; h<=H; h++) {
            int tmp = 0;
            tmp = botSum[h] + topSum[h];
            if (tmp < minCount) {
                minCount = tmp;
                heightCnt = 1;
            } else if (tmp == minCount) {
                heightCnt++;
            }
        }
        
        System.out.println(minCount + " " + heightCnt);
        
    }
}