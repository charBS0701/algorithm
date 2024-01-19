import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 100 장 이하
		int M = sc.nextInt();	// 10~300,000
		
		// 배열에 카드 저장
		int[] cards = new int[N];
		for (int n=0; n<N; n++) cards[n] = sc.nextInt();
		
		// 3장 뽑아서 M을 넘지않고 가장 가깝게
		int tmp=0;
		int sum=0;
		for (int a=0; a<N; a++) {
			for (int b = 0; b < N; b++) {
				for (int c = 0; c < N; c++) {
					if (a==b || a==c || b==c) continue;
					tmp = cards[a]+cards[b]+cards[c];
					if (tmp <= M && tmp > sum) sum = tmp;
				}
				
			}
		}
		System.out.println(sum);
	}
}