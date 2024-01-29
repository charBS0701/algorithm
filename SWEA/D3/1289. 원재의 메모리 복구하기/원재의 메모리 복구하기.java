import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			char[] mem = br.readLine().toCharArray();
			int count = 0;
			int idx = 0;
			for (int i = 0; i < mem.length; i++) {	// 처음 1 찾기
				if (mem[i] == '1') {
					count++;
					idx = i;
					break;
				}
			}
			
			for (int i = idx+1; i < mem.length; i++) {	// 다른 수가 나올 때마다 count++
				if (mem[i] != mem[i-1]) {
					count++;
				}
			}		
			
			
			
			System.out.println("#" + t + " " + count);
		}
	}

}
