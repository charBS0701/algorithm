import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();	// 10,000 이하 자연수 
		int b = sc.nextInt();	// 10,000 이하 자연수
		
		// 최대공약수
		int gcd = getGcd(a,b);
		System.out.println(gcd);

		// 최소공배수
		int lcm = getLcm(a,b);
		System.out.println(lcm);
	}
		
	public static int getGcd(int a, int b) {
		if (b == 0) return a;
		else return getGcd(b, a%b);
	}
	
	public static int getLcm(int a, int b) {
		return a * b / getGcd(a,b);
	}

}