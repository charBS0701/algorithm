package basic;

import java.util.Scanner;
// 재귀를 통한 완전탐색 방법 => 시간 많이 걸림
public class 설탕배달_eg {
	
	static int N, min;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		min = 5000;		// 충분히 큰 값으로 설정
		
		dfs(0,0);
		
		min = min == 5000 ? -1 : min;
		System.out.println(min);
	}
	static void dfs(int five, int three) {	// 5 사용 수, 3 사용 수
		int sum = five*5 + three*3;
		// 기저조건
		if (sum==N) {
			min = Math.min(min, five + three);	// 현재 5와 3을 사용한 횟수 min 비교 갱신
			return;
		} else if (sum > N) {
			return;
		}
		
		// 2가지 경우를 계속 따진다.
		dfs(five+1, three);
		dfs(five, three+1);
	}
}
