
// 18110 solved.ac
// https://www.acmicpc.net/problem/18110
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		// 15%
		int per = (int) Math.round(N * 0.15);

		for (int i = per; i < N - per; i++) {
			result += arr[i];
		}
		
		result = (int) Math.round((float)result / (N - (per * 2)));
		
		System.out.println(result);
	}

}