import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		char[] cArr = new char[s.length()];
		
		// s = s.toUpperCase();
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				cArr[i] = (char)(s.charAt(i) - ('a'-'A'));
			} else cArr[i] = s.charAt(i);
		}
//		System.out.println(String.valueOf(cArr));
		
		int[] cnt = new int[30];
		
		for (int i = 0; i<cArr.length; i++) {
			int idx = cArr[i] - 'A';
			cnt[idx]++;
		}
		
		int maxIdx = 0;
		boolean dup = false;
		for (int i=1; i<30; i++) {
			if (cnt[i] > cnt[maxIdx]) {
				maxIdx = i;
				dup = false;
			}
			else if (cnt[i] == cnt[maxIdx]) {
				dup = true;
			}
		}
		
		if (dup) System.out.println('?');
		else System.out.println((char)(maxIdx+'A'));
	}	
}