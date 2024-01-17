import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();	// 가지고 있는 랜선 개수	1<= K <= 	  10,000
		int N = sc.nextInt();	// 필요한 랜선 개수 		1<= K <= N <= 1,000,000
		
		int[] wires = new int[K];
		for (int k=0; k<K; k++) {
			wires[k] = sc.nextInt();
		}
		
		long from=1;
		long to=(long)Math.pow(2, 31)-1;
		
		long mid; // 중간값을 저장할 변수를 추가하였습니다.
		while (from <= to) {
		    mid = (from + to) / 2;
		    long total = 0;
		    for (int i = 0; i < K; i++) {
		        total += wires[i] / mid;
		    }
		    if (total < N) {
		        to = mid - 1;
		    } else {
		        from = mid + 1;
		    }
		}
		System.out.println(from - 1);
	}
}