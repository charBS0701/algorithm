import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i=0; i<test_case; i++) {
			String s = sc.next();
			int conseq = 1; // 연속
			int result = 0;
			for (int idx=0; idx<s.length(); idx++) {
				if (s.charAt(idx)=='O') {
					result += conseq++;
				} else if (s.charAt(idx)=='X') {
					conseq = 1;
				}
			}
			System.out.println(result);
		}
	}	
}