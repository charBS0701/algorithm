// 2805 나무 자르기
// https://www.acmicpc.net/problem/2805

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;	
	static int[] arr;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = binary(0,1_000_000_000);
		
		System.out.println(result);
	}
	
	static int binary(int l, int r) {
		int res=0;
		while (l<=r) {
			int mid = (l+r)/2;
			if (check(mid)) {
				res = mid;
				l = mid+1;
			}
			else r = mid-1;
		}
		return res;
	}
	
	static boolean check(int num) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if (arr[i] > num) sum += arr[i]-num;
		}
		if (sum>=M) return true;
		else return false;
	}
}