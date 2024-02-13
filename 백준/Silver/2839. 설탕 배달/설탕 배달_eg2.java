package basic;

import java.util.Scanner;

// greedy => 확신이 안 선다 . . . . 
// 특정 시점에서 항상 최상의 선택
// 되도록 5를 쓸 수 있으면 5를 쓰고 그렇지 않으면 3을 쓴다.
// 생각 0 : 오답 (떨어지는 수와 그렇지 않은 수에 대한 고려)
// 생각 1 : 5을 뺄 수 있으면 3보다 5를 뺀다. <= 11 -> 6 -> 1 ==> -1??? 3+3+5 가능
// 생각 2 : 5를 최대한 쓴다 ? => 5로 나누어 떨어지는 수에 근접하도록??
//			=> 일단 5로 나누어 떨어지는 지 확인 (최선)
//			=> 3을 사용 하고 다시 5로 나누어 떨어지는 지 확인 (최선) <= 반복

public class 설탕배달_eg2 {
	
	static int N, count;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = 0;	// 5 또는 3을 사용한 횟수
		
		// 풀이
		while(true) {
			if (N < 0) {
				System.out.println(-1);
				break;
			}
			
			if (N%5 == 0) {
				System.out.println(count + N / 5);
				break;
			} else {
				N -= 3;
				count++;
			}
		}
		
		sc.close();
	}
}

