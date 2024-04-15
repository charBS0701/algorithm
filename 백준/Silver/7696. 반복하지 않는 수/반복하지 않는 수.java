// 1676 팩토리얼 0의 개수
// https://www.acmicpc.net/problem/1676

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int idx = 1;
    static int[] memoi = new int[1_000_001];
    static boolean[] visit = new boolean[10]; ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int num = 1;
        while (idx <= 1_000_000) {
            if (isValid(num)) memoi[idx++] = num;
            num++;
        }
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb);
                return;
            } else
                sb.append(memoi[N]).append("\n");
        }
    }
    
    static boolean isValid(int n) {
        int tmp = n;
        Arrays.fill(visit,false);
        while(tmp != 0) {
            int now = tmp % 10;
            if (visit[now]) return false;    
            visit[now] = true;
            tmp /= 10;
        }
        return true;
    }
}