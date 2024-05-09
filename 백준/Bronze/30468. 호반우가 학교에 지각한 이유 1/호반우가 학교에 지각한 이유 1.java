import java.io.*;
import java.util.*;

public class Main {
	static int N, sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(st.nextToken());
		System.out.println(N*4 <= sum ? 0 : N*4-sum);
	}
}
