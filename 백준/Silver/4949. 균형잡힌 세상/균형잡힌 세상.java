import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static Deque<Character> stack = new ArrayDeque<>();
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			stack.clear();
			flag = true;
			char[] arr = br.readLine().toCharArray();
			if (arr[0] == '.')
				break;
			for (char c : arr) {
				if (c == '(' || c == '[')
					stack.push(c);
				else if (c == ')' || c == ']') {
					if (stack.size() == 0)
						flag = false;
					else {
						char top = stack.pop();
						if (c == ')') {
							if (top != '(')
								flag = false;
						} else if (c == ']') {
							if (top != '[')
								flag = false;
						}
					}
				}
				if (!flag)
					break;
			}
			if (stack.size()!=0) flag = false;
			sb.append(flag ? "yes" : "no").append("\n");

		}
		System.out.println(sb);
	}

}
