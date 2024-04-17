// 11727 2×n 타일링 2
// https://www.acmicpc.net/problem/11727

import java.io.*;
import java.util.*;

public class Main {
	static int N;	// 1 <= N <= 1000
	static int[] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		memoi = new int [N+1];
		
		memoi[1] = 1;
		if (N==1) { 
			System.out.println(memoi[N]);
			return;
		}
		
		memoi[2] = 3;
		if (N==2) { 
			System.out.println(memoi[N]);
			return;
		}
		
		
		for (int i = 3; i <= N; i++) {
			memoi[i] = (memoi[i-1] + memoi[i-2]*2) % 10007;
		}
		
		System.out.println(memoi[N]);
		
	}
	
}