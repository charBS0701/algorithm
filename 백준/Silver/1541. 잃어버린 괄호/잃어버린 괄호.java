import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String s;
	static int result;
	static int[] nums = new int[50];
	static char[] opers = new char[50];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine();
		int numCnt= 0;
		int operCnt = 0;
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c>='0' && c<='9') {
				sb.append(c);
			} else {
				opers[operCnt++] = c;
				nums[numCnt++] = Integer.valueOf(sb.toString());
				sb = new StringBuilder();
			}
		}
		nums[numCnt++] = Integer.valueOf(sb.toString());	// 마지막 수 처리
		
		// 풀이
		result += nums[0];	// 첫 수 처리
		// - 가 나오면 괄호를 열다음 - 가 나오거나 끝에 괄호를 닫는다
		boolean minusFlag = false;
		for(int i=0; i<numCnt; i++) {
			if (opers[i] == '+') {
				if (minusFlag) {
					result -= nums[i+1];
				} else result += nums[i+1];
			} else if (opers[i] == '-') {
				minusFlag = true;
				result -= nums[i+1];
			}
		}
		
		System.out.println(result);
	
	}
}

