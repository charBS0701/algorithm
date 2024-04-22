// 1427 소트인사이드
// https://www.acmicpc.net/problem/1427

import java.io.*;
import java.util.*;

public class Main {
	
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = br.readLine().toCharArray();
		Arrays.sort(arr);
		
		for (int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}