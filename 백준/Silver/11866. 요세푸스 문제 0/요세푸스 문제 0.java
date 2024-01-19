import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for (int n=0; n<N; n++) {
			arr[n] = n+1;
		}
		System.out.print("<");
		
		// K 번째 사람 제거
		int idx=0;
		for (int n=0; n<N; n++) {	// N 명 제거 반복
			int count = 0;
			while (true) {
				if (idx==N) idx=0; // 인덱스 벗어나면 0으로
				if (arr[idx]==0) {	// 비어있는 곳이면 다음 인덱스로
					idx++;
					continue;
				}
				
				// 비어있는 곳이아니면 카운트 증가
				count++;
				if (count == K) { 	// 카운트가 꽉 차면 해당 인덱스 값 제거
					System.out.print(arr[idx]);
					if (n!=N-1) System.out.print(", ");
					arr[idx] = 0;
					idx++;
					break;
				} else {	// 카운트가 안 찼으면 다음 인덱스로
					idx++;
				}
			}
		}
		
		System.out.print(">");
	}
}