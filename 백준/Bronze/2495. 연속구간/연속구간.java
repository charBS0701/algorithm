import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			String s = sc.next();
			int max=1;
			int tmp=1;
			for(int n=1; n<8; n++) {
				if (s.charAt(n-1)==s.charAt(n)) {
					tmp++;
					max = Math.max(max, tmp);
				} else {
					max = Math.max(max, tmp);
					tmp=1;
				}
			}
			System.out.println(max);
		}
	}	
}