import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int D = sc.nextInt();
		
		s+=D;
		
		while (s>=60) {
				m++;
				s-=60;
		}
		
		while (m>=60) {
				h++;
				m-=60;
		}
		
		while (h>=24) {
			h-=24;
		}
		
		System.out.println(h + " " + m + " " + s);
	}	
}