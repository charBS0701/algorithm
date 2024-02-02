import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] input;
	static int cnt1, cnt2, cnt3, cnt4;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {		// 10번의 테스트
			sb.append("#").append(t).append(" ");
			Deque<Character> stack = new ArrayDeque<>();
			int len = Integer.parseInt(br.readLine());
			cnt1 = 0;	// ()
			cnt2 = 0; 	// []
			cnt3 = 0;	// {}
			cnt4 = 0;	// <>
			input = br.readLine().toCharArray();
			
			int flag = 1;
			for (int i = 0; i < input.length; i++) {	// 한 글자씩 검사
				switch(input[i]) {
					case '(' :
						cnt1++;
						stack.push(input[i]);
						break;
					case '[' :
						cnt2++;
						stack.push(input[i]);
						break;
					case '{' :
						cnt3++;
						stack.push(input[i]);
						break;
					case '<' :
						cnt4++;
						stack.push(input[i]);
						break;
						
					case ')' :
						cnt1--;
						if(cnt1 < 0 || stack.pop() != '(') {
							flag = 0;
							break;
						}
						break;
					case ']' :
						cnt2--;
						if(cnt2 < 0 || stack.pop() != '[') {
							flag = 0;
							break;
						}
						break;
					case '}' :
						cnt3--;
						if(cnt3 < 0 || stack.pop() != '{') {
							flag = 0;
							break;
						}
						break;
					case '>' :
						cnt4--;
						if(cnt4 < 0 || stack.pop() != '<') {
							flag = 0;
							break;
						}
						break;
				}	// switch 끝
				if (flag == 0) break;
			}	// 글자 검사 끝
			if ( !(stack.isEmpty()) ) {	// 비어 있지 않으면 1
				sb.append(0);
			} else if (flag == 1) sb.append(1);
			else if (flag == 0) sb.append(0);
	
			sb.append("\n");	// 케이스 끝
			
		}
		System.out.println(sb);
	}
}
