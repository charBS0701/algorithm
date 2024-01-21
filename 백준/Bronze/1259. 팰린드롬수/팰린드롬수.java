import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int num = sc.nextInt();
			if (num==0) break;
			
			String s = Integer.toString(num);
			boolean result = isPal(s);
			if (result) System.out.println("yes");
			else System.out.println("no");
		}

	}
	
	public static boolean isPal(String s) {
		for (int i=0; i <= s.length()/2 - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;		
			}
		}
		return true;
	}

}