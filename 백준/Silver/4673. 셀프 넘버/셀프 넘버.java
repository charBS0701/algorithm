// 4673 셀프 넘버
// https://www.acmicpc.net/problem/4673

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[10_001];
		for (int i = 1; i <=10_000; i++) {
			int sum = i;
			int num = i;
			while (num != 0) {
				sum += num%10;
				num /= 10;
			}
			if  (sum > 10_000) continue;
			arr[sum] = true;
		}
		
		for (int i = 1; i <=10_000; i++) {
			if (!arr[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}