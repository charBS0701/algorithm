import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			
			if (isVPS(s)) {
				System.out.println("YES");
			} else System.out.println("NO");
		}
	}
	
	public static boolean isVPS(String s) {
		int cntOpen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') cntOpen++;
			else {
				if (cntOpen <= 0) return false;
				cntOpen--;
			}
		}
		if (cntOpen != 0) return false;
		
		return true;
	}
}