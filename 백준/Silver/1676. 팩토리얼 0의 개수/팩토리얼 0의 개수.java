// 1676 팩토리얼 0의 개수
// https://www.acmicpc.net/problem/1676

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int two, five;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
        	int n = i;
			while (n%2==0 || n%5==0) {
				if (n%2==0) {
					n/=2;
					two++;
				}
				if (n%5==0) {
					n/=5;
					five++;
				}
			}
		}
        
        System.out.println(Math.min(two, five));
        
    }
}