import java.util.*;
import java.io.*;

public class Main {

	static int L;
	static char[] arr;
	static long result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();

		result = (int) arr[0] - 'a' + 1; // 맨 앞 자리

		for (int i = 1; i < L; i++) {
			int a = (int) arr[i] - 'a' + 1;

			long tmp = 1;
			for (int j = 1; j <= i; j++) {
				tmp = tmp * 31 % 1_234_567_891; // 모듈러 연산
			}
			result += a * tmp;
		}

		System.out.println(result % 1_234_567_891);

	}
}