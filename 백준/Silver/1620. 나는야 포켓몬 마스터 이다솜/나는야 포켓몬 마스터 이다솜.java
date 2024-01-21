import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 포켓몬의 개수 // 1<= <=100,000
		int M = sc.nextInt(); // 맞춰야 하는 문제 수 // 1<= <=100,000
		
		Map<Integer, String> dic1 = new HashMap<>();		// 포켓몬 도감
		Map<String, Integer> dic2 = new HashMap<>();		// 포켓몬 도감
		
		for (int n = 1; n <= N; n++) {
			String name = sc.next();
			dic1.put(n,name);	// 도감 입력
			dic2.put(name, n);	// 도감 입력
		}
		
		for (int m = 0; m < M; m++) {
			String q = sc.next();	// 문제 입력 // 알파벳 or 번호
			
			// 숫자를 입력받은경우		// O(n)
			if (q.charAt(0) >= '0' && q.charAt(0) <= '9') {
				Integer idx = Integer.valueOf(q);
				System.out.println(dic1.get(idx));
			} else {	// 알파뱃을 입력받은경우
				System.out.println(dic2.get(q));
			}		
		}		
    }	
}