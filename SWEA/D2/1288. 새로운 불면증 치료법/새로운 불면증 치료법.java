import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int goal = (1<<10)-1;
			int now = 0;
			
			for (result = 1; goal != now; result++) {
				int num = N*result;
				while (num != 0) {
					int tmp = num % 10;
					now = (1<<tmp) | now;
					num /= 10;
				}
			}
			
			
			sb.append("#").append(t).append(" ").append((result-1)*N).append("\n");
		}
		
		System.out.println(sb);

	}

}	